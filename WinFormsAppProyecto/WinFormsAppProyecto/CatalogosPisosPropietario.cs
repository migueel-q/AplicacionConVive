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
        PisoControlador pisoControlador = new PisoControlador();
        BindingList<Piso> listaPisos;
        Propietario _propietario;

        public CatalogosPisosPropietario(Propietario propietario)
        {
            InitializeComponent();
            _propietario = propietario;
        }

        private async Task CargarPisos()
        {
            // Espera a que el controlador obtenga la lista de pisos desde la API 
            // y la guarda dentro de un BindingList (que notifica cambios al DataGridView)
            listaPisos = new BindingList<Piso>(await pisoControlador.getAll());
        }

        private async void CatalogosPisosPropietario_Load(object sender, EventArgs e)
        {
            await CargarPisos();
            dgvCatalogoPisos.DataSource = listaPisos.Where(p => p.propietario.id == _propietario.id && p.validado).ToList();

            dgvCatalogoPisos.Columns["direccion"].Visible = false;
            dgvCatalogoPisos.Columns["propietario"].Visible = false;
        }

        private async void btnOcupado_Click(object sender, EventArgs e)
        {
            Piso pisoActualizar = (Piso)dgvCatalogoPisos.SelectedRows[0].DataBoundItem;
            pisoActualizar.disponible = false;
            await pisoControlador.update(pisoActualizar, pisoActualizar.id);
            await CargarPisos();
            dgvCatalogoPisos.DataSource = listaPisos.Where(p => p.propietario.id == _propietario.id).ToList();
        }

        private void dgvCatalogoPisos_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            // poner que se vea el piso?
        }
    }
}
