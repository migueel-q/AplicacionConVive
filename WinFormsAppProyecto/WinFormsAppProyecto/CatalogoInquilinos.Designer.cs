namespace Formularios
{
    partial class CatalogoInquilinos
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
            listBoxInquilinos = new ListBox();
            btnInquilinos = new Button();
            SuspendLayout();
            // 
            // listBoxInquilinos
            // 
            listBoxInquilinos.DisplayMember = "nombre_real";
            listBoxInquilinos.FormattingEnabled = true;
            listBoxInquilinos.Location = new Point(12, 36);
            listBoxInquilinos.Name = "listBoxInquilinos";
            listBoxInquilinos.Size = new Size(776, 304);
            listBoxInquilinos.TabIndex = 0;
            // 
            // btnInquilinos
            // 
            btnInquilinos.BackColor = Color.DarkRed;
            btnInquilinos.Cursor = Cursors.Hand;
            btnInquilinos.FlatAppearance.BorderColor = Color.Black;
            btnInquilinos.FlatAppearance.MouseOverBackColor = Color.Red;
            btnInquilinos.FlatStyle = FlatStyle.Flat;
            btnInquilinos.Font = new Font("Segoe UI Semibold", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnInquilinos.ForeColor = Color.White;
            btnInquilinos.Location = new Point(330, 371);
            btnInquilinos.Name = "btnInquilinos";
            btnInquilinos.Size = new Size(127, 47);
            btnInquilinos.TabIndex = 1;
            btnInquilinos.Text = "Hablar";
            btnInquilinos.UseVisualStyleBackColor = false;
            btnInquilinos.Click += btnInquilinos_Click;
            // 
            // CatalogoInquilinos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(813, 439);
            Controls.Add(btnInquilinos);
            Controls.Add(listBoxInquilinos);
            Name = "CatalogoInquilinos";
            Text = "CatalogoInquilinos";
            Load += CatalogoInquilinos_Load;
            ResumeLayout(false);
        }

        #endregion

        private ListBox listBoxInquilinos;
        private Button btnInquilinos;
    }
}