using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Inquilino : Usuario
    {
        public DateOnly fecha_alta {  get; set; }
        public int pisoId { get; set; }
        public List<Tarea> tareas { get; set; }
        public List<Oferta> ofertas { get; set; }
        public List<Solicitud> solicitudes { get; set; }
        public List<Gasto> gastos { get; set; }
        public List<Propietario> propietarios { get; set; }
        public int contratoId { get; set; }

    }
}
