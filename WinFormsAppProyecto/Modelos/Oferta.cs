using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Oferta
    {
        private int id {  get; set; }
        private Double cantidad {  get; set; }
        private string descripcion { get; set; }
        private int pisoId { get; set; }
        private int inqulinoId { get; set; }
        private List<Solicitud> solicitudes { get; set; }
    }
}
