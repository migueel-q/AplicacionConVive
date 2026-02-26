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
            richTextBoxMensaje = new RichTextBox();
            btnEnviar = new Button();
            panelMnesajes = new FlowLayoutPanel();
            SuspendLayout();
            // 
            // richTextBoxMensaje
            // 
            richTextBoxMensaje.Location = new Point(12, 370);
            richTextBoxMensaje.Name = "richTextBoxMensaje";
            richTextBoxMensaje.Size = new Size(642, 63);
            richTextBoxMensaje.TabIndex = 4;
            richTextBoxMensaje.Text = "";
            // 
            // btnEnviar
            // 
            btnEnviar.Location = new Point(674, 387);
            btnEnviar.Name = "btnEnviar";
            btnEnviar.Size = new Size(114, 29);
            btnEnviar.TabIndex = 2;
            btnEnviar.Text = "Enviar";
            btnEnviar.UseVisualStyleBackColor = true;
            btnEnviar.Click += btnEnviar_Click;
            // 
            // panelMnesajes
            // 
            panelMnesajes.Location = new Point(12, 17);
            panelMnesajes.Name = "panelMnesajes";
            panelMnesajes.Size = new Size(776, 333);
            panelMnesajes.TabIndex = 3;
            // 
            // FormChatPropietario
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
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
    }
}