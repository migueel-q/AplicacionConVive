using Formularios;

namespace WinFormsAppProyecto
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.WindowState = FormWindowState.Maximized;
        }

        private void AbrirFormulario<T>() where T : Form, new()
        {
            Form formulario = this.MdiChildren.FirstOrDefault(f => f is T);

            if (formulario == null)
            {
                formulario = new T
                {
                    MdiParent = this
                };
                formulario.Show();
            }
            else
            {
                formulario.Activate();
            }
        }

        private void añadirPiso_click(object sender, EventArgs e)
        {
            AbrirFormulario<FormAñadirPiso>();
        }

        private void modificarPiso_Click(object sender, EventArgs e)
        {
            AbrirFormulario<FormModificarPiso>();
        }

        
    }
}
