using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Propietario : Usuario
    {
        public List<Piso> pisos {  get; set; }
        public List<Inquilino> inquilinoes { get; set; }
        public List<Oferta> ofertas { get; set; }
        public List<Contrato> contratoes { get; set; }

    }
}
