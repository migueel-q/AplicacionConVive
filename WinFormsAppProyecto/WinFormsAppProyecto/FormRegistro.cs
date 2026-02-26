using Controladores;
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

namespace Formularios
{
    public partial class FormRegistro : Form
    {
        public FormRegistro()
        {
            InitializeComponent();
            this.StartPosition = FormStartPosition.CenterScreen;
            cmbTipoUsuario.Items.Add("Propietario");
            cmbTipoUsuario.Items.Add("Inquilino");
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

        private async void btnRegistrarse_Click(object sender, EventArgs e)
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
            string tipo = cmbTipoUsuario.SelectedItem.ToString();
            if (tipo == "Propietario")
            {
                PropietarioControlador propietarioControlador = new PropietarioControlador();
                Propietario nuevoPropietario = new Propietario
                {
                    nombre_usuario = txtNombreUsu.Text,
                    nombre_real = txtNombreReal.Text,
                    fecha_nacimiento = dtpFechaNac.Value.ToString("yyyy-MM-dd"),
                    email = txtEmail.Text,
                    password = txtContrasena.Text
                };
                await propietarioControlador.add(nuevoPropietario);
                MessageBox.Show("Propietario registrado correctamente.");
            } else if (tipo == "Inquilino")
            {
                InquilinoControlador inquilinoControlador = new InquilinoControlador();
                Inquilino nuevoInquilino = new Inquilino
                {
                    nombre_usuario = txtNombreUsu.Text,
                    nombre_real = txtNombreReal.Text,
                    fecha_nacimiento = dtpFechaNac.Value.ToString("yyyy-MM-dd"),
                    email = txtEmail.Text,
                    password = txtContrasena.Text
                };
                await inquilinoControlador.add(nuevoInquilino);
                MessageBox.Show("Inquilino registrado correctamente.");
            }
        }
    }
}
