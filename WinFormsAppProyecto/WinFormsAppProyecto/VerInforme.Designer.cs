namespace Formularios
{
    partial class VerInforme
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
            btnDescargar = new Button();
            SuspendLayout();
            // 
            // btnDescargar
            // 
            btnDescargar.BackColor = Color.DarkRed;
            btnDescargar.Cursor = Cursors.Hand;
            btnDescargar.FlatAppearance.BorderColor = Color.Black;
            btnDescargar.FlatAppearance.MouseOverBackColor = Color.Red;
            btnDescargar.FlatStyle = FlatStyle.Flat;
            btnDescargar.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnDescargar.ForeColor = Color.White;
            btnDescargar.Location = new Point(243, 159);
            btnDescargar.Name = "btnDescargar";
            btnDescargar.Size = new Size(111, 47);
            btnDescargar.TabIndex = 0;
            btnDescargar.Text = "Descargar";
            btnDescargar.UseVisualStyleBackColor = false;
            btnDescargar.Click += btnDescargar_Click;
            // 
            // VerInforme
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(640, 385);
            Controls.Add(btnDescargar);
            Name = "VerInforme";
            Text = "VerInforme";
            ResumeLayout(false);
        }

        #endregion

        private Button btnDescargar;
    }
}