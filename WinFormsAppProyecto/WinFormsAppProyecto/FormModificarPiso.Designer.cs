namespace Formularios
{
    partial class FormModificarPiso
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
            txtImagen = new TextBox();
            label7 = new Label();
            txtCiudad = new TextBox();
            label6 = new Label();
            richTextBoxDesc = new RichTextBox();
            btnGuardarPiso = new Button();
            txtProvincia = new TextBox();
            txtCalle = new TextBox();
            label5 = new Label();
            label2 = new Label();
            label1 = new Label();
            SuspendLayout();
            // 
            // txtPrecio
            // 
            txtPrecio.Location = new Point(568, 85);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(161, 27);
            txtPrecio.TabIndex = 29;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(456, 92);
            label8.Name = "label8";
            label8.Size = new Size(50, 20);
            label8.TabIndex = 28;
            label8.Text = "Precio";
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(568, 32);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(161, 27);
            txtImagen.TabIndex = 27;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(456, 39);
            label7.Name = "label7";
            label7.Size = new Size(59, 20);
            label7.TabIndex = 26;
            label7.Text = "Imagen";
            // 
            // txtCiudad
            // 
            txtCiudad.Location = new Point(183, 85);
            txtCiudad.Name = "txtCiudad";
            txtCiudad.Size = new Size(180, 27);
            txtCiudad.TabIndex = 25;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(71, 88);
            label6.Name = "label6";
            label6.Size = new Size(56, 20);
            label6.TabIndex = 24;
            label6.Text = "Ciudad";
            // 
            // richTextBoxDesc
            // 
            richTextBoxDesc.Location = new Point(183, 206);
            richTextBoxDesc.Name = "richTextBoxDesc";
            richTextBoxDesc.Size = new Size(546, 120);
            richTextBoxDesc.TabIndex = 23;
            richTextBoxDesc.Text = "";
            // 
            // btnGuardarPiso
            // 
            btnGuardarPiso.Location = new Point(378, 390);
            btnGuardarPiso.Name = "btnGuardarPiso";
            btnGuardarPiso.Size = new Size(94, 29);
            btnGuardarPiso.TabIndex = 22;
            btnGuardarPiso.Text = "Modificar";
            btnGuardarPiso.UseVisualStyleBackColor = true;
            btnGuardarPiso.Click += btnGuardarPiso_Click;
            // 
            // txtProvincia
            // 
            txtProvincia.Location = new Point(183, 135);
            txtProvincia.Name = "txtProvincia";
            txtProvincia.Size = new Size(180, 27);
            txtProvincia.TabIndex = 21;
            // 
            // txtCalle
            // 
            txtCalle.Location = new Point(183, 32);
            txtCalle.Name = "txtCalle";
            txtCalle.Size = new Size(180, 27);
            txtCalle.TabIndex = 20;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(71, 209);
            label5.Name = "label5";
            label5.Size = new Size(87, 20);
            label5.TabIndex = 19;
            label5.Text = "Descripción";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(71, 142);
            label2.Name = "label2";
            label2.Size = new Size(69, 20);
            label2.TabIndex = 18;
            label2.Text = "Provincia";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(71, 35);
            label1.Name = "label1";
            label1.Size = new Size(42, 20);
            label1.TabIndex = 17;
            label1.Text = "Calle";
            // 
            // FormModificarPiso
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
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
            Name = "FormModificarPiso";
            Text = "FormModificarPiso";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtPrecio;
        private Label label8;
        private TextBox txtImagen;
        private Label label7;
        private TextBox txtCiudad;
        private Label label6;
        private RichTextBox richTextBoxDesc;
        private Button btnGuardarPiso;
        private TextBox txtProvincia;
        private TextBox txtCalle;
        private Label label5;
        private Label label2;
        private Label label1;
    }
}