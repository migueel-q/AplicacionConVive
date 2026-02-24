namespace WinFormsAppProyecto
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            gestiónPisosToolStripMenuItem = new ToolStripMenuItem();
            añadirPiso = new ToolStripMenuItem();
            modificarPiso = new ToolStripMenuItem();
            verPisosToolStripMenuItem = new ToolStripMenuItem();
            gestiónGastosToolStripMenuItem = new ToolStripMenuItem();
            verGastodToolStripMenuItem = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.ImageScalingSize = new Size(20, 20);
            menuStrip1.Items.AddRange(new ToolStripItem[] { gestiónPisosToolStripMenuItem, gestiónGastosToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Padding = new Padding(7, 3, 0, 3);
            menuStrip1.Size = new Size(914, 30);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // gestiónPisosToolStripMenuItem
            // 
            gestiónPisosToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { añadirPiso, modificarPiso, verPisosToolStripMenuItem });
            gestiónPisosToolStripMenuItem.Name = "gestiónPisosToolStripMenuItem";
            gestiónPisosToolStripMenuItem.Size = new Size(111, 24);
            gestiónPisosToolStripMenuItem.Text = "Gestión pisos";
            // 
            // añadirPiso
            // 
            añadirPiso.Name = "añadirPiso";
            añadirPiso.Size = new Size(188, 26);
            añadirPiso.Text = "Añadir piso";
            añadirPiso.Click += añadirPiso_click;
            // 
            // modificarPiso
            // 
            modificarPiso.Name = "modificarPiso";
            modificarPiso.Size = new Size(188, 26);
            modificarPiso.Text = "Modificar piso";
            modificarPiso.Click += modificarPiso_Click;
            // 
            // verPisosToolStripMenuItem
            // 
            verPisosToolStripMenuItem.Name = "verPisosToolStripMenuItem";
            verPisosToolStripMenuItem.Size = new Size(188, 26);
            verPisosToolStripMenuItem.Text = "Ver pisos";
            verPisosToolStripMenuItem.Click += verPisosToolStripMenuItem_Click;
            // 
            // gestiónGastosToolStripMenuItem
            // 
            gestiónGastosToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { verGastodToolStripMenuItem });
            gestiónGastosToolStripMenuItem.Name = "gestiónGastosToolStripMenuItem";
            gestiónGastosToolStripMenuItem.Size = new Size(121, 24);
            gestiónGastosToolStripMenuItem.Text = "Gestión Gastos";
            // 
            // verGastodToolStripMenuItem
            // 
            verGastodToolStripMenuItem.Name = "verGastodToolStripMenuItem";
            verGastodToolStripMenuItem.Size = new Size(224, 26);
            verGastodToolStripMenuItem.Text = "Ver gastos";
            verGastodToolStripMenuItem.Click += verGastodToolStripMenuItem_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Margin = new Padding(3, 4, 3, 4);
            Name = "Form1";
            Text = "Form1";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem gestiónPisosToolStripMenuItem;
        private ToolStripMenuItem añadirPiso;
        private ToolStripMenuItem modificarPiso;
        private ToolStripMenuItem verPisosToolStripMenuItem;
        private ToolStripMenuItem gestiónGastosToolStripMenuItem;
        private ToolStripMenuItem verGastodToolStripMenuItem;
    }
}
