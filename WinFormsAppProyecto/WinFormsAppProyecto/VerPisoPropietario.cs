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
    public partial class VerPisoPropietario : Form
    {
        Piso _piso;
        Propietario _propietario;
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
        }
    }
}
