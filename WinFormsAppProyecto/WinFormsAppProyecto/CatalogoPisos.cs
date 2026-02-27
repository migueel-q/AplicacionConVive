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
    public partial class CatalogoPisos : Form
    {
        PisoControlador pisoControlador = new PisoControlador();
        BindingList<Piso> listaPisos;
        public CatalogoPisos()
        {
            InitializeComponent();
            cmbFiltrar.Items.Add("Ciudad");
            cmbFiltrar.Items.Add("Provincia");
        }



        private async Task CargarPisos()
        {
            // Espera a que el controlador obtenga la lista de pisos desde la API 
            // y la guarda dentro de un BindingList (que notifica cambios al DataGridView)
            listaPisos = new BindingList<Piso>(await pisoControlador.getAll());
        }

        private async void CatalogoPisos_Load(object sender, EventArgs e)
        {
            await CargarPisos();
            dgvCatalogoPisos.DataSource = listaPisos.Where(p => p.validado && p.disponible).ToList();

            dgvCatalogoPisos.Columns["direccion"].Visible = false;
            dgvCatalogoPisos.Columns["propietario"].Visible = false;
        }


        private void FiltrarPisos()
        {
            if (listaPisos == null) return;

            string campo = cmbFiltrar.Text;
            string valor = txtFiltrar.Text.Trim().ToLower();

            // Siempre partimos de rutas validadas
            var pisos = listaPisos.Where(r => r.validado).ToList();

            if (string.IsNullOrWhiteSpace(campo) || string.IsNullOrWhiteSpace(valor))
            {
                dgvCatalogoPisos.DataSource = pisos;
                return;
            }

            List<Piso> filtradas = campo switch
            {
                "Ciudad" => pisos.Where(p => p.ciudad.ToLower().Contains(valor)).ToList(),

                "Provincia" => pisos.Where(p => p.provincia.ToLower().Contains(valor)).ToList(),

                _ => pisos
            };

            dgvCatalogoPisos.DataSource = filtradas;
        }

        private void txtFiltrar_TextChanged(object sender, EventArgs e)
        {
            FiltrarPisos();
        }

        public Piso pisoSeleccionado
        {
            get
            {
                if (dgvCatalogoPisos.SelectedRows.Count == 0)
                {
                    return null;
                }
                else
                {
                    return (Piso)dgvCatalogoPisos.SelectedRows[0].DataBoundItem;
                }
            }
        }
    }
}
