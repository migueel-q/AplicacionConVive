using Controladores;
using Formularios;
using Modelos;
using System.Windows.Forms;

namespace WinFormsAppProyecto
{
    public partial class Form1 : Form
    {
        Propietario propietario;
        Inquilino inquilino;
        public Form1(Inquilino inquilino)
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.WindowState = FormWindowState.Maximized;
            this.inquilino = inquilino;
        }

        public Form1(Propietario propietario)
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.WindowState = FormWindowState.Maximized;
            this.propietario = propietario;
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);
        }
        private void AbrirFormulario(Form formulario)
        {
            formulario.MdiParent = this;
            formulario.Show();
        }


        private void añadirPiso_click(object sender, EventArgs e)
        {
            FormAñadirPiso formAñadirPiso = new FormAñadirPiso(propietario);
            AbrirFormulario(formAñadirPiso);
        }

        private void modificarPiso_Click(object sender, EventArgs e)
        {
            //FormModificarPiso formMod = new FormModificarPiso();
            //AbrirFormulario(formMod);
        }

        private void verPisosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);
        }

        private void verGastodToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // Buscar si CatalogoPisos está abierto
            CatalogoPisos catalogo = Application.OpenForms
                .OfType<CatalogoPisos>()
                .FirstOrDefault();

            if (catalogo == null)
            {
                MessageBox.Show("Primero abre el catálogo de pisos.");
                return;
            }

            // Obtener el ID del piso seleccionado
            int? idPiso = catalogo.PisoSeleccionadoId;

            if (idPiso == null)
            {
                MessageBox.Show("Selecciona un piso primero.");
                return;
            }

            // Abrir el informe con el ID
            VerInforme informe = new VerInforme(idPiso.Value);
            AbrirFormulario(informe);

        }

        private async void hablarPorChatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // 1. Buscar si el catálogo está abierto
            CatalogoPisos catalogo = Application.OpenForms
                .OfType<CatalogoPisos>()
                .FirstOrDefault();

            if (catalogo == null)
            {
                MessageBox.Show("Primero abre el catálogo de pisos.");
                return;
            }

            // 2. Obtener el piso seleccionado
            int? idPiso = catalogo.PisoSeleccionadoId;

            if (idPiso == null)
            {
                MessageBox.Show("Selecciona un piso primero.");
                return;
            }

            // 3. Obtener el piso desde el backend
            PisoControlador pisoControlador = new PisoControlador();
            Piso piso = await pisoControlador.getById(idPiso.Value);

            // 4. Si eres INQUILINO ? hablas con el propietario del piso
            if (inquilino != null)
            {
                int propietarioId = piso.propietario.id;
                FormChatInquilino chat = new FormChatInquilino(inquilino.id, propietarioId);
                AbrirFormulario(chat);
                return;
            }

            // 5. Si eres PROPIETARIO ? NO puedes obtener el inquilino desde el piso
            //    porque ya no existe piso.contrato
            //    Así que abrimos la lista de inquilinos
            if (propietario != null)
            {
                CatalogoInquilinos form = new CatalogoInquilinos(propietario);
                form.Show();
                return;
            }
        }


        private void listaInquilinosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (propietario == null) { MessageBox.Show("Solo los propietarios pueden ver esta lista."); return; }
            CatalogoInquilinos form = new CatalogoInquilinos(propietario); 
            form.Show();
        }
    }
}
