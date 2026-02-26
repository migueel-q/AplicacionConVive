using Controladores;
using Formularios;
using Modelos;
using System.Windows.Forms;

namespace WinFormsAppProyecto
{
    public partial class Form1 : Form
    {
        Propietario propietario;
        Inquilino inquilino;
        Administrador administrador;
        PisoControlador pisoControlador;
        TareaControlador tareaControlador;
        public Form1(Inquilino inquilino)
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.inquilino = inquilino;
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);

            pisoControlador = new PisoControlador();
            tareaControlador = new TareaControlador();
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Load += Form1_Load;

            añadirPiso.Visible = false;
            modificarPiso.Visible = false;
            añadirPiso.Visible = false;
            gestionarOfertas.Visible = false;
            gestionarSolicitudes.Visible = false;
            gestionContrato.Visible = false;
            button1.Visible = false;
        }

        

        private async void Form1_Load(object? sender, EventArgs e)
        {
            await CargarPisosAsync();
        }

        private async Task CargarPisosAsync()
        {
            try
            {
                var pisos = await pisoControlador.getAll();
                var pisosView = pisos.Select(p => new
                {
                    Id = p.id,
                    Direccion = p.direccion != null ? $"{p.direccion.calle}, {p.direccion.ciudad}, {p.direccion.provincia}" : "",
                    p.descripcion,
                    Precio = p.precio,
                    Disponible = p.disponible
                }).ToList();

                dataGridView1.DataSource = pisosView;
                dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                dataGridView1.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
                dataGridView1.MultiSelect = false;

                // If the inquilino has a piso via contrato, select it
                if (inquilino?.contrato?.piso != null)
                {
                    int miPisoId = inquilino.contrato.piso.id;
                    foreach (DataGridViewRow row in dataGridView1.Rows)
                    {
                        if (row.Cells["Id"].Value is int val && val == miPisoId)
                        {
                            row.Selected = true;
                            // Scroll into view
                            dataGridView1.FirstDisplayedScrollingRowIndex = row.Index;
                            break;
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error cargando pisos: " + ex.Message);
            }
        }

        public Form1(Propietario propietario)
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.propietario = propietario;
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);
            gestionGastos.Visible = false;
            hacerOferta.Visible = false;
            hacerSolicitud.Visible = false;
            button1.Visible = false;
        }

        public Form1(Administrador administrador)
        {
            InitializeComponent();
            this.IsMdiContainer = true;
            this.propietario = propietario;
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);
            gestionGastos.Visible = false;
            hacerOferta.Visible = false;
            hacerSolicitud.Visible = false;
            añadirPiso.Visible = false;
            modificarPiso.Visible = false;
            añadirPiso.Visible = false;
            gestionarOfertas.Visible = false;
            gestionarSolicitudes.Visible = false;
            gestionContrato.Visible = false;
            chatToolStripMenuItem.Visible = false;
            gestiónPisosToolStripMenuItem.Visible = false;
            gestiónOfertasToolStripMenuItem.Visible = false;
            gestiónSolicitudesToolStripMenuItem.Visible = false;
        }
        private void AbrirFormulario(Form formulario)
        {
            // Cerrar cualquier formulario MDI hijo que esté abierto
            foreach (Form frm in this.MdiChildren)
                frm.Close();

            // Abrir el nuevo
            formulario.MdiParent = this;

            formulario.StartPosition = FormStartPosition.Manual;
            formulario.Location = new Point(0, 0); // o la posición que quieras

            formulario.Show();
        }



        private void añadirPiso_click(object sender, EventArgs e)
        {
            FormAñadirPiso formAñadirPiso = new FormAñadirPiso(propietario);
            AbrirFormulario(formAñadirPiso);
        }

        private void modificarPiso_Click(object sender, EventArgs e)
        {
            CatalogoPisos catalogo = Application.OpenForms.OfType<CatalogoPisos>().FirstOrDefault();

            if (catalogo == null)
            {
                MessageBox.Show("Primero abre el catálogo de pisos."); return;
            }
            else
            {
                Piso piso = catalogo.pisoSeleccionado;
                if (piso == null)
                {
                    MessageBox.Show("Selecciona primero un piso");
                }
                else
                {
                    FormModificarPiso formMod = new FormModificarPiso(piso, propietario);
                    AbrirFormulario(formMod);
                }
            }

        }

        private void verPisosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CatalogoPisos catalogoPisos = new CatalogoPisos();
            AbrirFormulario(catalogoPisos);
        }

        private void verGastodToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CatalogoPisos catalogo = Application.OpenForms.OfType<CatalogoPisos>().FirstOrDefault();

            if (catalogo == null)
            {
                MessageBox.Show("Primero abre el catálogo de pisos."); return;
            }
            else
            {

                // Obtener el ID del piso seleccionado
                Piso piso = catalogo.pisoSeleccionado;

                if (piso == null)
                {
                    MessageBox.Show("Selecciona un piso primero.");
                    return;
                }
                else
                {

                    // Abrir el informe con el ID
                    VerInforme informe = new VerInforme(piso.id);
                    AbrirFormulario(informe);
                }
            }
        }

        private async void hablarPorChatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // 1. Buscar si el catálogo está abierto
            CatalogoPisos catalogo = Application.OpenForms.OfType<CatalogoPisos>().FirstOrDefault();

            if (catalogo == null)
            {
                MessageBox.Show("Primero abre el catálogo de pisos."); return;
            }
            else
            {

                // 2. Obtener el piso seleccionado
                Piso pisoSeleccion = catalogo.pisoSeleccionado;

                if (pisoSeleccion == null)
                {
                    MessageBox.Show("Selecciona un piso primero.");

                }
                else
                {

                    // 3. Obtener el piso desde el backend
                    PisoControlador pisoControlador = new PisoControlador();
                    Piso piso = await pisoControlador.getById(pisoSeleccion.id);

                    // 4. Si eres INQUILINO ? hablas con el propietario del piso
                    if (inquilino != null)
                    {
                        int propietarioId = piso.propietario.id;
                        FormChatInquilino chat = new FormChatInquilino(inquilino.id, propietarioId);
                        AbrirFormulario(chat);

                    }
                    else
                    {

                        // 5. Si eres PROPIETARIO ? NO puedes obtener el inquilino desde el piso
                        //    porque ya no existe piso.contrato
                        //    Así que abrimos la lista de inquilinos
                        if (propietario != null)
                        {
                            CatalogoInquilinos catalogoInquilinos = new CatalogoInquilinos(propietario);
                            AbrirFormulario(catalogoInquilinos);
                        }
                    }
                }
            }
        }

        private void cerrarSesiónToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            FormLogs formLogs = new FormLogs();
            formLogs.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
            ValidarPisos validarPisos = new ValidarPisos();
            validarPisos.ShowDialog();
            this.Show();
        }

        private void gestionarContratosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            GestionarContratos gestionarContratos = new GestionarContratos();
            AbrirFormulario(gestionarContratos);
        }

        
    }
}
