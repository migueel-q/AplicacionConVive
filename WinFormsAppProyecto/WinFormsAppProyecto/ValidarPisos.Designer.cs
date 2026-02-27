namespace Formularios
{
    partial class ValidarPisos
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
            dgvPisos = new DataGridView();
            btnValidarPiso = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvPisos).BeginInit();
            SuspendLayout();
            // 
            // dgvPisos
            // 
            dgvPisos.BackgroundColor = Color.DarkRed;
            dgvPisos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvPisos.Location = new Point(12, 22);
            dgvPisos.Name = "dgvPisos";
            dgvPisos.RowHeadersWidth = 51;
            dgvPisos.Size = new Size(776, 350);
            dgvPisos.TabIndex = 0;
            // 
            // btnValidarPiso
            // 
            btnValidarPiso.BackColor = Color.DarkRed;
            btnValidarPiso.Cursor = Cursors.Hand;
            btnValidarPiso.FlatAppearance.BorderColor = Color.Black;
            btnValidarPiso.FlatAppearance.MouseOverBackColor = Color.Red;
            btnValidarPiso.FlatStyle = FlatStyle.Flat;
            btnValidarPiso.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnValidarPiso.ForeColor = Color.White;
            btnValidarPiso.Location = new Point(345, 394);
            btnValidarPiso.Name = "btnValidarPiso";
            btnValidarPiso.Size = new Size(114, 44);
            btnValidarPiso.TabIndex = 1;
            btnValidarPiso.Text = "Validar";
            btnValidarPiso.UseVisualStyleBackColor = false;
            btnValidarPiso.Click += btnValidarPiso_Click;
            // 
            // ValidarPisos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(800, 450);
            Controls.Add(btnValidarPiso);
            Controls.Add(dgvPisos);
            Name = "ValidarPisos";
            Text = "ValidarPisos";
            Load += ValidarPisos_Load;
            ((System.ComponentModel.ISupportInitialize)dgvPisos).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private DataGridView dgvPisos;
        private Button btnValidarPiso;
    }
}