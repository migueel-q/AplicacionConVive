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
    public partial class GestionarContratos : Form
    {
        ContratoControlador contratoControlador = new ContratoControlador();
        BindingList<Contrato> listaContratos;
        public GestionarContratos()
        {
            InitializeComponent();
        }

        private async void GestionarContratos_Load(object sender, EventArgs e)
        {
            await CargarContratos();
            dgvContratos.DataSource = listaContratos.Where(c => c.)
        }

        private async Task CargarContratos()
        {
            listaContratos = new BindingList<Contrato>(await contratoControlador.getAll());
        }
    }
}
