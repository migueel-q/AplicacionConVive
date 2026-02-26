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
            btnDescargar.Location = new Point(337, 225);
            btnDescargar.Name = "btnDescargar";
            btnDescargar.Size = new Size(94, 29);
            btnDescargar.TabIndex = 0;
            btnDescargar.Text = "Descargar";
            btnDescargar.UseVisualStyleBackColor = true;
            btnDescargar.Click += btnDescargar_Click;
            // 
            // VerInforme
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnDescargar);
            Name = "VerInforme";
            Text = "VerInforme";
            ResumeLayout(false);
        }

        #endregion

        private Button btnDescargar;
    }
}