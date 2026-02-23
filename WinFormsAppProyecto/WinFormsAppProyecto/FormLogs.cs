using Formularios;

namespace WinFormsAppProyecto
{
    public partial class FormLogs : Form
    {
        public FormLogs()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void btnRegistro_Click(object sender, EventArgs e)
        {
            FormRegistro registrar = new FormRegistro();
            registrar.Show();
        }

        private void btnInicioSesion_Click(object sender, EventArgs e)
        {
            FormInicioSesion formInicioSesion = new FormInicioSesion();
            this.Hide();
            formInicioSesion.Show();            
        }
    }
}
