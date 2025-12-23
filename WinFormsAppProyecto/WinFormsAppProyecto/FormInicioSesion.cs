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

        private void btnIniciarSesion_Click(object sender, EventArgs e)
        {
            Form1 form1 = new Form1();
            form1.Show();
            this.Close();

            // Codigo para iniciar sesion
            //PropietarioControlador propietarioControlador = new PropietarioControlador()
            //InquilinoControlador inquilinoControlador = new InquilinoControlador()
            /*
             var propietarios = await propietarioControlador.getAll();
             var propietario = propietarios.FirstOrDefault(p => p.email == txtEmail.Text && p.contraseña == txtContrasena.Text);
             if(propietario!=null){
               MessageBox de bienvenido
             }

             var inquilinos = await inquilinoControlador.getAll();
             var inquilino = inquilinos.FirstOrDefault(i => i.email == txtEmail.Text && i.contraseña == txtContrasena.Text);
             if(inquilino!=null){
               MessageBox de bienvenido
             }
             */
        }
    }
}
