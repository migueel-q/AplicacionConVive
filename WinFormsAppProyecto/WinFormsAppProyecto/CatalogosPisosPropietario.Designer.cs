namespace Formularios
{
    partial class CatalogosPisosPropietario
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
            pictureBox1 = new PictureBox();
            dgvCatalogoPisos = new DataGridView();
            btnOcupado = new Button();
            btnDesocupar = new Button();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.Image = Properties.Resources.ConViveLogo;
            pictureBox1.Location = new Point(12, 12);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(215, 105);
            pictureBox1.SizeMode = PictureBoxSizeMode.CenterImage;
            pictureBox1.TabIndex = 9;
            pictureBox1.TabStop = false;
            // 
            // dgvCatalogoPisos
            // 
            dgvCatalogoPisos.BackgroundColor = Color.DarkRed;
            dgvCatalogoPisos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCatalogoPisos.GridColor = Color.Black;
            dgvCatalogoPisos.Location = new Point(12, 117);
            dgvCatalogoPisos.Name = "dgvCatalogoPisos";
            dgvCatalogoPisos.RowHeadersWidth = 51;
            dgvCatalogoPisos.Size = new Size(999, 321);
            dgvCatalogoPisos.TabIndex = 5;
            dgvCatalogoPisos.CellDoubleClick += dgvCatalogoPisos_CellDoubleClick;
            // 
            // btnOcupado
            // 
            btnOcupado.BackColor = Color.DarkRed;
            btnOcupado.ForeColor = SystemColors.ControlLightLight;
            btnOcupado.Location = new Point(618, 453);
            btnOcupado.Name = "btnOcupado";
            btnOcupado.Size = new Size(94, 29);
            btnOcupado.TabIndex = 10;
            btnOcupado.Text = "Ocupar";
            btnOcupado.UseVisualStyleBackColor = false;
            btnOcupado.Click += btnOcupado_Click;
            // 
            // btnDesocupar
            // 
            btnDesocupar.BackColor = Color.DarkRed;
            btnDesocupar.ForeColor = SystemColors.ControlLightLight;
            btnDesocupar.Location = new Point(274, 453);
            btnDesocupar.Name = "btnDesocupar";
            btnDesocupar.Size = new Size(94, 29);
            btnDesocupar.TabIndex = 11;
            btnDesocupar.Text = "Desocupar";
            btnDesocupar.UseVisualStyleBackColor = false;
            btnDesocupar.Click += btnDesocupar_Click;
            // 
            // CatalogosPisosPropietario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1026, 503);
            Controls.Add(btnDesocupar);
            Controls.Add(btnOcupado);
            Controls.Add(pictureBox1);
            Controls.Add(dgvCatalogoPisos);
            Name = "CatalogosPisosPropietario";
            Text = "CatalogosPisosPropietario";
            Load += CatalogosPisosPropietario_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ((System.ComponentModel.ISupportInitialize)dgvCatalogoPisos).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private PictureBox pictureBox1;
        private DataGridView dgvCatalogoPisos;
        private Button btnOcupado;
        private Button btnDesocupar;
    }
}