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
            components = new System.ComponentModel.Container();
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
            errorProvider = new ErrorProvider(components);
            ((System.ComponentModel.ISupportInitialize)errorProvider).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(142, 88);
            label1.Margin = new Padding(4, 0, 4, 0);
            label1.Name = "label1";
            label1.Size = new Size(47, 23);
            label1.TabIndex = 0;
            label1.Text = "Calle";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(142, 218);
            label2.Margin = new Padding(4, 0, 4, 0);
            label2.Name = "label2";
            label2.Size = new Size(80, 23);
            label2.TabIndex = 1;
            label2.Text = "Provincia";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(429, 308);
            label5.Margin = new Padding(4, 0, 4, 0);
            label5.Name = "label5";
            label5.Size = new Size(98, 23);
            label5.TabIndex = 4;
            label5.Text = "Descripción";
            // 
            // txtCalle
            // 
            txtCalle.Location = new Point(230, 85);
            txtCalle.Margin = new Padding(4, 3, 4, 3);
            txtCalle.Name = "txtCalle";
            txtCalle.Size = new Size(224, 30);
            txtCalle.TabIndex = 5;
            // 
            // txtProvincia
            // 
            txtProvincia.Location = new Point(230, 215);
            txtProvincia.Margin = new Padding(4, 3, 4, 3);
            txtProvincia.Name = "txtProvincia";
            txtProvincia.Size = new Size(224, 30);
            txtProvincia.TabIndex = 6;
            // 
            // btnGuardarPiso
            // 
            btnGuardarPiso.BackColor = Color.DarkRed;
            btnGuardarPiso.Cursor = Cursors.Hand;
            btnGuardarPiso.FlatAppearance.BorderColor = Color.Black;
            btnGuardarPiso.FlatAppearance.MouseOverBackColor = Color.Red;
            btnGuardarPiso.FlatStyle = FlatStyle.Flat;
            btnGuardarPiso.ForeColor = Color.White;
            btnGuardarPiso.Location = new Point(410, 506);
            btnGuardarPiso.Margin = new Padding(4, 3, 4, 3);
            btnGuardarPiso.Name = "btnGuardarPiso";
            btnGuardarPiso.Size = new Size(135, 44);
            btnGuardarPiso.TabIndex = 9;
            btnGuardarPiso.Text = "Guardar";
            btnGuardarPiso.UseVisualStyleBackColor = false;
            btnGuardarPiso.Click += btnGuardarPiso_Click;
            // 
            // richTextBoxDesc
            // 
            richTextBoxDesc.Location = new Point(142, 348);
            richTextBoxDesc.Margin = new Padding(4, 3, 4, 3);
            richTextBoxDesc.Name = "richTextBoxDesc";
            richTextBoxDesc.Size = new Size(682, 137);
            richTextBoxDesc.TabIndex = 10;
            richTextBoxDesc.Text = "";
            // 
            // txtCiudad
            // 
            txtCiudad.Location = new Point(230, 151);
            txtCiudad.Margin = new Padding(4, 3, 4, 3);
            txtCiudad.Name = "txtCiudad";
            txtCiudad.Size = new Size(224, 30);
            txtCiudad.TabIndex = 12;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(142, 151);
            label6.Margin = new Padding(4, 0, 4, 0);
            label6.Name = "label6";
            label6.Size = new Size(64, 23);
            label6.TabIndex = 11;
            label6.Text = "Ciudad";
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(624, 85);
            txtImagen.Margin = new Padding(4, 3, 4, 3);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(200, 30);
            txtImagen.TabIndex = 14;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(536, 85);
            label7.Margin = new Padding(4, 0, 4, 0);
            label7.Name = "label7";
            label7.Size = new Size(68, 23);
            label7.TabIndex = 13;
            label7.Text = "Imagen";
            // 
            // txtPrecio
            // 
            txtPrecio.Location = new Point(624, 148);
            txtPrecio.Margin = new Padding(4, 3, 4, 3);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(200, 30);
            txtPrecio.TabIndex = 16;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(536, 151);
            label8.Margin = new Padding(4, 0, 4, 0);
            label8.Name = "label8";
            label8.Size = new Size(57, 23);
            label8.TabIndex = 15;
            label8.Text = "Precio";
            // 
            // errorProvider
            // 
            errorProvider.ContainerControl = this;
            // 
            // FormAñadirPiso
            // 
            AutoScaleDimensions = new SizeF(10F, 23F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(959, 589);
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
            ForeColor = Color.Black;
            Margin = new Padding(4, 3, 4, 3);
            Name = "FormAñadirPiso";
            Text = "Añadir Piso";
            Load += FormAñadirPiso_Load;
            ((System.ComponentModel.ISupportInitialize)errorProvider).EndInit();
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
        private ErrorProvider errorProvider;
    }
}