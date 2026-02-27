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
            btnRegistro.BackColor = Color.DarkRed;
            btnRegistro.BackgroundImageLayout = ImageLayout.None;
            btnRegistro.Cursor = Cursors.Hand;
            btnRegistro.FlatAppearance.BorderColor = Color.Black;
            btnRegistro.FlatAppearance.MouseOverBackColor = Color.Red;
            btnRegistro.FlatStyle = FlatStyle.Flat;
            btnRegistro.ForeColor = Color.White;
            btnRegistro.Location = new Point(101, 397);
            btnRegistro.Margin = new Padding(4, 5, 4, 5);
            btnRegistro.Name = "btnRegistro";
            btnRegistro.Size = new Size(179, 38);
            btnRegistro.TabIndex = 0;
            btnRegistro.Text = "Registrate";
            btnRegistro.UseVisualStyleBackColor = false;
            btnRegistro.Click += btnRegistro_Click;
            // 
            // btnInicioSesion
            // 
            btnInicioSesion.BackColor = Color.DarkRed;
            btnInicioSesion.BackgroundImageLayout = ImageLayout.None;
            btnInicioSesion.Cursor = Cursors.Hand;
            btnInicioSesion.FlatAppearance.BorderColor = Color.Black;
            btnInicioSesion.FlatAppearance.MouseOverBackColor = Color.Red;
            btnInicioSesion.FlatStyle = FlatStyle.Flat;
            btnInicioSesion.ForeColor = Color.White;
            btnInicioSesion.Location = new Point(318, 397);
            btnInicioSesion.Margin = new Padding(4, 5, 4, 5);
            btnInicioSesion.Name = "btnInicioSesion";
            btnInicioSesion.Size = new Size(179, 38);
            btnInicioSesion.TabIndex = 1;
            btnInicioSesion.Text = "Inicio de sesion";
            btnInicioSesion.UseVisualStyleBackColor = false;
            btnInicioSesion.Click += btnInicioSesion_Click;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(101, 54);
            pictureBox1.Margin = new Padding(4, 5, 4, 5);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(396, 317);
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.TabIndex = 3;
            pictureBox1.TabStop = false;
            // 
            // FormLogs
            // 
            AutoScaleDimensions = new SizeF(10F, 23F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(602, 521);
            Controls.Add(pictureBox1);
            Controls.Add(btnInicioSesion);
            Controls.Add(btnRegistro);
            Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Icon = (Icon)resources.GetObject("$this.Icon");
            Margin = new Padding(4, 5, 4, 5);
            Name = "FormLogs";
            ShowIcon = false;
            Text = "ConVive";
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button btnRegistro;
        private Button btnInicioSesion;
        private PictureBox pictureBox1;
    }
}
