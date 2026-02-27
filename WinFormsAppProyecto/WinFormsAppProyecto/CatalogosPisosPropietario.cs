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
    public partial class CatalogosPisosPropietario : Form
    {
        private PisoControlador pisoControlador = new PisoControlador();
        private BindingList<Piso> listaPisos;
        private BindingSource bs = new BindingSource();
        private Propietario _propietario;

        public CatalogosPisosPropietario(Propietario propietario)
        {
            InitializeComponent();
            _propietario = propietario;
        }

        private async Task CargarPisos()
        {
            var pisos = await pisoControlador.getAll();
            listaPisos = new BindingList<Piso>(pisos);
        }

        private async void CatalogosPisosPropietario_Load(object sender, EventArgs e)
        {
            await CargarPisos();

            // Filtrar sin romper el binding
            var filtrados = listaPisos
                .Where(p => p.propietario.id == _propietario.id && p.validado)
                .ToList();

            bs.DataSource = new BindingList<Piso>(filtrados);
            dgvCatalogoPisos.DataSource = bs;

            dgvCatalogoPisos.Columns["direccion"].Visible = false;
            dgvCatalogoPisos.Columns["propietario"].Visible = false;
            dgvCatalogoPisos.Columns["id"].Visible = false;
        }

        private async void btnOcupado_Click(object sender, EventArgs e)
        {
            if (dgvCatalogoPisos.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un piso.");
                return;
            }

            Piso pisoActualizar = (Piso)dgvCatalogoPisos.SelectedRows[0].DataBoundItem;
            pisoActualizar.disponible = false;

            await pisoControlador.update(pisoActualizar, pisoActualizar.id);

            await CargarPisos();

            var filtrados = listaPisos
                .Where(p => p.propietario.id == _propietario.id)
                .ToList();

            bs.DataSource = new BindingList<Piso>(filtrados);
        }

        private void dgvCatalogoPisos_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            var row = dgvCatalogoPisos.Rows[e.RowIndex];
            var item = row.DataBoundItem;

            if (item is not Piso pisoSeleccionado)
            {
                MessageBox.Show("No se pudo obtener el piso seleccionado.");
                return;
            }

            VerPisoPropietario verPisoPropietario = new VerPisoPropietario(_propietario, pisoSeleccionado);
            verPisoPropietario.Show();
        }

        private async void btnDesocupar_Click(object sender, EventArgs e)
        {
            if (dgvCatalogoPisos.SelectedRows.Count == 0)
            {
                MessageBox.Show("Selecciona un piso.");
                return;
            }

            Piso pisoActualizar = (Piso)dgvCatalogoPisos.SelectedRows[0].DataBoundItem;
            pisoActualizar.disponible = true;

            await pisoControlador.update(pisoActualizar, pisoActualizar.id);

            await CargarPisos();

            var filtrados = listaPisos
                .Where(p => p.propietario.id == _propietario.id)
                .ToList();

            bs.DataSource = new BindingList<Piso>(filtrados);
        }
    }
}
