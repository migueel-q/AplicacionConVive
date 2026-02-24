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
    }
}
