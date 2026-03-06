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
    public partial class AñadirGastos : Form
    {
        Piso _piso;
        GastoControlador gastoControlador = new GastoControlador();
        public AñadirGastos(Piso piso)
        {
            InitializeComponent();
            _piso = piso;
        }

        private async void btnAnadirGasto_Click(object sender, EventArgs e)
        {
            Gasto gasto = new Gasto { 
                concepto = txtConcepto.Text,
                piso = _piso,
                valor = double.Parse(txtValor.Text)                
            };
            await gastoControlador.add(gasto);
        }
    }
}
