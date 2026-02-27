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
    public partial class FormOfertasSolicitudes : Form
    {
        private Inquilino _inquilino;
        private Piso _piso;
        private OfertaControlador _ofertaControlador = new OfertaControlador();
        private SolicitudControlador solicitudControlador = new SolicitudControlador();
        public FormOfertasSolicitudes(Inquilino inquilino, Piso piso)
        {
            InitializeComponent();
            _piso = piso;
            _inquilino = inquilino;
        }

        private async void btnSolicitarPiso_Click(object sender, EventArgs e)
        {       
            Oferta oferta = new Oferta {
                cantidad = double.Parse(txtPrecio.Text),
                descripcion = richTextBoxDesc.Text,
                piso = _piso,
                inquilino = _inquilino
                
            };
            oferta = await _ofertaControlador.add(oferta);

            Solicitud solicitud = new Solicitud { 
                oferta = oferta,
                inquilino = oferta.inquilino,
                aceptado = false,
            };
            if (_inquilino.contrato == null)
            {
                MessageBox.Show("No puedes hacer una oferta");
            }
            else
            {
                await solicitudControlador.add(solicitud);
                if (solicitud != null)
                {
                    MessageBox.Show("Solicitud añadida correctamente");
                }
            }
        }

        private void FormOfertas_Load(object sender, EventArgs e)
        {

        }
    }
}
