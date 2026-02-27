namespace Formularios
{
    partial class FormOfertasSolicitudes
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
            txtPrecio = new TextBox();
            label8 = new Label();
            btnSolicitarPiso = new Button();
            richTextBoxDesc = new RichTextBox();
            label5 = new Label();
            SuspendLayout();
            // 
            // txtPrecio
            // 
            txtPrecio.Location = new Point(222, 142);
            txtPrecio.Margin = new Padding(4, 3, 4, 3);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(200, 27);
            txtPrecio.TabIndex = 29;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(84, 149);
            label8.Margin = new Padding(4, 0, 4, 0);
            label8.Name = "label8";
            label8.Size = new Size(50, 20);
            label8.TabIndex = 28;
            label8.Text = "Precio";
            // 
            // btnSolicitarPiso
            // 
            btnSolicitarPiso.BackColor = Color.DarkRed;
            btnSolicitarPiso.Cursor = Cursors.Hand;
            btnSolicitarPiso.FlatAppearance.BorderColor = Color.Black;
            btnSolicitarPiso.FlatAppearance.MouseOverBackColor = Color.Red;
            btnSolicitarPiso.FlatStyle = FlatStyle.Flat;
            btnSolicitarPiso.ForeColor = Color.White;
            btnSolicitarPiso.Location = new Point(320, 372);
            btnSolicitarPiso.Margin = new Padding(4, 3, 4, 3);
            btnSolicitarPiso.Name = "btnSolicitarPiso";
            btnSolicitarPiso.Size = new Size(135, 44);
            btnSolicitarPiso.TabIndex = 22;
            btnSolicitarPiso.Text = "Solicitar";
            btnSolicitarPiso.UseVisualStyleBackColor = false;
            btnSolicitarPiso.Click += btnSolicitarPiso_Click;
            // 
            // richTextBoxDesc
            // 
            richTextBoxDesc.Location = new Point(222, 216);
            richTextBoxDesc.Margin = new Padding(4, 3, 4, 3);
            richTextBoxDesc.Name = "richTextBoxDesc";
            richTextBoxDesc.Size = new Size(513, 137);
            richTextBoxDesc.TabIndex = 31;
            richTextBoxDesc.Text = "";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(84, 216);
            label5.Margin = new Padding(4, 0, 4, 0);
            label5.Name = "label5";
            label5.Size = new Size(87, 20);
            label5.TabIndex = 30;
            label5.Text = "Descripción";
            // 
            // FormOfertas
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(800, 450);
            Controls.Add(richTextBoxDesc);
            Controls.Add(label5);
            Controls.Add(txtPrecio);
            Controls.Add(label8);
            Controls.Add(btnSolicitarPiso);
            Name = "FormOfertas";
            Text = "FormOfertas";
            Load += FormOfertas_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtPrecio;
        private Label label8;
        private TextBox txtImagen;
        private Label label7;
        private Button btnSolicitarPiso;
        private RichTextBox richTextBoxDesc;
        private Label label5;
    }
}