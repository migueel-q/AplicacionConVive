namespace Formularios
{
    partial class FormMenuInquilino
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
            dataGridView1 = new System.Windows.Forms.DataGridView();
            btnVerMiPiso = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)dataGridView1).BeginInit();
            SuspendLayout();
            // 
            // dataGridView1
            // 
            dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView1.Location = new System.Drawing.Point(12, 12);
            dataGridView1.Name = "dataGridView1";
            dataGridView1.RowHeadersWidth = 51;
            dataGridView1.Size = new System.Drawing.Size(760, 370);
            dataGridView1.TabIndex = 0;
            // 
            // btnVerMiPiso
            // 
            btnVerMiPiso.Location = new System.Drawing.Point(12, 398);
            btnVerMiPiso.Name = "btnVerMiPiso";
            btnVerMiPiso.Size = new System.Drawing.Size(120, 30);
            btnVerMiPiso.TabIndex = 1;
            btnVerMiPiso.Text = "Ver mi piso";
            btnVerMiPiso.UseVisualStyleBackColor = true;
            btnVerMiPiso.Click += btnVerMiPiso_Click;
            // 
            // FormMenuInquilino
            // 
            AutoScaleDimensions = new System.Drawing.SizeF(8F, 20F);
            AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            ClientSize = new System.Drawing.Size(784, 441);
            Controls.Add(btnVerMiPiso);
            Controls.Add(dataGridView1);
            Name = "FormMenuInquilino";
            Text = "Menu Inquilino";
            ((System.ComponentModel.ISupportInitialize)dataGridView1).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button btnVerMiPiso;
    }
}