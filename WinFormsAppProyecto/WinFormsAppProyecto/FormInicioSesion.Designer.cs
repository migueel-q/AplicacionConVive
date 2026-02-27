namespace Formularios
{
    partial class FormInicioSesion
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
            txtContrasena = new TextBox();
            txtEmail = new TextBox();
            label5 = new Label();
            label4 = new Label();
            btnIniciarSesion = new Button();
            btnVolver = new Button();
            pictureBox1 = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // txtContrasena
            // 
            txtContrasena.Location = new Point(156, 268);
            txtContrasena.Margin = new Padding(3, 4, 3, 4);
            txtContrasena.Name = "txtContrasena";
            txtContrasena.Size = new Size(167, 27);
            txtContrasena.TabIndex = 12;
            txtContrasena.UseSystemPasswordChar = true;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(156, 194);
            txtEmail.Margin = new Padding(3, 4, 3, 4);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(170, 27);
            txtEmail.TabIndex = 11;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI Semibold", 10.8F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label5.Location = new Point(135, 239);
            label5.Name = "label5";
            label5.Size = new Size(212, 25);
            label5.TabIndex = 10;
            label5.Text = "Introduce la contraseña:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI Semibold", 10.8F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label4.Location = new Point(156, 165);
            label4.Name = "label4";
            label4.Size = new Size(170, 25);
            label4.TabIndex = 9;
            label4.Text = "Introduce tu email:";
            // 
            // btnIniciarSesion
            // 
            btnIniciarSesion.BackColor = Color.DarkRed;
            btnIniciarSesion.Cursor = Cursors.Hand;
            btnIniciarSesion.FlatAppearance.BorderColor = Color.Black;
            btnIniciarSesion.FlatAppearance.MouseOverBackColor = Color.Red;
            btnIniciarSesion.FlatStyle = FlatStyle.Flat;
            btnIniciarSesion.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnIniciarSesion.ForeColor = Color.White;
            btnIniciarSesion.Location = new Point(291, 357);
            btnIniciarSesion.Margin = new Padding(3, 4, 3, 4);
            btnIniciarSesion.Name = "btnIniciarSesion";
            btnIniciarSesion.Size = new Size(123, 41);
            btnIniciarSesion.TabIndex = 13;
            btnIniciarSesion.Text = "Iniciar sesión";
            btnIniciarSesion.UseVisualStyleBackColor = false;
            btnIniciarSesion.Click += btnIniciarSesion_Click;
            // 
            // btnVolver
            // 
            btnVolver.BackColor = Color.DarkRed;
            btnVolver.FlatAppearance.BorderColor = Color.Black;
            btnVolver.FlatAppearance.MouseOverBackColor = Color.Red;
            btnVolver.FlatStyle = FlatStyle.Flat;
            btnVolver.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnVolver.ForeColor = Color.White;
            btnVolver.Location = new Point(79, 357);
            btnVolver.Margin = new Padding(3, 4, 3, 4);
            btnVolver.Name = "btnVolver";
            btnVolver.Size = new Size(124, 41);
            btnVolver.TabIndex = 14;
            btnVolver.Text = "Volver";
            btnVolver.UseVisualStyleBackColor = false;
            btnVolver.Click += btnVolver_Click;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = Properties.Resources.ConViveLogo;
            pictureBox1.Location = new Point(135, 35);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(212, 118);
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox1.TabIndex = 15;
            pictureBox1.TabStop = false;
            // 
            // FormInicioSesion
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(491, 453);
            Controls.Add(pictureBox1);
            Controls.Add(btnVolver);
            Controls.Add(btnIniciarSesion);
            Controls.Add(txtContrasena);
            Controls.Add(txtEmail);
            Controls.Add(label5);
            Controls.Add(label4);
            Margin = new Padding(3, 4, 3, 4);
            Name = "FormInicioSesion";
            Text = "FormInicioSesion";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtContrasena;
        private TextBox txtEmail;
        private Label label5;
        private Label label4;
        private Button btnIniciarSesion;
        private Button btnVolver;
        private PictureBox pictureBox1;
    }
}