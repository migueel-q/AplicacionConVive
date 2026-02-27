namespace Formularios
{
    partial class GestionSolicitudes
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
            btnDenegar = new Button();
            btnAceptarContrato = new Button();
            dgvSolicitudes = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dgvSolicitudes).BeginInit();
            SuspendLayout();
            // 
            // btnDenegar
            // 
            btnDenegar.BackColor = Color.DarkRed;
            btnDenegar.Cursor = Cursors.Hand;
            btnDenegar.FlatAppearance.BorderColor = Color.Black;
            btnDenegar.FlatAppearance.MouseOverBackColor = Color.Red;
            btnDenegar.FlatStyle = FlatStyle.Flat;
            btnDenegar.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            btnDenegar.ForeColor = Color.White;
            btnDenegar.Location = new Point(504, 398);
            btnDenegar.Name = "btnDenegar";
            btnDenegar.Size = new Size(111, 47);
            btnDenegar.TabIndex = 5;
            btnDenegar.Text = "Denegar";
            btnDenegar.UseVisualStyleBackColor = false;
            btnDenegar.Click += btnDenegar_Click;
            // 
            // btnAceptarContrato
            // 
            btnAceptarContrato.BackColor = Color.DarkRed;
            btnAceptarContrato.Cursor = Cursors.Hand;
            btnAceptarContrato.FlatAppearance.BorderColor = Color.Black;
            btnAceptarContrato.FlatAppearance.MouseOverBackColor = Color.Red;
            btnAceptarContrato.FlatStyle = FlatStyle.Flat;
            btnAceptarContrato.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            btnAceptarContrato.ForeColor = Color.White;
            btnAceptarContrato.Location = new Point(237, 398);
            btnAceptarContrato.Name = "btnAceptarContrato";
            btnAceptarContrato.Size = new Size(111, 47);
            btnAceptarContrato.TabIndex = 4;
            btnAceptarContrato.Text = "Aceptar";
            btnAceptarContrato.UseVisualStyleBackColor = false;
            btnAceptarContrato.Click += btnAceptarContrato_Click;
            // 
            // dgvSolicitudes
            // 
            dgvSolicitudes.BackgroundColor = Color.DarkRed;
            dgvSolicitudes.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvSolicitudes.GridColor = Color.Black;
            dgvSolicitudes.Location = new Point(12, 12);
            dgvSolicitudes.Name = "dgvSolicitudes";
            dgvSolicitudes.RowHeadersWidth = 51;
            dgvSolicitudes.Size = new Size(850, 364);
            dgvSolicitudes.TabIndex = 3;
            // 
            // GestionSolicitudes
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(874, 479);
            Controls.Add(btnDenegar);
            Controls.Add(btnAceptarContrato);
            Controls.Add(dgvSolicitudes);
            Name = "GestionSolicitudes";
            Text = "GestionOfertas";
            Load += GestionSolicitudes_Load;
            ((System.ComponentModel.ISupportInitialize)dgvSolicitudes).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button btnDenegar;
        private Button btnAceptarContrato;
        private DataGridView dgvSolicitudes;
    }
}