using Controladores;
using Modelos;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formularios
{
    public partial class FormAñadirPiso : Form
    {
        private Propietario _propietario;
        public FormAñadirPiso(Propietario propietario)
        {
            InitializeComponent();
            _propietario = propietario;
        }

        private void FormAñadirPiso_Load(object sender, EventArgs e)
        {

        }

        private async void btnGuardarPiso_Click(object sender, EventArgs e)
        {
            if (!ValidarCampos())
            {
                MessageBox.Show("Corrige los campos marcados antes de guardar.");
            }
            else
            {
                PisoControlador pisoControlador = new PisoControlador();
                Direccion direccionNueva = new Direccion
                {
                    calle = txtCalle.Text,
                    ciudad = txtCiudad.Text,
                    provincia = txtProvincia.Text,
                };
                Piso nuevoPiso = new Piso
                {
                    direccion = direccionNueva,
                    descripcion = richTextBoxDesc.Text,
                    url_imagen = txtImagen.Text,
                    disponible = true,
                    propietario = _propietario,
                    precio = double.Parse(txtPrecio.Text),
                };
                await pisoControlador.add(nuevoPiso);
                MessageBox.Show("Piso añadido correctamente.");
            }
        }

        private bool ValidarCampos()
        {
            bool valido = true;
            // Calle
            if (string.IsNullOrWhiteSpace(txtCalle.Text))
            {
                errorProvider.SetError(txtCalle, "La calle no puede estar vacía.");
                valido = false;
            }
            else {
                errorProvider.SetError(txtCalle, ""); 
            }
            // Ciudad
            if (string.IsNullOrWhiteSpace(txtCiudad.Text))
            {
                errorProvider.SetError(txtCiudad, "La ciudad no puede estar vacía.");
                valido = false;
            }
            else { 
                errorProvider.SetError(txtCiudad, ""); 
            } 
            // Provincia
            if (string.IsNullOrWhiteSpace(txtProvincia.Text)) {
                errorProvider.SetError(txtProvincia, "La provincia no puede estar vacía."); 
                valido = false; 
            } else errorProvider.SetError(txtProvincia, ""); 
            // Descripción
            if (string.IsNullOrWhiteSpace(richTextBoxDesc.Text)) { 
                errorProvider.SetError(richTextBoxDesc, "La descripción no puede estar vacía.");
                valido = false; 
            } else errorProvider.SetError(richTextBoxDesc, ""); 
            // Imagen
            if (string.IsNullOrWhiteSpace(txtImagen.Text)) { 
                errorProvider.SetError(txtImagen, "Debes introducir una URL de imagen.");
                valido = false;
            } else errorProvider.SetError(txtImagen, "");
            // Precio
            if (!double.TryParse(txtPrecio.Text, out double precio) || precio <= 0) { 
                errorProvider.SetError(txtPrecio, "Introduce un precio válido mayor que 0."); 
                valido = false; 
            } else errorProvider.SetError(txtPrecio, "");
            return valido;
        }
    }
}
