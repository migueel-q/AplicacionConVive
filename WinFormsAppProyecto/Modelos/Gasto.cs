using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Gasto
    {
        private int id {  get; set; }
        private string concepto { get; set; }
        private double valor { get; set; }
        private string inquilinoNombre { get; set; }
        private int pisoId { get; set; }
    }
}
