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
            label4 = new Label();
            label5 = new Label();
            txtDireccion = new TextBox();
            txtDescripcion = new TextBox();
            txtImagen = new TextBox();
            txtPropietario = new TextBox();
            btnGuardarPiso = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(59, 71);
            label1.Name = "label1";
            label1.Size = new Size(72, 20);
            label1.TabIndex = 0;
            label1.Text = "Dirección";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(59, 145);
            label2.Name = "label2";
            label2.Size = new Size(87, 20);
            label2.TabIndex = 1;
            label2.Text = "Descripción";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(374, 71);
            label4.Name = "label4";
            label4.Size = new Size(59, 20);
            label4.TabIndex = 3;
            label4.Text = "Imagen";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(374, 145);
            label5.Name = "label5";
            label5.Size = new Size(83, 20);
            label5.TabIndex = 4;
            label5.Text = "Propietario";
            // 
            // txtDireccion
            // 
            txtDireccion.Location = new Point(152, 68);
            txtDireccion.Name = "txtDireccion";
            txtDireccion.Size = new Size(180, 27);
            txtDireccion.TabIndex = 5;
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(152, 138);
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.Size = new Size(180, 27);
            txtDescripcion.TabIndex = 6;
            // 
            // txtImagen
            // 
            txtImagen.Location = new Point(463, 71);
            txtImagen.Name = "txtImagen";
            txtImagen.Size = new Size(161, 27);
            txtImagen.TabIndex = 7;
            // 
            // txtPropietario
            // 
            txtPropietario.Location = new Point(463, 138);
            txtPropietario.Name = "txtPropietario";
            txtPropietario.Size = new Size(161, 27);
            txtPropietario.TabIndex = 8;
            // 
            // btnGuardarPiso
            // 
            btnGuardarPiso.Location = new Point(298, 243);
            btnGuardarPiso.Name = "btnGuardarPiso";
            btnGuardarPiso.Size = new Size(94, 29);
            btnGuardarPiso.TabIndex = 9;
            btnGuardarPiso.Text = "Guardar";
            btnGuardarPiso.UseVisualStyleBackColor = true;
            // 
            // FormAñadirPiso
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(682, 413);
            Controls.Add(btnGuardarPiso);
            Controls.Add(txtPropietario);
            Controls.Add(txtImagen);
            Controls.Add(txtDescripcion);
            Controls.Add(txtDireccion);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FormAñadirPiso";
            Text = "Añadir Piso";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private TextBox txtDireccion;
        private TextBox txtDescripcion;
        private TextBox txtImagen;
        private TextBox txtPropietario;
        private Button btnGuardarPiso;
    }
}