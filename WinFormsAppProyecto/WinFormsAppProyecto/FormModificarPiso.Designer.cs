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
            txtPrecio.Location = new Point(621, 163);
            txtPrecio.Margin = new Padding(4, 3, 4, 3);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(200, 30);
            txtPrecio.TabIndex = 29;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(528, 166);
            label8.Margin = new Padding(4, 0, 4, 0);
            label8.Name = "label8";
            label8.Size = new Size(57, 23);
            label8.TabIndex = 28;
            label8.Text = "Precio";
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(621, 80);
            txtImagen.Margin = new Padding(4, 3, 4, 3);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(200, 30);
            txtImagen.TabIndex = 27;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(528, 83);
            label7.Margin = new Padding(4, 0, 4, 0);
            label7.Name = "label7";
            label7.Size = new Size(68, 23);
            label7.TabIndex = 26;
            label7.Text = "Imagen";
            // 
            // txtCiudad
            // 
            txtCiudad.Location = new Point(242, 163);
            txtCiudad.Margin = new Padding(4, 3, 4, 3);
            txtCiudad.Name = "txtCiudad";
            txtCiudad.Size = new Size(224, 30);
            txtCiudad.TabIndex = 25;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(139, 163);
            label6.Margin = new Padding(4, 0, 4, 0);
            label6.Name = "label6";
            label6.Size = new Size(64, 23);
            label6.TabIndex = 24;
            label6.Text = "Ciudad";
            // 
            // richTextBoxDesc
            // 
            richTextBoxDesc.Location = new Point(139, 339);
            richTextBoxDesc.Margin = new Padding(4, 3, 4, 3);
            richTextBoxDesc.Name = "richTextBoxDesc";
            richTextBoxDesc.Size = new Size(682, 137);
            richTextBoxDesc.TabIndex = 23;
            richTextBoxDesc.Text = "";
            // 
            // btnGuardarPiso
            // 
            btnGuardarPiso.BackColor = Color.DarkRed;
            btnGuardarPiso.Cursor = Cursors.Hand;
            btnGuardarPiso.FlatAppearance.BorderColor = Color.Black;
            btnGuardarPiso.FlatAppearance.MouseOverBackColor = Color.Red;
            btnGuardarPiso.ForeColor = Color.White;
            btnGuardarPiso.Location = new Point(411, 496);
            btnGuardarPiso.Margin = new Padding(4, 3, 4, 3);
            btnGuardarPiso.Name = "btnGuardarPiso";
            btnGuardarPiso.Size = new Size(141, 48);
            btnGuardarPiso.TabIndex = 22;
            btnGuardarPiso.Text = "Modificar";
            btnGuardarPiso.UseVisualStyleBackColor = false;
            btnGuardarPiso.Click += btnGuardarPiso_Click;
            // 
            // txtProvincia
            // 
            txtProvincia.Location = new Point(242, 234);
            txtProvincia.Margin = new Padding(4, 3, 4, 3);
            txtProvincia.Name = "txtProvincia";
            txtProvincia.Size = new Size(224, 30);
            txtProvincia.TabIndex = 21;
            // 
            // txtCalle
            // 
            txtCalle.Location = new Point(242, 80);
            txtCalle.Margin = new Padding(4, 3, 4, 3);
            txtCalle.Name = "txtCalle";
            txtCalle.Size = new Size(224, 30);
            txtCalle.TabIndex = 20;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(430, 296);
            label5.Margin = new Padding(4, 0, 4, 0);
            label5.Name = "label5";
            label5.Size = new Size(98, 23);
            label5.TabIndex = 19;
            label5.Text = "Descripción";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(139, 237);
            label2.Margin = new Padding(4, 0, 4, 0);
            label2.Name = "label2";
            label2.Size = new Size(80, 23);
            label2.TabIndex = 18;
            label2.Text = "Provincia";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(139, 83);
            label1.Margin = new Padding(4, 0, 4, 0);
            label1.Name = "label1";
            label1.Size = new Size(47, 23);
            label1.TabIndex = 17;
            label1.Text = "Calle";
            // 
            // FormModificarPiso
            // 
            AutoScaleDimensions = new SizeF(10F, 23F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(958, 586);
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
            Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4, 3, 4, 3);
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