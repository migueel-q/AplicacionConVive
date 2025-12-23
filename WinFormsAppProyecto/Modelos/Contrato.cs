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
        private int id {  get; set; }
        private String descripcion {  get; set; }
        private Double precio { get; set; }
        private DateOnly fechaInicio { get; set; }
        private DateOnly fechaFin {  get; set; }
        private List<Inquilino> inquilinos { get; set; }
        private int propietarioId { get; set; } 
        private int pisoId { get; set; }
    }
}
