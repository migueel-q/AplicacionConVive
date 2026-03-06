namespace Formularios
{
    partial class VerPisoPropietario
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
            pictureBoxImagen = new PictureBox();
            txtUrlImagen = new TextBox();
            lblUrlImagen = new Label();
            txtPropietario = new TextBox();
            lblPropietario = new Label();
            lblDisponible = new Label();
            txtPrecio = new TextBox();
            lblPrecio = new Label();
            txtDescripcion = new TextBox();
            lblDescripcion = new Label();
            txtProvincia = new TextBox();
            lblProvincia = new Label();
            txtCiudad = new TextBox();
            lblCiudad = new Label();
            txtDireccion = new TextBox();
            lblDireccion = new Label();
            checkBoxDisponible = new CheckBox();
            ((System.ComponentModel.ISupportInitialize)pictureBoxImagen).BeginInit();
            SuspendLayout();
            // 
            // pictureBoxImagen
            // 
            pictureBoxImagen.Location = new Point(410, 66);
            pictureBoxImagen.Name = "pictureBoxImagen";
            pictureBoxImagen.Size = new Size(369, 317);
            pictureBoxImagen.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBoxImagen.TabIndex = 38;
            pictureBoxImagen.TabStop = false;
            // 
            // txtUrlImagen
            // 
            txtUrlImagen.Location = new Point(499, 26);
            txtUrlImagen.Name = "txtUrlImagen";
            txtUrlImagen.ReadOnly = true;
            txtUrlImagen.Size = new Size(280, 27);
            txtUrlImagen.TabIndex = 37;
            // 
            // lblUrlImagen
            // 
            lblUrlImagen.AutoSize = true;
            lblUrlImagen.Font = new Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            lblUrlImagen.Location = new Point(410, 29);
            lblUrlImagen.Name = "lblUrlImagen";
            lblUrlImagen.Size = new Size(85, 20);
            lblUrlImagen.TabIndex = 36;
            lblUrlImagen.Text = "Url Imagen";
            // 
            // txtPropietario
            // 
            txtPropietario.Location = new Point(137, 316);
            txtPropietario.Name = "txtPropietario";
            txtPropietario.ReadOnly = true;
            txtPropietario.Size = new Size(250, 27);
            txtPropietario.TabIndex = 35;
            // 
            // lblPropietario
            // 
            lblPropietario.AutoSize = true;
            lblPropietario.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblPropietario.Location = new Point(29, 319);
            lblPropietario.Name = "lblPropietario";
            lblPropietario.Size = new Size(94, 23);
            lblPropietario.TabIndex = 34;
            lblPropietario.Text = "Propietario";
            // 
            // lblDisponible
            // 
            lblDisponible.AutoSize = true;
            lblDisponible.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblDisponible.Location = new Point(29, 279);
            lblDisponible.Name = "lblDisponible";
            lblDisponible.Size = new Size(90, 23);
            lblDisponible.TabIndex = 32;
            lblDisponible.Text = "Disponible";
            // 
            // txtPrecio
            // 
            txtPrecio.Location = new Point(137, 236);
            txtPrecio.Name = "txtPrecio";
            txtPrecio.ReadOnly = true;
            txtPrecio.Size = new Size(250, 27);
            txtPrecio.TabIndex = 31;
            // 
            // lblPrecio
            // 
            lblPrecio.AutoSize = true;
            lblPrecio.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblPrecio.Location = new Point(29, 239);
            lblPrecio.Name = "lblPrecio";
            lblPrecio.Size = new Size(57, 23);
            lblPrecio.TabIndex = 30;
            lblPrecio.Text = "Precio";
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(137, 146);
            txtDescripcion.Multiline = true;
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.ReadOnly = true;
            txtDescripcion.Size = new Size(250, 80);
            txtDescripcion.TabIndex = 29;
            // 
            // lblDescripcion
            // 
            lblDescripcion.AutoSize = true;
            lblDescripcion.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblDescripcion.Location = new Point(29, 149);
            lblDescripcion.Name = "lblDescripcion";
            lblDescripcion.Size = new Size(98, 23);
            lblDescripcion.TabIndex = 28;
            lblDescripcion.Text = "Descripción";
            // 
            // txtProvincia
            // 
            txtProvincia.Location = new Point(137, 106);
            txtProvincia.Name = "txtProvincia";
            txtProvincia.ReadOnly = true;
            txtProvincia.Size = new Size(250, 27);
            txtProvincia.TabIndex = 27;
            // 
            // lblProvincia
            // 
            lblProvincia.AutoSize = true;
            lblProvincia.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblProvincia.Location = new Point(29, 109);
            lblProvincia.Name = "lblProvincia";
            lblProvincia.Size = new Size(80, 23);
            lblProvincia.TabIndex = 26;
            lblProvincia.Text = "Provincia";
            // 
            // txtCiudad
            // 
            txtCiudad.Location = new Point(137, 66);
            txtCiudad.Name = "txtCiudad";
            txtCiudad.ReadOnly = true;
            txtCiudad.Size = new Size(250, 27);
            txtCiudad.TabIndex = 25;
            // 
            // lblCiudad
            // 
            lblCiudad.AutoSize = true;
            lblCiudad.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblCiudad.Location = new Point(29, 69);
            lblCiudad.Name = "lblCiudad";
            lblCiudad.Size = new Size(64, 23);
            lblCiudad.TabIndex = 24;
            lblCiudad.Text = "Ciudad";
            // 
            // txtDireccion
            // 
            txtDireccion.Location = new Point(137, 26);
            txtDireccion.Name = "txtDireccion";
            txtDireccion.ReadOnly = true;
            txtDireccion.Size = new Size(250, 27);
            txtDireccion.TabIndex = 23;
            // 
            // lblDireccion
            // 
            lblDireccion.AutoSize = true;
            lblDireccion.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold);
            lblDireccion.Location = new Point(29, 29);
            lblDireccion.Name = "lblDireccion";
            lblDireccion.Size = new Size(47, 23);
            lblDireccion.TabIndex = 22;
            lblDireccion.Text = "Calle";
            // 
            // checkBoxDisponible
            // 
            checkBoxDisponible.AutoSize = true;
            checkBoxDisponible.Location = new Point(137, 278);
            checkBoxDisponible.Name = "checkBoxDisponible";
            checkBoxDisponible.Size = new Size(18, 17);
            checkBoxDisponible.TabIndex = 39;
            checkBoxDisponible.UseVisualStyleBackColor = true;
            // 
            // VerPisoPropietario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(checkBoxDisponible);
            Controls.Add(pictureBoxImagen);
            Controls.Add(txtUrlImagen);
            Controls.Add(lblUrlImagen);
            Controls.Add(txtPropietario);
            Controls.Add(lblPropietario);
            Controls.Add(lblDisponible);
            Controls.Add(txtPrecio);
            Controls.Add(lblPrecio);
            Controls.Add(txtDescripcion);
            Controls.Add(lblDescripcion);
            Controls.Add(txtProvincia);
            Controls.Add(lblProvincia);
            Controls.Add(txtCiudad);
            Controls.Add(lblCiudad);
            Controls.Add(txtDireccion);
            Controls.Add(lblDireccion);
            Name = "VerPisoPropietario";
            Text = "VerPisoPropietario";
            Load += VerPisoPropietario_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBoxImagen).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private PictureBox pictureBoxImagen;
        private TextBox txtUrlImagen;
        private Label lblUrlImagen;
        private TextBox txtPropietario;
        private Label lblPropietario;
        private Label lblDisponible;
        private TextBox txtPrecio;
        private Label lblPrecio;
        private TextBox txtDescripcion;
        private Label lblDescripcion;
        private TextBox txtProvincia;
        private Label lblProvincia;
        private TextBox txtCiudad;
        private Label lblCiudad;
        private TextBox txtDireccion;
        private Label lblDireccion;
        private CheckBox checkBoxDisponible;
    }
}