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
    public partial class FormModificarPiso : Form
    {
        Piso _piso;
        Propietario _propietario;

        public FormModificarPiso(Piso piso, Propietario propietario)
        {
            InitializeComponent();
            _piso = piso;
            _propietario = propietario;
            txtCalle.Text = _piso.direccion.calle;
            txtCiudad.Text = _piso.direccion.ciudad;
            txtProvincia.Text = _piso.direccion.provincia;
            txtPrecio.Text = _piso.precio.ToString();
            txtImagen.Text = _piso.url_imagen;
            richTextBoxDesc.Text = _piso.descripcion;
        }

        private async void btnModificarPiso_Click(object sender, EventArgs e)
        {
            PisoControlador pisoControlador = new PisoControlador();
            Direccion direccionActualizada = new Direccion
            {
                calle = txtCalle.Text,
                ciudad = txtCiudad.Text,
                provincia = txtProvincia.Text,
            };
            Piso pisoActualizado = new Piso
            {
                direccion = direccionActualizada,
                descripcion = richTextBoxDesc.Text,
                url_imagen = txtImagen.Text,
                disponible = true,
                propietario = _propietario,
                precio = double.Parse(txtPrecio.Text),
            };
            await pisoControlador.update(pisoActualizado, _piso.id);
            MessageBox.Show("Piso actualizado correctamente.");
        }
    }
}
