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
            dgvCatalogoPisos = new DataGridView();
            label1 = new Label();
            cmbFiltrar = new ComboBox();
            txtFiltrar = new TextBox();
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).BeginInit();
            SuspendLayout();
            // 
            // dgvCatalogoPisos
            // 
            dgvCatalogoPisos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCatalogoPisos.Location = new Point(12, 57);
            dgvCatalogoPisos.Name = "dgvCatalogoPisos";
            dgvCatalogoPisos.RowHeadersWidth = 51;
            dgvCatalogoPisos.Size = new Size(776, 362);
            dgvCatalogoPisos.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(411, 23);
            label1.Name = "label1";
            label1.Size = new Size(47, 20);
            label1.TabIndex = 1;
            label1.Text = "Filtrar";
            // 
            // cmbFiltrar
            // 
            cmbFiltrar.FormattingEnabled = true;
            cmbFiltrar.Location = new Point(473, 20);
            cmbFiltrar.Name = "cmbFiltrar";
            cmbFiltrar.Size = new Size(151, 28);
            cmbFiltrar.TabIndex = 2;
            // 
            // txtFiltrar
            // 
            txtFiltrar.Location = new Point(639, 20);
            txtFiltrar.Name = "txtFiltrar";
            txtFiltrar.Size = new Size(149, 27);
            txtFiltrar.TabIndex = 3;
            txtFiltrar.TextChanged += txtFiltrar_TextChanged;
            // 
            // CatalogoPisos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(txtFiltrar);
            Controls.Add(cmbFiltrar);
            Controls.Add(label1);
            Controls.Add(dgvCatalogoPisos);
            Name = "CatalogoPisos";
            Text = "CatalogoPisos";
            Load += CatalogoPisos_Load;
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView dgvCatalogoPisos;
        private Label label1;
        private ComboBox cmbFiltrar;
        private TextBox txtFiltrar;
    }
}