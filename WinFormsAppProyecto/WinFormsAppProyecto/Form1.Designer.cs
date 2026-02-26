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
            gestionGastos = new ToolStripMenuItem();
            verGastodToolStripMenuItem = new ToolStripMenuItem();
            chatToolStripMenuItem = new ToolStripMenuItem();
            hablarPorChatToolStripMenuItem = new ToolStripMenuItem();
            gestiónOfertasToolStripMenuItem = new ToolStripMenuItem();
            hacerOferta = new ToolStripMenuItem();
            gestionarOfertas = new ToolStripMenuItem();
            gestiónSolicitudesToolStripMenuItem = new ToolStripMenuItem();
            hacerSolicitud = new ToolStripMenuItem();
            gestionarSolicitudes = new ToolStripMenuItem();
            gestionContrato = new ToolStripMenuItem();
            gestionarContratosToolStripMenuItem = new ToolStripMenuItem();
            cerrarSesiónToolStripMenuItem = new ToolStripMenuItem();
            button1 = new Button();
            verMiPisoToolStripMenuItem = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.BackColor = Color.White;
            menuStrip1.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            menuStrip1.ImageScalingSize = new Size(20, 20);
            menuStrip1.Items.AddRange(new ToolStripItem[] { gestiónPisosToolStripMenuItem, gestionGastos, chatToolStripMenuItem, gestiónOfertasToolStripMenuItem, gestiónSolicitudesToolStripMenuItem, gestionContrato, cerrarSesiónToolStripMenuItem });
            menuStrip1.LayoutStyle = ToolStripLayoutStyle.HorizontalStackWithOverflow;
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Padding = new Padding(7, 3, 0, 3);
            menuStrip1.Size = new Size(1085, 33);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // gestiónPisosToolStripMenuItem
            // 
            gestiónPisosToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { añadirPiso, modificarPiso, verPisosToolStripMenuItem, verMiPisoToolStripMenuItem });
            gestiónPisosToolStripMenuItem.Name = "gestiónPisosToolStripMenuItem";
            gestiónPisosToolStripMenuItem.Size = new Size(125, 27);
            gestiónPisosToolStripMenuItem.Text = "Gestión pisos";
            // 
            // añadirPiso
            // 
            añadirPiso.Name = "añadirPiso";
            añadirPiso.Size = new Size(224, 28);
            añadirPiso.Text = "Añadir piso";
            añadirPiso.Click += añadirPiso_click;
            // 
            // modificarPiso
            // 
            modificarPiso.Name = "modificarPiso";
            modificarPiso.Size = new Size(224, 28);
            modificarPiso.Text = "Modificar piso";
            modificarPiso.Click += modificarPiso_Click;
            // 
            // verPisosToolStripMenuItem
            // 
            verPisosToolStripMenuItem.Name = "verPisosToolStripMenuItem";
            verPisosToolStripMenuItem.Size = new Size(224, 28);
            verPisosToolStripMenuItem.Text = "Ver pisos";
            verPisosToolStripMenuItem.Click += verPisosToolStripMenuItem_Click;
            // 
            // gestionGastos
            // 
            gestionGastos.DropDownItems.AddRange(new ToolStripItem[] { verGastodToolStripMenuItem });
            gestionGastos.Name = "gestionGastos";
            gestionGastos.Size = new Size(138, 27);
            gestionGastos.Text = "Gestión Gastos";
            // 
            // verGastodToolStripMenuItem
            // 
            verGastodToolStripMenuItem.Name = "verGastodToolStripMenuItem";
            verGastodToolStripMenuItem.Size = new Size(173, 28);
            verGastodToolStripMenuItem.Text = "Ver gastos";
            verGastodToolStripMenuItem.Click += verGastodToolStripMenuItem_Click;
            // 
            // chatToolStripMenuItem
            // 
            chatToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { hablarPorChatToolStripMenuItem });
            chatToolStripMenuItem.Name = "chatToolStripMenuItem";
            chatToolStripMenuItem.Size = new Size(60, 27);
            chatToolStripMenuItem.Text = "Chat";
            // 
            // hablarPorChatToolStripMenuItem
            // 
            hablarPorChatToolStripMenuItem.Name = "hablarPorChatToolStripMenuItem";
            hablarPorChatToolStripMenuItem.Size = new Size(214, 28);
            hablarPorChatToolStripMenuItem.Text = "Hablar por chat";
            hablarPorChatToolStripMenuItem.Click += hablarPorChatToolStripMenuItem_Click;
            // 
            // gestiónOfertasToolStripMenuItem
            // 
            gestiónOfertasToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { hacerOferta, gestionarOfertas });
            gestiónOfertasToolStripMenuItem.Name = "gestiónOfertasToolStripMenuItem";
            gestiónOfertasToolStripMenuItem.Size = new Size(143, 27);
            gestiónOfertasToolStripMenuItem.Text = "Gestión Ofertas";
            // 
            // hacerOferta
            // 
            hacerOferta.Name = "hacerOferta";
            hacerOferta.Size = new Size(228, 28);
            hacerOferta.Text = "Hacer Oferta";
            // 
            // gestionarOfertas
            // 
            gestionarOfertas.Name = "gestionarOfertas";
            gestionarOfertas.Size = new Size(228, 28);
            gestionarOfertas.Text = "Gestionar Ofertas";
            // 
            // gestiónSolicitudesToolStripMenuItem
            // 
            gestiónSolicitudesToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { hacerSolicitud, gestionarSolicitudes });
            gestiónSolicitudesToolStripMenuItem.Name = "gestiónSolicitudesToolStripMenuItem";
            gestiónSolicitudesToolStripMenuItem.Size = new Size(168, 27);
            gestiónSolicitudesToolStripMenuItem.Text = "Gestión Solicitudes";
            // 
            // hacerSolicitud
            // 
            hacerSolicitud.Name = "hacerSolicitud";
            hacerSolicitud.Size = new Size(253, 28);
            hacerSolicitud.Text = "Hacer solicitud";
            // 
            // gestionarSolicitudes
            // 
            gestionarSolicitudes.Name = "gestionarSolicitudes";
            gestionarSolicitudes.Size = new Size(253, 28);
            gestionarSolicitudes.Text = "Gestionar Solicitudes";
            // 
            // gestionContrato
            // 
            gestionContrato.DropDownItems.AddRange(new ToolStripItem[] { gestionarContratosToolStripMenuItem });
            gestionContrato.Name = "gestionContrato";
            gestionContrato.Size = new Size(155, 27);
            gestionContrato.Text = "Gestion Contrato";
            // 
            // gestionarContratosToolStripMenuItem
            // 
            gestionarContratosToolStripMenuItem.Name = "gestionarContratosToolStripMenuItem";
            gestionarContratosToolStripMenuItem.Size = new Size(244, 28);
            gestionarContratosToolStripMenuItem.Text = "Gestionar contratos";
            gestionarContratosToolStripMenuItem.Click += gestionarContratosToolStripMenuItem_Click;
            // 
            // cerrarSesiónToolStripMenuItem
            // 
            cerrarSesiónToolStripMenuItem.Name = "cerrarSesiónToolStripMenuItem";
            cerrarSesiónToolStripMenuItem.Size = new Size(125, 27);
            cerrarSesiónToolStripMenuItem.Text = "Cerrar Sesión";
            cerrarSesiónToolStripMenuItem.Click += cerrarSesiónToolStripMenuItem_Click;
            // 
            // button1
            // 
            button1.BackColor = Color.DarkRed;
            button1.Cursor = Cursors.Hand;
            button1.FlatAppearance.BorderColor = Color.Black;
            button1.FlatAppearance.MouseOverBackColor = Color.Red;
            button1.FlatStyle = FlatStyle.Flat;
            button1.Font = new Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, 0);
            button1.ForeColor = Color.White;
            button1.Location = new Point(433, 585);
            button1.Name = "button1";
            button1.Size = new Size(187, 40);
            button1.TabIndex = 1;
            button1.Text = "Validar Pisos";
            button1.UseVisualStyleBackColor = false;
            button1.Click += button1_Click;
            // 
            // verMiPisoToolStripMenuItem
            // 
            verMiPisoToolStripMenuItem.Name = "verMiPisoToolStripMenuItem";
            verMiPisoToolStripMenuItem.Size = new Size(224, 28);
            verMiPisoToolStripMenuItem.Text = "Ver mi piso";
            verMiPisoToolStripMenuItem.Click += verMiPisoToolStripMenuItem_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(1085, 637);
            Controls.Add(button1);
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
        private ToolStripMenuItem gestionGastos;
        private ToolStripMenuItem verGastodToolStripMenuItem;
        private ToolStripMenuItem chatToolStripMenuItem;
        private ToolStripMenuItem hablarPorChatToolStripMenuItem;
        private ToolStripMenuItem cerrarSesiónToolStripMenuItem;
        private Button button1;
        private ToolStripMenuItem gestiónOfertasToolStripMenuItem;
        private ToolStripMenuItem hacerOferta;
        private ToolStripMenuItem gestionarOfertas;
        private ToolStripMenuItem gestiónSolicitudesToolStripMenuItem;
        private ToolStripMenuItem hacerSolicitud;
        private ToolStripMenuItem gestionarSolicitudes;
        private ToolStripMenuItem gestionContrato;
        private ToolStripMenuItem gestionarContratosToolStripMenuItem;
        private ToolStripMenuItem verMiPisoToolStripMenuItem;
    }
}
