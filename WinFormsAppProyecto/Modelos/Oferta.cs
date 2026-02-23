using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Oferta
    {
        public int id {  get; set; }
        public double cantidad {  get; set; }
        public string descripcion { get; set; }
        public Piso piso { get; set; }
        public Piso inqulino { get; set; }
    }
}
