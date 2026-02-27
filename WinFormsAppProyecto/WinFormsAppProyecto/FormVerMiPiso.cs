using Controladores;
using Microsoft.VisualBasic;
using Modelos;
using System;
using System.Globalization;
using System.Net.Http;
using System.Windows.Forms;

namespace Formularios
{
    public partial class FormVerMiPiso : Form
    {
        private Piso _piso;
        private Inquilino _inquilino;
        private TareaControlador _tareaControlador;
        private PisoControlador _pisoControlador;
        private InquilinoControlador _inquilinoControlador;
        private static HttpClient _httpClient = new HttpClient();

        public FormVerMiPiso(Inquilino inquilino, Piso piso)
        {
            InitializeComponent();
            _piso = piso;
            _inquilino = inquilino;
            _tareaControlador = new TareaControlador();
            _pisoControlador = new PisoControlador();

            _inquilinoControlador = new InquilinoControlador();
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Load += FormVerMiPiso_Load;
        }

        private async void FormVerMiPiso_Load(object sender, EventArgs e)
        {
            try
            {
                if (_inquilino == null)
                {
                    MessageBox.Show("No se proporcionó un inquilino.");
                    return;
                }

                // Seguir la misma lógica de la app Java: el piso del inquilino viene del contrato.
                var inquilinoBackend = await _inquilinoControlador.getById(_inquilino.id);
                if (inquilinoBackend?.contrato?.piso == null)
                {
                    MessageBox.Show("No tienes un piso asignado en tu contrato.");
                    return;
                }

                _inquilino = inquilinoBackend;
                _piso = _inquilino.contrato.piso;

                // Obtener datos actualizados del backend por id
                var pisoBackend = await _pisoControlador.getById(_piso.id);
                if (pisoBackend != null)
                {
                    _piso = pisoBackend;
                }

                // Mostrar datos con formato
                txtId.Text = _piso.id.ToString();

                if (_piso.direccion != null)
                {
                    txtDireccion.Text = _piso.direccion.calle;
                    txtCiudad.Text = _piso.direccion.ciudad;
                    txtProvincia.Text = _piso.direccion.provincia;
                }
                else
                {
                    txtDireccion.Text = string.Empty;
                    txtCiudad.Text = string.Empty;
                    txtProvincia.Text = string.Empty;
                }

                txtDescripcion.Text = _piso.descripcion ?? string.Empty;

                // Formato moneda para precio
                txtPrecio.Text = _piso.precio.ToString("C", CultureInfo.CurrentCulture);

                txtDisponible.Text = _piso.disponible ? "Sí" : "No";

                txtPropietario.Text = _piso.propietario != null ? $"{_piso.propietario.nombre_real} ({_piso.propietario.email})" : string.Empty;

                txtUrlImagen.Text = _piso.url_imagen ?? string.Empty;

                // Cargar imagen desde URL si existe
                if (!string.IsNullOrWhiteSpace(_piso.url_imagen))
                {
                    await CargarImagen(_piso.url_imagen);
                }
                else
                {
                    pictureBoxImagen.Image = null;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al obtener datos del piso: " + ex.Message);
            }
        }

        private async void btnAñadirTarea_Click(object sender, EventArgs e)
        {
            string descripcion = Interaction.InputBox("Descripcion de la tarea:", "Añadir tarea", "");
            if (string.IsNullOrWhiteSpace(descripcion)) return;

            try
            {
                Tarea nueva = new Tarea
                {
                    descripcion = descripcion,
                    piso = _piso
                };

                await _tareaControlador.add(nueva);
                MessageBox.Show("Tarea añadida correctamente.");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al añadir la tarea: " + ex.Message);
            }
        }

        private async Task CargarImagen(string urlImagen)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(urlImagen))
                {
                    MessageBox.Show("La URL de la imagen está vacía.");
                    pictureBoxImagen.Image = null;
                    return;
                }

                // Caso 1: Base64 (data URI)
                if (urlImagen.StartsWith("data:image"))
                {
                    var base64 = urlImagen.Substring(urlImagen.IndexOf(",") + 1);
                    var bytes = Convert.FromBase64String(base64);

                    using var ms = new MemoryStream(bytes);
                    pictureBoxImagen.Image?.Dispose();
                    pictureBoxImagen.Image = Image.FromStream(ms);
                    pictureBoxImagen.SizeMode = PictureBoxSizeMode.Zoom;
                    return;
                }

                // Caso 2: URL normal
                if (_httpClient == null)
                    _httpClient = new HttpClient();

                var bytesHttp = await _httpClient.GetByteArrayAsync(urlImagen);
                using var msHttp = new MemoryStream(bytesHttp);

                pictureBoxImagen.Image?.Dispose();
                pictureBoxImagen.Image = Image.FromStream(msHttp);
                pictureBoxImagen.SizeMode = PictureBoxSizeMode.Zoom;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al cargar la imagen: {ex.Message}");
                pictureBoxImagen.Image = null;
            }
        }



        private void FormVerMiPiso_Load_1(object sender, EventArgs e)
        {

        }

        private void btnVerTareas_Click(object sender, EventArgs e)
        {
            CatalogoTareas catalogoTareas = new CatalogoTareas();            
            catalogoTareas.ShowDialog();
        }
    }
}
