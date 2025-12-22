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
            SuspendLayout();
            // 
            // txtContrasena
            // 
            txtContrasena.Location = new Point(114, 156);
            txtContrasena.Name = "txtContrasena";
            txtContrasena.Size = new Size(100, 23);
            txtContrasena.TabIndex = 12;
            // 
            // txtEmail
            // 
            txtEmail.Location = new Point(114, 101);
            txtEmail.Name = "txtEmail";
            txtEmail.Size = new Size(100, 23);
            txtEmail.TabIndex = 11;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(101, 138);
            label5.Name = "label5";
            label5.Size = new Size(134, 15);
            label5.TabIndex = 10;
            label5.Text = "Introduce la contraseña:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(114, 83);
            label4.Name = "label4";
            label4.Size = new Size(107, 15);
            label4.TabIndex = 9;
            label4.Text = "Introduce tu email:";
            // 
            // btnIniciarSesion
            // 
            btnIniciarSesion.Location = new Point(183, 225);
            btnIniciarSesion.Name = "btnIniciarSesion";
            btnIniciarSesion.Size = new Size(89, 23);
            btnIniciarSesion.TabIndex = 13;
            btnIniciarSesion.Text = "Iniciar sesión";
            btnIniciarSesion.UseVisualStyleBackColor = true;
            btnIniciarSesion.Click += btnIniciarSesion_Click;
            // 
            // btnVolver
            // 
            btnVolver.Location = new Point(54, 225);
            btnVolver.Name = "btnVolver";
            btnVolver.Size = new Size(89, 23);
            btnVolver.TabIndex = 14;
            btnVolver.Text = "Volver";
            btnVolver.UseVisualStyleBackColor = true;
            btnVolver.Click += btnVolver_Click;
            // 
            // FormInicioSesion
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(342, 302);
            Controls.Add(btnVolver);
            Controls.Add(btnIniciarSesion);
            Controls.Add(txtContrasena);
            Controls.Add(txtEmail);
            Controls.Add(label5);
            Controls.Add(label4);
            Name = "FormInicioSesion";
            Text = "FormInicioSesion";
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
    }
}