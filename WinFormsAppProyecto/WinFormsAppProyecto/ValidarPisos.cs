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
    public partial class ValidarPisos : Form
    {
        PisoControlador pisoControlador = new PisoControlador();
        BindingList<Piso> listaPisos;
        public ValidarPisos()
        {
            InitializeComponent();
        }

        private async Task CargarPisos()
        {
            // Espera a que el controlador obtenga la lista de pisos desde la API 
            // y la guarda dentro de un BindingList (que notifica cambios al DataGridView)
            listaPisos = new BindingList<Piso>(await pisoControlador.getAll());
        }

        private async void ValidarPisos_Load(object sender, EventArgs e)
        {
            await CargarPisos();
            dgvPisos.DataSource = listaPisos.Where(p => !p.validado).ToList();

            dgvPisos.Columns["direccion"].Visible = false;
            dgvPisos.Columns["propietario"].Visible = false;
        }

        private async void btnValidarPiso_Click(object sender, EventArgs e)
        {
            if (dgvPisos.SelectedRows.Count == 0)
            {
                return;
            }
            else
            {
                Piso pisoEditar = (Piso)dgvPisos.SelectedRows[0].DataBoundItem;
                pisoEditar.validado = true;
                pisoControlador.update(pisoEditar, pisoEditar.id);

            }
            await CargarPisos();
        }
    }
}
