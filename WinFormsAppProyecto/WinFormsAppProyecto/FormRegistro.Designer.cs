namespace Formularios
{
    partial class FormRegistro
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            txtNombreReal = new TextBox();
            txtNombreUsu = new TextBox();
            txtEmail = new TextBox();
            txtContrasena = new TextBox();
            dtpFechaNac = new DateTimePicker();
            label6 = new Label();
            txtContraValida = new TextBox();
            label7 = new Label();
            cmbTipoUsuario = new ComboBox();
            btnRegistrarse = new Button();
            btnVolver = new Button();
            errorProvider = new ErrorProvider(components);
            ((System.ComponentModel.ISupportInitialize)errorProvider).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(258, 33);
            label1.Name = "label1";
            label1.Size = new Size(178, 15);
            label1.TabIndex = 0;
            label1.Text = "Introduce tu nombre de usuario:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(39, 33);
            label2.Name = "label2";
            label2.Size = new Size(120, 15);
            label2.TabIndex = 1;
            label2.Text = "Introduce tu nombre:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(39, 98);
            label3.Name = "label3";
            label3.Size = new Size(186, 15);
            label3.TabIndex = 2;
            label3.Text = "Introduce tu fecha de nacimiento:";
            label3.Click += label3_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(39, 159);
            label4.Name = "label4";
            label4.Size = new Size(107, 15);
            label4.TabIndex = 3;
            label4.Text = "Introduce tu email:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(39, 216);
            label5.Name = "label5";
            label5.Size = new Size(134, 15);
            label5.TabIndex = 4;
            label5.Text = "Introduce la contraseña:";
            // 
            // txtNombreReal
            // 
            txtNombreReal.Location = new Point(39, 51);
            txtNombreReal.Name = "txtNombreReal";
            txtNombreReal.Size = new Size(100, 23);
            txtNombreReal.TabIndex = 5;
            // 
            // txtNombreUsu
            // 
            txtNombreUsu.Location = new Point(258, 51);
            txtNombreUsu.Name = "txtNombreUsu";
            txtNombreUsu.Size = new Size(100, 23);
            txtNombreUsu.TabIndex = 6;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(39, 177);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(100, 23);
            txtEmail.TabIndex = 7;
            // 
            // txtContrasena
            // 
            txtContrasena.Location = new Point(39, 234);
            txtContrasena.Name = "txtContrasena";
            txtContrasena.Size = new Size(100, 23);
            txtContrasena.TabIndex = 8;
            txtContrasena.UseSystemPasswordChar = true;
            // 
            // dtpFechaNac
            // 
            dtpFechaNac.Location = new Point(39, 120);
            dtpFechaNac.Name = "dtpFechaNac";
            dtpFechaNac.Size = new Size(200, 23);
            dtpFechaNac.TabIndex = 9;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(258, 216);
            label6.Name = "label6";
            label6.Size = new Size(184, 15);
            label6.TabIndex = 10;
            label6.Text = "Vuelve a introducir tu contraseña:";
            // 
            // txtContraValida
            // 
            txtContraValida.Location = new Point(258, 234);
            txtContraValida.Name = "txtContraValida";
            txtContraValida.Size = new Size(100, 23);
            txtContraValida.TabIndex = 11;
            txtContraValida.UseSystemPasswordChar = true;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(258, 98);
            label7.Name = "label7";
            label7.Size = new Size(145, 15);
            label7.TabIndex = 12;
            label7.Text = "¿Qué tipo de usuario eres?";
            // 
            // cmbTipoUsuario
            // 
            cmbTipoUsuario.FormattingEnabled = true;
            cmbTipoUsuario.Location = new Point(258, 123);
            cmbTipoUsuario.Name = "cmbTipoUsuario";
            cmbTipoUsuario.Size = new Size(121, 23);
            cmbTipoUsuario.TabIndex = 13;
            // 
            // btnRegistrarse
            // 
            btnRegistrarse.Location = new Point(258, 293);
            btnRegistrarse.Name = "btnRegistrarse";
            btnRegistrarse.Size = new Size(75, 23);
            btnRegistrarse.TabIndex = 14;
            btnRegistrarse.Text = "Registrarse";
            btnRegistrarse.UseVisualStyleBackColor = true;
            btnRegistrarse.Click += btnRegistrarse_Click;
            // 
            // btnVolver
            // 
            btnVolver.Location = new Point(39, 293);
            btnVolver.Name = "btnVolver";
            btnVolver.Size = new Size(75, 23);
            btnVolver.TabIndex = 15;
            btnVolver.Text = "Volver";
            btnVolver.UseVisualStyleBackColor = true;
            btnVolver.Click += btnVolver_Click;
            // 
            // errorProvider
            // 
            errorProvider.ContainerControl = this;
            // 
            // FormRegistro
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(492, 339);
            Controls.Add(btnVolver);
            Controls.Add(btnRegistrarse);
            Controls.Add(cmbTipoUsuario);
            Controls.Add(label7);
            Controls.Add(txtContraValida);
            Controls.Add(label6);
            Controls.Add(dtpFechaNac);
            Controls.Add(txtContrasena);
            Controls.Add(txtEmail);
            Controls.Add(txtNombreUsu);
            Controls.Add(txtNombreReal);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FormRegistro";
            Text = "FormRegistro";
            ((System.ComponentModel.ISupportInitialize)errorProvider).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private TextBox txtNombreReal;
        private TextBox txtNombreUsu;
        private TextBox txtEmail;
        private TextBox txtContrasena;
        private DateTimePicker dtpFechaNac;
        private Label label6;
        private TextBox txtContraValida;
        private Label label7;
        private ComboBox cmbTipoUsuario;
        private Button btnRegistrarse;
        private Button btnVolver;
        private ErrorProvider errorProvider;
    }
}