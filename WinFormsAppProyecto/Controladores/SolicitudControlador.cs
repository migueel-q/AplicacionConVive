using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class SolicitudControlador : IControlador<Solicitud>
    {
        private HttpClient cliente;

        public SolicitudControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Solicitud> add(Solicitud solicitudNueva)
        {
            Solicitud solicitud = new Solicitud();
            string json = JsonConvert.SerializeObject(solicitudNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            System.Diagnostics.Debug.WriteLine(json);
            HttpResponseMessage mensaje = await cliente.PostAsync("http://10.182.169.200:8080/api/solicitudes", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }

        public async Task<List<Solicitud>> getAll()
        {
            try
            {
                List<Solicitud> listaSolicitudes = new List<Solicitud>();
                HttpResponseMessage mensaje = await cliente.GetAsync("http://10.182.169.200:8080/api/solicitudes");

                mensaje.EnsureSuccessStatusCode();
                string mensajeJson = await mensaje.Content.ReadAsStringAsync();

                listaSolicitudes = JsonConvert.DeserializeObject<List<Solicitud>>(mensajeJson);

                return listaSolicitudes;
            }
            catch (Exception ex)
            {
                return new List<Solicitud>();
            }
        }

        public async Task<Solicitud> getById(int id)
        {
            Solicitud solicitud = new Solicitud();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://10.182.169.200/api/solicitudes/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://10.182.169.200:8080/api/solicitudes/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Solicitud> update(Solicitud solicitudModifcada, int id)
        {
            Solicitud solicitud = new Solicitud();
            string json = JsonConvert.SerializeObject(solicitudModifcada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://10.182.169.200/api/solicitudes/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }
    }
}

