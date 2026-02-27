using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Modelos
{
    public class Solicitud
    {
        public int id { get; set; }
        public Inquilino inquilino { get; set; }
        public string nombreInquilino => inquilino.nombre_real;
        public Oferta oferta { get; set; }
        public string piso => oferta.piso.calle;
        public string provincia => oferta.piso.provincia;
        public bool aceptado { get; set; }
        
    }
}
