using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Gasto
    {
        public int id {  get; set; }
        public string concepto { get; set; }
        public double valor { get; set; }
        public Inquilino inquilino { get; set; }
        public Piso piso { get; set; }
    }
}
