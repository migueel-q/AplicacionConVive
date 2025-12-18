namespace WinFormsAppProyecto
{
    partial class FormLogs
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormLogs));
            btnRegistro = new Button();
            btnInicioSesion = new Button();
            pictureBox1 = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // btnRegistro
            // 
            btnRegistro.Location = new Point(34, 190);
            btnRegistro.Name = "btnRegistro";
            btnRegistro.Size = new Size(115, 23);
            btnRegistro.TabIndex = 0;
            btnRegistro.Text = "Registrate";
            btnRegistro.UseVisualStyleBackColor = true;
            // 
            // btnInicioSesion
            // 
            btnInicioSesion.Location = new Point(174, 190);
            btnInicioSesion.Name = "btnInicioSesion";
            btnInicioSesion.Size = new Size(115, 23);
            btnInicioSesion.TabIndex = 1;
            btnInicioSesion.Text = "Inicio de sesion";
            btnInicioSesion.UseVisualStyleBackColor = true;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(34, 33);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(255, 113);
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.TabIndex = 3;
            pictureBox1.TabStop = false;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(322, 234);
            Controls.Add(pictureBox1);
            Controls.Add(btnInicioSesion);
            Controls.Add(btnRegistro);
            Name = "Form1";
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button btnRegistro;
        private Button btnInicioSesion;
        private PictureBox pictureBox1;
    }
}
