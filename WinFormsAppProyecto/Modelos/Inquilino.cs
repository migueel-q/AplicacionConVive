using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Inquilino : Usuario
    {
        private DateOnly fecha_alta {  get; set; }
        private int pisoId { get; set; }
        private List<Tarea> tareas { get; set; }
        private List<Oferta> ofertas { get; set; }
        private List<Solicitud> solicitudes { get; set; }
        private List<Gasto> gastos { get; set; }
        private List<Propietario> propietarios { get; set; }
        private int contratoId { get; set; }

    }
}
