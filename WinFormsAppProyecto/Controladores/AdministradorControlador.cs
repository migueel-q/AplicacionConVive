using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class AdministradorControlador
    {
        private HttpClient cliente;

        public AdministradorControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<List<Administrador>> getAll()
        {
            try
            {
                List<Administrador> listaAdministradores = new List<Administrador>();
                HttpResponseMessage mensaje = await cliente.GetAsync("http://192.168.1.104:8080/api/administradores");

                mensaje.EnsureSuccessStatusCode();
                string mensajeJson = await mensaje.Content.ReadAsStringAsync();

                listaAdministradores = JsonConvert.DeserializeObject<List<Administrador>>(mensajeJson);

                return listaAdministradores;
            }
            catch (Exception ex)
            {
                return new List<Administrador>();
            }
        }
    }
}
