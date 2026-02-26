namespace Formularios
{
    partial class FormChatInquilino
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
            panelMnesajes = new FlowLayoutPanel();
            btnEnviar = new Button();
            richTextBoxMensaje = new RichTextBox();
            SuspendLayout();
            // 
            // panelMnesajes
            // 
            panelMnesajes.Location = new Point(12, 22);
            panelMnesajes.Name = "panelMnesajes";
            panelMnesajes.Size = new Size(776, 333);
            panelMnesajes.TabIndex = 0;
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
            btnEnviar.Location = new Point(660, 375);
            btnEnviar.Name = "btnEnviar";
            btnEnviar.Size = new Size(128, 63);
            btnEnviar.TabIndex = 0;
            btnEnviar.Text = "Enviar";
            btnEnviar.UseVisualStyleBackColor = false;
            btnEnviar.Click += btnEnviar_Click;
            // 
            // richTextBoxMensaje
            // 
            richTextBoxMensaje.Location = new Point(12, 375);
            richTextBoxMensaje.Name = "richTextBoxMensaje";
            richTextBoxMensaje.Size = new Size(642, 63);
            richTextBoxMensaje.TabIndex = 1;
            richTextBoxMensaje.Text = "";
            // 
            // FormChatInquilino
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(800, 450);
            Controls.Add(richTextBoxMensaje);
            Controls.Add(btnEnviar);
            Controls.Add(panelMnesajes);
            Name = "FormChatInquilino";
            Text = "FormChatInquilino";
            Load += FormChatInquilino_Load;
            ResumeLayout(false);
        }

        #endregion

        private FlowLayoutPanel panelMnesajes;
        private Button btnEnviar;
        private RichTextBox richTextBoxMensaje;
    }
}