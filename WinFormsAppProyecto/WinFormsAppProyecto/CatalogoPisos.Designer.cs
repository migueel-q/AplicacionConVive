namespace Formularios
{
    partial class CatalogoPisos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CatalogoPisos));
            dgvCatalogoPisos = new DataGridView();
            label1 = new Label();
            cmbFiltrar = new ComboBox();
            txtFiltrar = new TextBox();
            pictureBox1 = new PictureBox();
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            SuspendLayout();
            // 
            // dgvCatalogoPisos
            // 
            dgvCatalogoPisos.BackgroundColor = Color.DarkRed;
            dgvCatalogoPisos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCatalogoPisos.GridColor = Color.Black;
            dgvCatalogoPisos.Location = new Point(12, 108);
            dgvCatalogoPisos.Name = "dgvCatalogoPisos";
            dgvCatalogoPisos.RowHeadersWidth = 51;
            dgvCatalogoPisos.Size = new Size(999, 370);
            dgvCatalogoPisos.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(618, 45);
            label1.Name = "label1";
            label1.Size = new Size(69, 28);
            label1.TabIndex = 1;
            label1.Text = "Filtrar";
            // 
            // cmbFiltrar
            // 
            cmbFiltrar.FormattingEnabled = true;
            cmbFiltrar.Location = new Point(693, 46);
            cmbFiltrar.Name = "cmbFiltrar";
            cmbFiltrar.Size = new Size(151, 28);
            cmbFiltrar.TabIndex = 2;
            // 
            // txtFiltrar
            // 
            txtFiltrar.Location = new Point(862, 46);
            txtFiltrar.Name = "txtFiltrar";
            txtFiltrar.Size = new Size(149, 27);
            txtFiltrar.TabIndex = 3;
            txtFiltrar.TextChanged += txtFiltrar_TextChanged;
            // 
            // pictureBox1
            // 
            pictureBox1.Image = Properties.Resources.ConViveLogo;
            pictureBox1.Location = new Point(12, 3);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(215, 105);
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox1.TabIndex = 4;
            pictureBox1.TabStop = false;
            // 
            // CatalogoPisos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(1023, 490);
            Controls.Add(pictureBox1);
            Controls.Add(txtFiltrar);
            Controls.Add(cmbFiltrar);
            Controls.Add(label1);
            Controls.Add(dgvCatalogoPisos);
            Icon = (Icon)resources.GetObject("$this.Icon");
            Name = "CatalogoPisos";
            ShowIcon = false;
            Text = "CatalogoPisos";
            Load += CatalogoPisos_Load;
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView dgvCatalogoPisos;
        private Label label1;
        private ComboBox cmbFiltrar;
        private TextBox txtFiltrar;
        private PictureBox pictureBox1;
    }
}