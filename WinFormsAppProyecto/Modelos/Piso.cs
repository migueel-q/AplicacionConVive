using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Piso
    {
        private int id {  get; set; }
        private string direccion {  get; set; }
        private string descripcion { get; set; }
        private string imagenUrl { get; set; }
        private bool disponible { get; set; }
        private List<Inquilino> inquilinos { get; set; }
        private int propietarioId { get; set; }
        private List<Oferta> ofertas { get; set; }
        private List<Gasto> gastos { get; set; }
        private List<Contrato> contratos { get; set; }
    }
}
