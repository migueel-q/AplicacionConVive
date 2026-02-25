namespace Formularios
{
    partial class FormAñadirPiso
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
            label1 = new Label();
            label2 = new Label();
            label5 = new Label();
            txtCalle = new TextBox();
            txtProvincia = new TextBox();
            btnGuardarPiso = new Button();
            richTextBoxDesc = new RichTextBox();
            txtCiudad = new TextBox();
            label6 = new Label();
            txtImagen = new TextBox();
            label7 = new Label();
            txtPrecio = new TextBox();
            label8 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(169, 133);
            label1.Name = "label1";
            label1.Size = new Size(42, 20);
            label1.TabIndex = 0;
            label1.Text = "Calle";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(169, 240);
            label2.Name = "label2";
            label2.Size = new Size(69, 20);
            label2.TabIndex = 1;
            label2.Text = "Provincia";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(169, 307);
            label5.Name = "label5";
            label5.Size = new Size(87, 20);
            label5.TabIndex = 4;
            label5.Text = "Descripción";
            // 
            // txtCalle
            // 
            txtCalle.Location = new Point(281, 130);
            txtCalle.Name = "txtCalle";
            txtCalle.Size = new Size(180, 27);
            txtCalle.TabIndex = 5;
            // 
            // txtProvincia
            // 
            txtProvincia.Location = new Point(281, 233);
            txtProvincia.Name = "txtProvincia";
            txtProvincia.Size = new Size(180, 27);
            txtProvincia.TabIndex = 6;
            // 
            // btnGuardarPiso
            // 
            btnGuardarPiso.Location = new Point(476, 488);
            btnGuardarPiso.Name = "btnGuardarPiso";
            btnGuardarPiso.Size = new Size(94, 29);
            btnGuardarPiso.TabIndex = 9;
            btnGuardarPiso.Text = "Guardar";
            btnGuardarPiso.UseVisualStyleBackColor = true;
            btnGuardarPiso.Click += btnGuardarPiso_Click;
            // 
            // richTextBoxDesc
            // 
            richTextBoxDesc.Location = new Point(281, 304);
            richTextBoxDesc.Name = "richTextBoxDesc";
            richTextBoxDesc.Size = new Size(546, 120);
            richTextBoxDesc.TabIndex = 10;
            richTextBoxDesc.Text = "";
            // 
            // txtCiudad
            // 
            txtCiudad.Location = new Point(281, 183);
            txtCiudad.Name = "txtCiudad";
            txtCiudad.Size = new Size(180, 27);
            txtCiudad.TabIndex = 12;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(169, 186);
            label6.Name = "label6";
            label6.Size = new Size(56, 20);
            label6.TabIndex = 11;
            label6.Text = "Ciudad";
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(666, 130);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(161, 27);
            txtImagen.TabIndex = 14;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(554, 137);
            label7.Name = "label7";
            label7.Size = new Size(59, 20);
            label7.TabIndex = 13;
            label7.Text = "Imagen";
            // 
            // txtPrecio
            // 
            txtPrecio.Location = new Point(666, 183);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(161, 27);
            txtPrecio.TabIndex = 16;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(554, 190);
            label8.Name = "label8";
            label8.Size = new Size(50, 20);
            label8.TabIndex = 15;
            label8.Text = "Precio";
            // 
            // FormAñadirPiso
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1049, 582);
            Controls.Add(txtPrecio);
            Controls.Add(label8);
            Controls.Add(txtImagen);
            Controls.Add(label7);
            Controls.Add(txtCiudad);
            Controls.Add(label6);
            Controls.Add(richTextBoxDesc);
            Controls.Add(btnGuardarPiso);
            Controls.Add(txtProvincia);
            Controls.Add(txtCalle);
            Controls.Add(label5);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FormAñadirPiso";
            Text = "Añadir Piso";
            Load += FormAñadirPiso_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label5;
        private TextBox txtCalle;
        private TextBox txtProvincia;
        private Button btnGuardarPiso;
        private RichTextBox richTextBoxDesc;
        private TextBox txtCiudad;
        private Label label6;
        private TextBox txtImagen;
        private Label label7;
        private TextBox txtPrecio;
        private Label label8;
    }
}