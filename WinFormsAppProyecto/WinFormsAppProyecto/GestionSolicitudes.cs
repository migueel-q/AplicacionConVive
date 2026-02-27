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
    public partial class GestionSolicitudes : Form
    {
        SolicitudControlador solicitudControlador = new SolicitudControlador();
        BindingList<Solicitud> listaSolicitud;
        public GestionSolicitudes()
        {
            InitializeComponent();
        }

        private async void btnAceptarContrato_Click(object sender, EventArgs e)
        {
            if (dgvSolicitudes.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un contrato");
            }
            else
            {
                Solicitud solicitudEditar = (Solicitud)dgvSolicitudes.SelectedRows[0].DataBoundItem;
                solicitudEditar.aceptado = true;
                await solicitudControlador.update(solicitudEditar, solicitudEditar.id);
                await CargarSolicitudes();
                dgvSolicitudes.DataSource = listaSolicitud.Where(c => !c.aceptado).ToList();
            }
        }

        private async void btnDenegar_Click(object sender, EventArgs e)
        {
            if (dgvSolicitudes.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un contrato");
            }
            else
            {
                Solicitud solicitudEliminar = (Solicitud)dgvSolicitudes.SelectedRows[0].DataBoundItem;
                await solicitudControlador.delete(solicitudEliminar.id);
                await CargarSolicitudes();
                dgvSolicitudes.DataSource = listaSolicitud.Where(c => !c.aceptado).ToList();
            }
        }

        private async void GestionSolicitudes_Load(object sender, EventArgs e)
        {
            await CargarSolicitudes();
            dgvSolicitudes.DataSource = listaSolicitud.Where(s => !s.aceptado).ToList();
            dgvSolicitudes.Columns["oferta"].Visible = false;
            dgvSolicitudes.Columns["inquilino"].Visible = false;
            dgvSolicitudes.Columns["id"].Visible = false;
        }

        private async Task CargarSolicitudes()
        {
            listaSolicitud = new BindingList<Solicitud>(await solicitudControlador.getAll());
        }
    }
}
