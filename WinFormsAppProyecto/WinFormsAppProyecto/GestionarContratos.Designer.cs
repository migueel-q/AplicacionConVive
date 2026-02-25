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
            button1 = new Button();
            btnDenegar = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvContratos).BeginInit();
            SuspendLayout();
            // 
            // dgvContratos
            // 
            dgvContratos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvContratos.Location = new Point(12, 32);
            dgvContratos.Name = "dgvContratos";
            dgvContratos.RowHeadersWidth = 51;
            dgvContratos.Size = new Size(850, 364);
            dgvContratos.TabIndex = 0;
            // 
            // button1
            // 
            button1.Location = new Point(188, 436);
            button1.Name = "button1";
            button1.Size = new Size(94, 29);
            button1.TabIndex = 1;
            button1.Text = "Aceptar";
            button1.UseVisualStyleBackColor = true;
            // 
            // btnDenegar
            // 
            btnDenegar.Location = new Point(557, 436);
            btnDenegar.Name = "btnDenegar";
            btnDenegar.Size = new Size(94, 29);
            btnDenegar.TabIndex = 2;
            btnDenegar.Text = "Denegar";
            btnDenegar.UseVisualStyleBackColor = true;
            // 
            // GestionarContratos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(874, 500);
            Controls.Add(btnDenegar);
            Controls.Add(button1);
            Controls.Add(dgvContratos);
            Name = "GestionarContratos";
            Text = "GestionarContratos";
            Load += GestionarContratos_Load;
            ((System.ComponentModel.ISupportInitialize)dgvContratos).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private DataGridView dgvContratos;
        private Button button1;
        private Button btnDenegar;
    }
}