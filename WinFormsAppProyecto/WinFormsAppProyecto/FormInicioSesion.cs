using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WinFormsAppProyecto;
using Modelos;
using Controladores;

namespace Formularios
{
    public partial class FormInicioSesion : Form
    {
        public FormInicioSesion()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void btnVolver_Click(object sender, EventArgs e)
        {
            FormLogs formLogs = new FormLogs();
            formLogs.Show();
            this.Close();

        }

        private async void btnIniciarSesion_Click(object sender, EventArgs e)
        {      

            // Codigo para iniciar sesion
            PropietarioControlador propietarioControlador = new PropietarioControlador();
            InquilinoControlador inquilinoControlador = new InquilinoControlador();
            
            var propietarios = await propietarioControlador.getAll();
            var propietario = propietarios.FirstOrDefault(p => p.email == txtEmail.Text && p.password == txtContrasena.Text);
            if(propietario!=null){
                MessageBox.Show("Bienvenido");
                Form1 form1 = new Form1(propietario); 
                form1.Show(); 
                this.Hide();
                return;
            }

            var inquilinos = await inquilinoControlador.getAll();
            var inquilino = inquilinos.FirstOrDefault(i => i.email == txtEmail.Text && i.password == txtContrasena.Text);
            if(inquilino!=null){
                MessageBox.Show("Bienvenido");
                Form1 form1 = new Form1(inquilino);
                form1.Show();
                this.Hide();
                return;
            }
        }
    }
}
