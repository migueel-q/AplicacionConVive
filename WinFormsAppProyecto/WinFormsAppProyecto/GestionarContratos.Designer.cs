namespace Formularios
{
    partial class GestionarContratos
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
            dgvContratos = new DataGridView();
            btnAceptarContrato = new Button();
            btnDenegar = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvContratos).BeginInit();
            SuspendLayout();
            // 
            // dgvContratos
            // 
            dgvContratos.BackgroundColor = Color.DarkRed;
            dgvContratos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvContratos.GridColor = Color.Black;
            dgvContratos.Location = new Point(12, 32);
            dgvContratos.Name = "dgvContratos";
            dgvContratos.RowHeadersWidth = 51;
            dgvContratos.Size = new Size(850, 364);
            dgvContratos.TabIndex = 0;
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
            btnAceptarContrato.Location = new Point(253, 418);
            btnAceptarContrato.Name = "btnAceptarContrato";
            btnAceptarContrato.Size = new Size(111, 47);
            btnAceptarContrato.TabIndex = 1;
            btnAceptarContrato.Text = "Aceptar";
            btnAceptarContrato.UseVisualStyleBackColor = false;
            btnAceptarContrato.Click += btnAceptarContrato_Click;
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
            btnDenegar.Location = new Point(520, 418);
            btnDenegar.Name = "btnDenegar";
            btnDenegar.Size = new Size(111, 47);
            btnDenegar.TabIndex = 2;
            btnDenegar.Text = "Denegar";
            btnDenegar.UseVisualStyleBackColor = false;
            btnDenegar.Click += btnDenegar_Click;
            // 
            // GestionarContratos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(874, 500);
            Controls.Add(btnDenegar);
            Controls.Add(btnAceptarContrato);
            Controls.Add(dgvContratos);
            Name = "GestionarContratos";
            Text = "GestionarContratos";
            Load += GestionarContratos_Load;
            ((System.ComponentModel.ISupportInitialize)dgvContratos).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private DataGridView dgvContratos;
        private Button btnAceptarContrato;
        private Button btnDenegar;
    }
}