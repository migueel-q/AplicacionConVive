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
    public partial class FormRegistro : Form
    {
        public FormRegistro()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void btnVolver_Click(object sender, EventArgs e)
        {
            FormLogs formLogs = new FormLogs();
            formLogs.Show();
            this.Close();
        }

        private void btnRegistrarse_Click(object sender, EventArgs e)
        {
            if (txtContrasena.Text != txtContraValida.Text)
            {
                errorProvider.SetError(txtContrasena, "Las contraseñas no coinciden");
                errorProvider.SetError(txtContraValida, "Las contraseñas no coinciden");
            }
            else
            {
                errorProvider.Clear();
            }
            /*string tipo = cmbTipoUsuario.SelectedItem.ToString();
            if (tipo == "Propietario")
            {
                //Propietario controlador
                var usuario = new //Propietario nuevoPropietario = new Propietario
                {
                    nombre_usuario = txtNombreUsu.Text,
                    nombreReal = txtNombreReal.Text,
                    fechaNac = dtpFechaNac.Value.ToString(),
                    email = txtEmail.Text,
                    contrasena = txtContrasena.Text
                };
                // await controlador.add(nuevoPropietario)
                MessageBox.Show("Propietario registrado correctamente.");
            } else if (tipo == "Inquilino")
            {
                //Inquilino controlador
                var usuario = new //Inquilino nuevoInquilino = new Inquilino
                {
                    nombre_usuario = txtNombreUsu.Text,
                    nombreReal = txtNombreReal.Text,
                    fechaNac = dtpFechaNac.Value.ToString(),
                    email = txtEmail.Text,
                    contrasena = txtContrasena.Text
                };
                // await controlador.add(nuevoInquilino)
                MessageBox.Show("Inquilino registrado correctamente.");
            }*/
        }
    }
}
