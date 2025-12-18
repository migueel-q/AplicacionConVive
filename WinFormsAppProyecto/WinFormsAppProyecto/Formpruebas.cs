using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UserControlLib;

namespace Formularios
{
    public partial class Formpruebas : Form
    {
        private List<String> _pisos;
        const int ITEM_HEIGHT = FichaPiso.ALTURA;
        const int BUFFER = 3;
        List<FichaPiso> fichas = new List<FichaPiso>();
        int _visibleCount;
        public Formpruebas(List<String> pisos)
        {
            InitializeComponent();
            _pisos = pisos;
            panel1.AutoScroll = true;
            panel1.AutoScrollMinSize = new Size(0, _pisos.Count * ITEM_HEIGHT);
            panel1.VerticalScroll.Enabled = true;
            panel1.VerticalScroll.Visible = true;
            InicializarVirtualizacion();
        }
        private void InicializarVirtualizacion()
        {
            _visibleCount = (panel1.ClientSize.Height + ITEM_HEIGHT - 1) / ITEM_HEIGHT + BUFFER;

            ;

            panel1.AutoScroll = true;
            panel1.AutoScrollMinSize = new Size(0, _pisos.Count * ITEM_HEIGHT);


            panel1.SuspendLayout();
            panel1.Controls.Clear();
            fichas.Clear();

            for (int i = 0; i < _visibleCount; i++)
            {
                var ficha = new FichaPiso
                {
                    Width = panel1.ClientSize.Width -
                            SystemInformation.VerticalScrollBarWidth
                };

                panel1.Controls.Add(ficha);
                fichas.Add(ficha);
            }

            panel1.ResumeLayout();
            UpdateFichas();
        }
        private void panel1_Scroll(object sender, ScrollEventArgs e)
        {
            UpdateFichas();
        }
        private void panel1_Resize(object sender, EventArgs e)
        {
            foreach (var ficha in fichas)
                ficha.Width = panel1.ClientSize.Width - SystemInformation.VerticalScrollBarWidth;

            UpdateFichas();
        }

        private void UpdateFichas()
        {
            int scrollY = panel1.VerticalScroll.Value;
            int firstIndex = scrollY / ITEM_HEIGHT;
            int offset = scrollY % ITEM_HEIGHT;

            for (int i = 0; i < fichas.Count; i++)
            {
                int dataIndex = firstIndex + i;
                var ficha = fichas[i];

                if (dataIndex >= 0 && dataIndex < _pisos.Count)
                {
                    ficha.Visible = true;
                    ficha.Top = (i * ITEM_HEIGHT) - offset; // 🔑 aplica el desplazamiento parcial
                    ficha.Bind(_pisos[dataIndex], dataIndex);
                }
                else
                {
                    ficha.Visible = false;
                }
            }

        }

    }

}
