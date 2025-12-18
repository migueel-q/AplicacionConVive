namespace UserControlLib
{
    partial class FichaPiso
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

        #region Component Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            pictureBox1 = new PictureBox();
            calle_lbl = new Label();
            ciudad_lbl = new Label();
            descripcion_lbl = new Label();
            provincia_lbl = new Label();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.Location = new Point(3, 14);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(183, 179);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // calle_lbl
            // 
            calle_lbl.AutoSize = true;
            calle_lbl.Location = new Point(217, 24);
            calle_lbl.Name = "calle_lbl";
            calle_lbl.Size = new Size(33, 15);
            calle_lbl.TabIndex = 1;
            calle_lbl.Text = "Calle";
            // 
            // ciudad_lbl
            // 
            ciudad_lbl.AutoSize = true;
            ciudad_lbl.Location = new Point(217, 60);
            ciudad_lbl.Name = "ciudad_lbl";
            ciudad_lbl.Size = new Size(45, 15);
            ciudad_lbl.TabIndex = 2;
            ciudad_lbl.Text = "Ciudad";
            // 
            // descripcion_lbl
            // 
            descripcion_lbl.AutoSize = true;
            descripcion_lbl.Location = new Point(217, 136);
            descripcion_lbl.Name = "descripcion_lbl";
            descripcion_lbl.Size = new Size(69, 15);
            descripcion_lbl.TabIndex = 3;
            descripcion_lbl.Text = "Descripcion";
            descripcion_lbl.Click += label1_Click;
            // 
            // provincia_lbl
            // 
            provincia_lbl.AutoSize = true;
            provincia_lbl.Location = new Point(217, 90);
            provincia_lbl.Name = "provincia_lbl";
            provincia_lbl.Size = new Size(56, 15);
            provincia_lbl.TabIndex = 4;
            provincia_lbl.Text = "Provincia";
            // 
            // FichaPiso
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            Controls.Add(provincia_lbl);
            Controls.Add(descripcion_lbl);
            Controls.Add(ciudad_lbl);
            Controls.Add(calle_lbl);
            Controls.Add(pictureBox1);
            Name = "FichaPiso";
            Size = new Size(418, 211);
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private PictureBox pictureBox1;
        private Label calle_lbl;
        private Label ciudad_lbl;
        private Label descripcion_lbl;
        private Label provincia_lbl;
    }
}
