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
        private static readonly HttpClient _httpClient = new HttpClient();

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
                    inquilino = _piso
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
                var bytes = await _httpClient.GetByteArrayAsync(_piso.url_imagen);  // Verifica que _httpClient esté inicializado
                using var ms = new MemoryStream(bytes);
                using var ImagenTemporal = Image.FromStream(ms);

                // Liberar la imagen anterior para evitar problemas de memoria
                pictureBoxImagen.Image?.Dispose();

                // Establecer la nueva imagen en el PictureBox
                pictureBoxImagen.Image = new Bitmap(ImagenTemporal);
                pictureBoxImagen.SizeMode = PictureBoxSizeMode.Zoom;
            }
            catch (Exception ex)
            {
                // Log y mensaje de error detallado
                MessageBox.Show($"Error al cargar la imagen: {ex.Message}");
                pictureBoxImagen.Image = null; // Limpiar el PictureBox si hay un error
            }
        }

        private void FormVerMiPiso_Load_1(object sender, EventArgs e)
        {

        }
    }
}
