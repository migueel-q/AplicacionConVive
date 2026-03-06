using Modelos;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formularios
{
    public partial class VerPisoPropietario : Form
    {
        Piso _piso;
        Propietario _propietario;
        private static HttpClient _httpClient = new HttpClient();
        public VerPisoPropietario(Propietario propietario, Piso piso)
        {
            InitializeComponent();

            _piso = piso;
            _propietario = propietario;

            txtDireccion.Text = _piso.direccion.calle;
            txtCiudad.Text = _piso.direccion.ciudad;
            txtProvincia.Text = _piso.direccion.provincia;
            txtPrecio.Text = _piso.precio.ToString();
            txtUrlImagen.Text = _piso.url_imagen;
            txtDescripcion.Text = _piso.descripcion;
            txtPropietario.Text = _propietario.nombre_real;
            checkBoxDisponible.Checked = _piso.disponible;

           this.CenterToScreen();
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

        private async void VerPisoPropietario_Load(object sender, EventArgs e)
        {
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
    }
}
