using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Mensaje
    {
        public Inquilino inquilino {  get; set; }
        public Propietario propietario { get; set; }
        public DateTime fechaMesg {  get; set; }
        public string mensaje {  get; set; }
        public bool enviadoPorInquilino { get; set; }
    }
}
