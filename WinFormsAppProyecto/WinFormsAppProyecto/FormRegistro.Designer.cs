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
            pictureBox1 = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)errorProvider).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(50, 104);
            label1.Margin = new Padding(4, 0, 4, 0);
            label1.Name = "label1";
            label1.Size = new Size(164, 23);
            label1.TabIndex = 0;
            label1.Text = "Nombre de Usuario:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(87, 27);
            label2.Margin = new Padding(4, 0, 4, 0);
            label2.Name = "label2";
            label2.Size = new Size(77, 23);
            label2.TabIndex = 1;
            label2.Text = "Nombre:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(38, 178);
            label3.Margin = new Padding(4, 0, 4, 0);
            label3.Name = "label3";
            label3.Size = new Size(176, 23);
            label3.TabIndex = 2;
            label3.Text = "Fecha de Nacimiento:";
            label3.Click += label3_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(38, 254);
            label4.Margin = new Padding(4, 0, 4, 0);
            label4.Name = "label4";
            label4.Size = new Size(155, 23);
            label4.TabIndex = 3;
            label4.Text = "Introduce tu email:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(38, 326);
            label5.Margin = new Padding(4, 0, 4, 0);
            label5.Name = "label5";
            label5.Size = new Size(195, 23);
            label5.TabIndex = 4;
            label5.Text = "Introduce la contraseña:";
            // 
            // txtNombreReal
            // 
            txtNombreReal.Location = new Point(38, 53);
            txtNombreReal.Margin = new Padding(4, 5, 4, 5);
            txtNombreReal.Name = "txtNombreReal";
            txtNombreReal.Size = new Size(184, 30);
            txtNombreReal.TabIndex = 5;
            // 
            // txtNombreUsu
            // 
            txtNombreUsu.Location = new Point(38, 132);
            txtNombreUsu.Margin = new Padding(4, 5, 4, 5);
            txtNombreUsu.Name = "txtNombreUsu";
            txtNombreUsu.Size = new Size(184, 30);
            txtNombreUsu.TabIndex = 6;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(38, 282);
            txtEmail.Margin = new Padding(4, 5, 4, 5);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(184, 30);
            txtEmail.TabIndex = 7;
            // 
            // txtContrasena
            // 
            txtContrasena.Location = new Point(38, 354);
            txtContrasena.Margin = new Padding(4, 5, 4, 5);
            txtContrasena.Name = "txtContrasena";
            txtContrasena.Size = new Size(184, 30);
            txtContrasena.TabIndex = 8;
            txtContrasena.UseSystemPasswordChar = true;
            // 
            // dtpFechaNac
            // 
            dtpFechaNac.Format = DateTimePickerFormat.Short;
            dtpFechaNac.Location = new Point(38, 206);
            dtpFechaNac.Margin = new Padding(4, 5, 4, 5);
            dtpFechaNac.Name = "dtpFechaNac";
            dtpFechaNac.Size = new Size(184, 30);
            dtpFechaNac.TabIndex = 9;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(401, 326);
            label6.Margin = new Padding(4, 0, 4, 0);
            label6.Name = "label6";
            label6.Size = new Size(268, 23);
            label6.TabIndex = 10;
            label6.Text = "Vuelve a introducir tu contraseña:";
            // 
            // txtContraValida
            // 
            txtContraValida.Location = new Point(401, 354);
            txtContraValida.Margin = new Padding(4, 5, 4, 5);
            txtContraValida.Name = "txtContraValida";
            txtContraValida.Size = new Size(184, 30);
            txtContraValida.TabIndex = 11;
            txtContraValida.UseSystemPasswordChar = true;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(401, 254);
            label7.Margin = new Padding(4, 0, 4, 0);
            label7.Name = "label7";
            label7.Size = new Size(214, 23);
            label7.TabIndex = 12;
            label7.Text = "¿Qué tipo de usuario eres?";
            // 
            // cmbTipoUsuario
            // 
            cmbTipoUsuario.FormattingEnabled = true;
            cmbTipoUsuario.Location = new Point(401, 282);
            cmbTipoUsuario.Margin = new Padding(4, 5, 4, 5);
            cmbTipoUsuario.Name = "cmbTipoUsuario";
            cmbTipoUsuario.Size = new Size(184, 31);
            cmbTipoUsuario.TabIndex = 13;
            // 
            // btnRegistrarse
            // 
            btnRegistrarse.BackColor = Color.DarkRed;
            btnRegistrarse.Cursor = Cursors.Hand;
            btnRegistrarse.FlatAppearance.BorderColor = Color.Black;
            btnRegistrarse.FlatAppearance.MouseOverBackColor = Color.Red;
            btnRegistrarse.FlatStyle = FlatStyle.Flat;
            btnRegistrarse.ForeColor = Color.White;
            btnRegistrarse.Location = new Point(431, 420);
            btnRegistrarse.Margin = new Padding(4, 5, 4, 5);
            btnRegistrarse.Name = "btnRegistrarse";
            btnRegistrarse.Size = new Size(113, 42);
            btnRegistrarse.TabIndex = 14;
            btnRegistrarse.Text = "Registrarse";
            btnRegistrarse.UseVisualStyleBackColor = false;
            btnRegistrarse.Click += btnRegistrarse_Click;
            // 
            // btnVolver
            // 
            btnVolver.BackColor = Color.DarkRed;
            btnVolver.FlatAppearance.BorderColor = Color.Black;
            btnVolver.FlatAppearance.MouseOverBackColor = Color.Red;
            btnVolver.FlatStyle = FlatStyle.Flat;
            btnVolver.ForeColor = Color.White;
            btnVolver.Location = new Point(66, 420);
            btnVolver.Margin = new Padding(4, 5, 4, 5);
            btnVolver.Name = "btnVolver";
            btnVolver.Size = new Size(113, 42);
            btnVolver.TabIndex = 15;
            btnVolver.Text = "Volver";
            btnVolver.UseVisualStyleBackColor = false;
            btnVolver.Click += btnVolver_Click;
            // 
            // errorProvider
            // 
            errorProvider.ContainerControl = this;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = Properties.Resources.ConViveLogo;
            pictureBox1.Location = new Point(368, 42);
            pictureBox1.Margin = new Padding(4, 3, 4, 3);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(269, 168);
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox1.TabIndex = 16;
            pictureBox1.TabStop = false;
            // 
            // FormRegistro
            // 
            AutoScaleDimensions = new SizeF(10F, 23F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(702, 476);
            Controls.Add(pictureBox1);
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
            Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4, 5, 4, 5);
            Name = "FormRegistro";
            Text = "FormRegistro";
            ((System.ComponentModel.ISupportInitialize)errorProvider).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
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
        private PictureBox pictureBox1;
    }
}