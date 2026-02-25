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
    public partial class FormChatPropietario : Form
    {
       
        private readonly MensajeControlador controlador = new MensajeControlador();
        private readonly int inquilinoId;
        private readonly int propietarioId;
        public FormChatPropietario(int inq, int prop)
        {
            InitializeComponent();
            inquilinoId = inq;
            propietarioId = prop;
            panelMnesajes.Resize += (s, ev) => CargarChat();
        }

        private async void FormChatPropietario_Load(object sender, EventArgs e)
        {
            await CargarChat();

            panelMnesajes.FlowDirection = FlowDirection.TopDown;
            panelMnesajes.WrapContents = false;
            panelMnesajes.AutoScroll = true;
        }

        private async void btnEnviar_Click(object sender, EventArgs e)
        {
            string texto = richTextBoxMensaje.Text.Trim();
            if (texto == "") return;

            bool enviadoPorInquilino = false; // porque este formulario lo usa el propietario

            await controlador.enviarMensaje(inquilinoId, propietarioId, texto, enviadoPorInquilino);

            richTextBoxMensaje.Text = "";

            await CargarChat();
        }

        private async Task CargarChat()
        {
            List<Mensaje> mensajes = await controlador.obtenerChat(inquilinoId, propietarioId);

            panelMnesajes.Controls.Clear();

            foreach (var msg in mensajes)
            {
                // Si lo envió el inquilino → NO es mío → izquierda
                // Si NO lo envió el inquilino → lo envió el propietario → es mío → derecha
                bool esMio = !msg.enviadoPorInquilino;
                AgregarBurbuja(msg.mensaje, esMio);
            }

            if (panelMnesajes.Controls.Count > 0)
                panelMnesajes.ScrollControlIntoView(panelMnesajes.Controls[panelMnesajes.Controls.Count - 1]);
        }

        private void AgregarBurbuja(string texto, bool enviadoPorInquilino)
        {
            Label burbuja = new Label();
            burbuja.Text = texto;
            burbuja.AutoSize = true;
            burbuja.MaximumSize = new Size(250, 0);
            burbuja.Padding = new Padding(10);
            burbuja.Font = new Font("Segoe UI", 10);

            if (enviadoPorInquilino)
            {
                burbuja.BackColor = Color.LightGreen;
                burbuja.TextAlign = ContentAlignment.MiddleRight;

                // Empuja la burbuja hacia la derecha
                burbuja.Margin = new Padding(
                    panelMnesajes.Width - 250 - 40, // margen izquierdo grande
                    5,
                    5,
                    5
                );
            }
            else
            {
                burbuja.BackColor = Color.LightBlue;
                burbuja.TextAlign = ContentAlignment.MiddleLeft;

                // Empuja la burbuja hacia la izquierda
                burbuja.Margin = new Padding(
                    5,
                    5,
                    panelMnesajes.Width - 250 - 40, // margen derecho grande
                    5
                );
            }

            panelMnesajes.Controls.Add(burbuja);
        }
    }
}

