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
    public partial class CatalogoInquilinos : Form
    {
        Propietario _propietario;
        public CatalogoInquilinos(Propietario propietario)
        {
            InitializeComponent();
            _propietario = propietario;
        }

        private async void CatalogoInquilinos_Load(object sender, EventArgs e)
        {
            InquilinoControlador controlador = new InquilinoControlador();

            // propietario viene del login
            var lista = await controlador.GetInquilinosDePropietario(_propietario.id);

            listBoxInquilinos.DataSource = lista;
        }

        private void btnInquilinos_Click(object sender, EventArgs e)
        {
            if (listBoxInquilinos.SelectedItem is Inquilino inq) { 
                FormChatPropietario chat = new FormChatPropietario(inq.id, _propietario.id);
                chat.Show(); 
            }
        }
    }
}
