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
            dgvContratos.DataSource = listaContratos.Where(c => !c.aceptado).ToList();
            dgvContratos.Columns["piso"].Visible = false;

        }

        private async Task CargarContratos()
        {
            listaContratos = new BindingList<Contrato>(await contratoControlador.getAll());
        }



        private async void btnDenegar_Click(object sender, EventArgs e)
        {
            if (dgvContratos.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un contrato");
            }
            else
            {
                Contrato contratoEliminar = (Contrato)dgvContratos.SelectedRows[0].DataBoundItem;
                await contratoControlador.delete(contratoEliminar.id);
                await CargarContratos();
                dgvContratos.DataSource = listaContratos.Where(c => !c.aceptado).ToList();
            }
        }

        private async void btnAceptarContrato_Click(object sender, EventArgs e)
        {
            if (dgvContratos.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un contrato");
            } else
            {
                Contrato contratoEditar = (Contrato) dgvContratos.SelectedRows[0].DataBoundItem;
                contratoEditar.aceptado = true;
                await contratoControlador.update(contratoEditar, contratoEditar.id);
                await CargarContratos();
                dgvContratos.DataSource = listaContratos.Where(c => !c.aceptado).ToList();
            }
            
        }
    }
}
