using Controladores;
using Formularios;
using Modelos;

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
            FormModificarPiso formMod = new FormModificarPiso();
            AbrirFormulario(formMod);
        }

        
    }
}
