using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public class Piso
    {
        public int id {  get; set; }
        public string direccion {  get; set; }
        public string descripcion { get; set; }
        public string imagenUrl { get; set; }
        public bool disponible { get; set; }
        public List<Inquilino> inquilinos { get; set; }
        public Propietario propietarioId { get; set; }
        public List<Oferta> ofertas { get; set; }
        public List<Gasto> gastos { get; set; }
        public List<Contrato> contratos { get; set; }
    }
}
