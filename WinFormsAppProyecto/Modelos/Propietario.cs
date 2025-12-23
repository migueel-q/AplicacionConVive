using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Propietario : Usuario
    {
        private List<Piso> pisos {  get; set; }
        private List<Inquilino> inquilinoes { get; set; }
        private List<Oferta> ofertas { get; set; }
        private List<Contrato> contratoes { get; set; }

    }
}
