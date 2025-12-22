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
        private int id { get; set; }
        private int inquilino { get; set; }
        private int oferta { get; set; }
        private bool aceptado { get; set; }
    }
}
