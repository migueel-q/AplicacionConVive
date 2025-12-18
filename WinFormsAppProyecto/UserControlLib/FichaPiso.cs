namespace UserControlLib
{
    public partial class FichaPiso : UserControl
    {
        public const int ALTURA = 120;   // 👈 VALOR REAL
        public int DataIndex { get; private set; }

        public FichaPiso()
        {
            InitializeComponent();
            this.Height = ALTURA;
            this.Dock = DockStyle.None;
            this.Anchor = AnchorStyles.Top | AnchorStyles.Left | AnchorStyles.Right;
        }

        public void Bind(string nombre, int index)
        {
            DataIndex = index;
            calle_lbl.Text = nombre;
        }


        private void label1_Click(object sender, EventArgs e)
        {

        }
        private string calle;
        public string _calle
        {
            get { return calle; }
            set
            {
                calle = value;
                calle_lbl.Text = value;
            }
        }
        private string ciudad;
        public string _ciudad
        {
            get { return ciudad; }
            set
            {
                ciudad = value;
                ciudad_lbl.Text = value;
            }
        }
        private string provincia;
        public string _provincia
        {
            get { return provincia; }
            set
            {
                provincia = value;
                provincia_lbl.Text = value;
            }
        }
        private string descripcion;
        public string _descripcion
        {
            get { return descripcion; }
            set
            {
                descripcion = value;
                descripcion_lbl.Text = value;
            }
        }
    }
    }
