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
            btnRegistro.Location = new Point(93, 347);
            btnRegistro.Margin = new Padding(3, 4, 3, 4);
            btnRegistro.Name = "btnRegistro";
            btnRegistro.Size = new Size(131, 31);
            btnRegistro.TabIndex = 0;
            btnRegistro.Text = "Registrate";
            btnRegistro.UseVisualStyleBackColor = true;
            btnRegistro.Click += btnRegistro_Click;
            // 
            // btnInicioSesion
            // 
            btnInicioSesion.Location = new Point(253, 347);
            btnInicioSesion.Margin = new Padding(3, 4, 3, 4);
            btnInicioSesion.Name = "btnInicioSesion";
            btnInicioSesion.Size = new Size(131, 31);
            btnInicioSesion.TabIndex = 1;
            btnInicioSesion.Text = "Inicio de sesion";
            btnInicioSesion.UseVisualStyleBackColor = true;
            btnInicioSesion.Click += btnInicioSesion_Click;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(81, 47);
            pictureBox1.Margin = new Padding(3, 4, 3, 4);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(316, 276);
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.TabIndex = 3;
            pictureBox1.TabStop = false;
            // 
            // FormLogs
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(482, 453);
            Controls.Add(pictureBox1);
            Controls.Add(btnInicioSesion);
            Controls.Add(btnRegistro);
            Margin = new Padding(3, 4, 3, 4);
            Name = "FormLogs";
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
