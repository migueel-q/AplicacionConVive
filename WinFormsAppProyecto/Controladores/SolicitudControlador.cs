using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    internal class SolicitudControlador
    {
        private HttpClient cliente;

        public SolicitudControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Solicitud> add(Solicitud tareaNueva)
        {
            Solicitud solicitud = new Solicitud();
            string json = JsonConvert.SerializeObject(tareaNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/solicitud", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }

        public async Task<List<Solicitud>> getAll()
        {
            List<Solicitud> listaSolicitud = new List<Solicitud>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/solicitud");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaSolicitud = JsonConvert.DeserializeObject<List<Solicitud>>(mensajeJson);

            return listaSolicitud;
        }

        public async Task<Solicitud> getById(int id)
        {
            Solicitud solicitud = new Solicitud();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/solicitud/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }

        public async Task<bool> remove(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/solicitud/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Solicitud> update(Solicitud tareaModificada, int id)
        {
            Solicitud solicitud = new Solicitud();
            string json = JsonConvert.SerializeObject(tareaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/solicitud/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            solicitud = JsonConvert.DeserializeObject<Solicitud>(mensajeJson);
            return solicitud;
        }
    }
}

