using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Piso
    {
        public int id { get; set; }
        public Direccion direccion { get; set; }
        public string descripcion { get; set; }
        public string url_imagen { get; set; }
        public bool disponible { get; set; }
        public Propietario propietario { get; set; }
    }
}
