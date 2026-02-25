using System;
using System.Windows.Forms;
using Controladores;
using Modelos;
using Microsoft.VisualBasic;
using System.Globalization;

namespace Formularios
{
   /* public partial class FormVerMiPiso : Form
    {
        private Piso _piso;
        private Inquilino _inquilino;
        private TareaControlador _tareaControlador;
        private PisoControlador _pisoControlador;

        public FormVerMiPiso(Inquilino inquilino, Piso piso)
        {
            InitializeComponent();
            _piso = piso;
            _inquilino = inquilino;
            _tareaControlador = new TareaControlador();
            _pisoControlador = new PisoControlador();

            this.StartPosition = FormStartPosition.CenterScreen;
            this.Load += FormVerMiPiso_Load;
        }

        private async void FormVerMiPiso_Load(object? sender, EventArgs e)
        {
            try
            {
                if (_piso == null)
                {
                    MessageBox.Show("No se proporcionó un piso.");
                    return;
                }

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
                    try
                    {
                        var request = System.Net.WebRequest.Create(_piso.url_imagen);
                        using (var response = request.GetResponse())
                        using (var stream = response.GetResponseStream())
                        {
                            pictureBoxImagen.Image = System.Drawing.Image.FromStream(stream);
                        }
                    }
                    catch
                    {
                        // si falla la carga de imagen, limpiar
                        pictureBoxImagen.Image = null;
                    }
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

        private void FormVerMiPiso_Load_1(object sender, EventArgs e)
        {

        }
    }*/
}
