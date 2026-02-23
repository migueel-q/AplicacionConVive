using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public abstract class Usuario
    {
        public int id {  get; set; }
        public string nombre_usuario { get; set; }
        public string nombre_real { get; set; }
        public string fecha_nacimiento { get; set; }
        public string email { get; set; }
        public string password { get; set; }

    }
}
