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
            PisoControlador pisoControlador = new PisoControlador();
            Direccion direccionNueva = new Direccion {
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
}
