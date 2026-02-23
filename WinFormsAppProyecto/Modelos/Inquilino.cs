using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Inquilino : Usuario
    {
        public string fecha_alta {  get; set; }
        public Piso piso { get; set; }
        public Contrato contrato { get; set; }

    }
}
