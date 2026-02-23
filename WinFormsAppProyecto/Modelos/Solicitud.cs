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
        public Piso inquilino { get; set; }
        public Oferta oferta { get; set; }
        public bool aceptado { get; set; }
    }
}
