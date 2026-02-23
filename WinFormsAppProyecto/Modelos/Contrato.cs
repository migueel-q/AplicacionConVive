using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Contrato
    {
        public int id {  get; set; }
        public string descripcion {  get; set; }
        public double precio { get; set; }
        public DateOnly fecha_inicio { get; set; }
        public DateOnly fecha_fin {  get; set; }
        public Piso piso { get; set; }
    }
}
