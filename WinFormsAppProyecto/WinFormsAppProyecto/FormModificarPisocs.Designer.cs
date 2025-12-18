namespace Formularios
{
    partial class FormModificarPisocs
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
            btnModificarPiso = new Button();
            txtPropietarioMod = new TextBox();
            txtImagenMod = new TextBox();
            txtDescripcionMod = new TextBox();
            txtDireccionMod = new TextBox();
            label5 = new Label();
            label4 = new Label();
            label2 = new Label();
            label1 = new Label();
            checkBoxDisponible = new CheckBox();
            SuspendLayout();
            // 
            // btnModificarPiso
            // 
            btnModificarPiso.Location = new Point(290, 252);
            btnModificarPiso.Name = "btnModificarPiso";
            btnModificarPiso.Size = new Size(101, 29);
            btnModificarPiso.TabIndex = 18;
            btnModificarPiso.Text = "Modificar";
            btnModificarPiso.UseVisualStyleBackColor = true;
            // 
            // txtPropietarioMod
            // 
            txtPropietarioMod.Location = new Point(454, 122);
            txtPropietarioMod.Name = "txtPropietarioMod";
            txtPropietarioMod.Size = new Size(161, 27);
            txtPropietarioMod.TabIndex = 17;
            // 
            // txtImagenMod
            // 
            txtImagenMod.Location = new Point(454, 55);
            txtImagenMod.Name = "txtImagenMod";
            txtImagenMod.Size = new Size(161, 27);
            txtImagenMod.TabIndex = 16;
            // 
            // txtDescripcionMod
            // 
            txtDescripcionMod.Location = new Point(143, 122);
            txtDescripcionMod.Name = "txtDescripcionMod";
            txtDescripcionMod.Size = new Size(180, 27);
            txtDescripcionMod.TabIndex = 15;
            // 
            // txtDireccionMod
            // 
            txtDireccionMod.Location = new Point(143, 52);
            txtDireccionMod.Name = "txtDireccionMod";
            txtDireccionMod.Size = new Size(180, 27);
            txtDireccionMod.TabIndex = 14;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(365, 129);
            label5.Name = "label5";
            label5.Size = new Size(83, 20);
            label5.TabIndex = 13;
            label5.Text = "Propietario";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(365, 55);
            label4.Name = "label4";
            label4.Size = new Size(59, 20);
            label4.TabIndex = 12;
            label4.Text = "Imagen";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(50, 129);
            label2.Name = "label2";
            label2.Size = new Size(87, 20);
            label2.TabIndex = 11;
            label2.Text = "Descripción";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(50, 55);
            label1.Name = "label1";
            label1.Size = new Size(72, 20);
            label1.TabIndex = 10;
            label1.Text = "Dirección";
            // 
            // checkBoxDisponible
            // 
            checkBoxDisponible.AutoSize = true;
            checkBoxDisponible.Location = new Point(50, 197);
            checkBoxDisponible.Name = "checkBoxDisponible";
            checkBoxDisponible.Size = new Size(103, 24);
            checkBoxDisponible.TabIndex = 19;
            checkBoxDisponible.Text = "Disponible";
            checkBoxDisponible.UseVisualStyleBackColor = true;
            // 
            // FormModificarPisocs
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(678, 362);
            Controls.Add(checkBoxDisponible);
            Controls.Add(btnModificarPiso);
            Controls.Add(txtPropietarioMod);
            Controls.Add(txtImagenMod);
            Controls.Add(txtDescripcionMod);
            Controls.Add(txtDireccionMod);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FormModificarPisocs";
            Text = "FormModificarPisocs";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnModificarPiso;
        private TextBox txtPropietarioMod;
        private TextBox txtImagenMod;
        private TextBox txtDescripcionMod;
        private TextBox txtDireccionMod;
        private Label label5;
        private Label label4;
        private Label label2;
        private Label label1;
        private CheckBox checkBoxDisponible;
    }
}