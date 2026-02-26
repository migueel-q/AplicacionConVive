namespace Formularios
{
    partial class FormChatPropietario
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormChatPropietario));
            richTextBoxMensaje = new RichTextBox();
            btnEnviar = new Button();
            panelMnesajes = new FlowLayoutPanel();
            recargar = new System.Windows.Forms.Timer(components);
            btnRecargar = new Button();
            SuspendLayout();
            // 
            // richTextBoxMensaje
            // 
            richTextBoxMensaje.Location = new Point(12, 413);
            richTextBoxMensaje.Name = "richTextBoxMensaje";
            richTextBoxMensaje.Size = new Size(642, 63);
            richTextBoxMensaje.TabIndex = 4;
            richTextBoxMensaje.Text = "";
            // 
            // btnEnviar
            // 
            btnEnviar.BackColor = Color.DarkRed;
            btnEnviar.Cursor = Cursors.Hand;
            btnEnviar.FlatAppearance.BorderColor = Color.Black;
            btnEnviar.FlatAppearance.MouseOverBackColor = Color.Red;
            btnEnviar.FlatStyle = FlatStyle.Flat;
            btnEnviar.Font = new Font("Segoe UI Semibold", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            btnEnviar.ForeColor = Color.White;
            btnEnviar.Location = new Point(660, 413);
            btnEnviar.Name = "btnEnviar";
            btnEnviar.Size = new Size(128, 63);
            btnEnviar.TabIndex = 2;
            btnEnviar.Text = "Enviar";
            btnEnviar.UseVisualStyleBackColor = false;
            btnEnviar.Click += btnEnviar_Click;
            // 
            // panelMnesajes
            // 
            panelMnesajes.Location = new Point(12, 60);
            panelMnesajes.Name = "panelMnesajes";
            panelMnesajes.Size = new Size(776, 333);
            panelMnesajes.TabIndex = 3;
            // 
            // recargar
            // 
            recargar.Tick += recargar_Tick;
            // 
            // btnRecargar
            // 
            btnRecargar.Image = (Image)resources.GetObject("btnRecargar.Image");
            btnRecargar.Location = new Point(754, 17);
            btnRecargar.Name = "btnRecargar";
            btnRecargar.Size = new Size(34, 37);
            btnRecargar.TabIndex = 5;
            btnRecargar.UseVisualStyleBackColor = true;
            btnRecargar.Click += btnRecargar_Click;
            // 
            // FormChatPropietario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(805, 507);
            Controls.Add(btnRecargar);
            Controls.Add(richTextBoxMensaje);
            Controls.Add(btnEnviar);
            Controls.Add(panelMnesajes);
            Name = "FormChatPropietario";
            Text = "FormChatPropietario";
            Load += FormChatPropietario_Load;
            ResumeLayout(false);
        }

        #endregion

        private RichTextBox richTextBoxMensaje;
        private Button btnEnviar;
        private FlowLayoutPanel panelMnesajes;
        private System.Windows.Forms.Timer recargar;
        private Button btnRecargar;
    }
}