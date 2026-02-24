using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Controladores;
using Modelos;
using Microsoft.VisualBasic;

namespace Formularios
{
    public partial class FormMenuInquilino : Form
    {
        private Inquilino _inquilino;
        private PisoControlador _pisoControlador;
        private TareaControlador _tareaControlador;

        public FormMenuInquilino(Inquilino inquilino)
        {
            InitializeComponent();
            _inquilino = inquilino;
            _pisoControlador = new PisoControlador();
            _tareaControlador = new TareaControlador();

            this.StartPosition = FormStartPosition.CenterScreen;
            this.Load += FormMenuInquilino_Load;
        }

        private async void FormMenuInquilino_Load(object? sender, EventArgs e)
        {
            await CargarPisosAsync();
        }

        private async Task CargarPisosAsync()
        {
            try
            {
                var pisos = await _pisoControlador.getAll();
                var pisosView = pisos.Select(p => new
                {
                    Id = p.id,
                    Direccion = p.direccion != null ? $"{p.direccion.calle}, {p.direccion.ciudad}, {p.direccion.provincia}" : "",
                    p.descripcion,
                    Precio = p.precio,
                    Disponible = p.disponible
                }).ToList();

                dataGridView1.DataSource = pisosView;
                dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                dataGridView1.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                dataGridView1.MultiSelect = false;

                // If the inquilino has a piso via contrato, select it
                if (_inquilino?.contrato?.piso != null)
                {
                    int miPisoId = _inquilino.contrato.piso.id;
                    foreach (DataGridViewRow row in dataGridView1.Rows)
                    {
                        if (row.Cells["Id"].Value is int val && val == miPisoId)
                        {
                            row.Selected = true;
                            // Scroll into view
                            dataGridView1.FirstDisplayedScrollingRowIndex = row.Index;
                            break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error cargando pisos: " + ex.Message);
            }
        }

        private void btnVerMiPiso_Click(object sender, EventArgs e)
        {
            if (_inquilino?.contrato?.piso == null)
            {
                MessageBox.Show("No tienes un piso asignado en tu contrato.");
                return;
            }

            var piso = _inquilino.contrato.piso;

            // Abrir formulario para ver el piso
            FormVerMiPiso formVer = new FormVerMiPiso(_inquilino, piso);
            formVer.ShowDialog();
        }
    }
}
