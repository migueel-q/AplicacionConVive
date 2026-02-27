namespace Formularios
{
    partial class AñadirGastos
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
            Concepto = new Label();
            label2 = new Label();
            txtConcepto = new TextBox();
            txtValor = new TextBox();
            btnAnadirGasto = new Button();
            SuspendLayout();
            // 
            // Concepto
            // 
            Concepto.AutoSize = true;
            Concepto.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            Concepto.Location = new Point(361, 106);
            Concepto.Name = "Concepto";
            Concepto.Size = new Size(84, 23);
            Concepto.TabIndex = 0;
            Concepto.Text = "Concepto";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            label2.Location = new Point(361, 230);
            label2.Name = "label2";
            label2.Size = new Size(49, 23);
            label2.TabIndex = 1;
            label2.Text = "Valor";
            // 
            // txtConcepto
            // 
            txtConcepto.Location = new Point(227, 143);
            txtConcepto.Name = "txtConcepto";
            txtConcepto.Size = new Size(345, 27);
            txtConcepto.TabIndex = 2;
            // 
            // txtValor
            // 
            txtValor.Location = new Point(323, 267);
            txtValor.Name = "txtValor";
            txtValor.Size = new Size(125, 27);
            txtValor.TabIndex = 3;
            // 
            // btnAnadirGasto
            // 
            btnAnadirGasto.BackColor = Color.DarkRed;
            btnAnadirGasto.ForeColor = SystemColors.ControlLightLight;
            btnAnadirGasto.Location = new Point(340, 362);
            btnAnadirGasto.Name = "btnAnadirGasto";
            btnAnadirGasto.Size = new Size(94, 29);
            btnAnadirGasto.TabIndex = 4;
            btnAnadirGasto.Text = "Añadir";
            btnAnadirGasto.UseVisualStyleBackColor = false;
            btnAnadirGasto.Click += btnAnadirGasto_Click;
            // 
            // AñadirGastos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnAnadirGasto);
            Controls.Add(txtValor);
            Controls.Add(txtConcepto);
            Controls.Add(label2);
            Controls.Add(Concepto);
            Name = "AñadirGastos";
            Text = "AñadirGastos";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label Concepto;
        private Label label2;
        private TextBox txtConcepto;
        private TextBox txtValor;
        private Button btnAnadirGasto;
    }
}