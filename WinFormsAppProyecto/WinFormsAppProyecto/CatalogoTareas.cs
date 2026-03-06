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
    public partial class CatalogoTareas : Form
    {
        TareaControlador tareaControlador = new TareaControlador();
        BindingList<Tarea> listaTareas;
        public CatalogoTareas()
        {
            InitializeComponent();
        }

        private async void CatalogoTareas_Load(object sender, EventArgs e)
        {
            await CargarTareas();
            dgvTareas.DataSource = listaTareas;
            dgvTareas.Columns["piso"].Visible = false;


        }

        private async Task CargarTareas()
        {
            // Espera a que el controlador obtenga la lista de pisos desde la API 
            // y la guarda dentro de un BindingList (que notifica cambios al DataGridView)
            listaTareas = new BindingList<Tarea>(await tareaControlador.getAll());
        }
    }
}
