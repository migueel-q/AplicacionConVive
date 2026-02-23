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
        public DateOnly fechaInicio { get; set; }
        public DateOnly fechaFin {  get; set; }
        public List<Inquilino> inquilinos { get; set; }
        public Propietario propietario { get; set; }
        public Piso piso { get; set; }
    }
}
