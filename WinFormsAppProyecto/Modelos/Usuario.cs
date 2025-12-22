using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelos
{
    public abstract class Usuario
    {
        protected int id {  get; set; }
        protected string nombre_usuario { get; set; }
        protected string nombre_real { get; set; }
        protected DateOnly fecha_nacimiento { get; set; }
        protected string email { get; set; }
        protected string password { get; set; }

    }
}
