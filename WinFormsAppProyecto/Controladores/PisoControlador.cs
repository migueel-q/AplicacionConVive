using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class PisoControlador : IControlador<Piso>
    {
        private HttpClient cliente;

        public PisoControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Piso> add(Piso tareaNueva)
        {
            Piso piso = new Piso();
            string json = JsonConvert.SerializeObject(tareaNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/pisos", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            piso = JsonConvert.DeserializeObject<Piso>(mensajeJson);
            return piso;
        }

        public async Task<List<Piso>> getAll()
        {
            try
            {
                List<Piso> listaPisos = new List<Piso>();
                HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/pisos");

                mensaje.EnsureSuccessStatusCode();
                string mensajeJson = await mensaje.Content.ReadAsStringAsync();

                listaPisos = JsonConvert.DeserializeObject<List<Piso>>(mensajeJson);

                return listaPisos;
            }
            catch (Exception ex)
            {
                return new List<Piso>();
            }
        }

        public async Task<Piso> getById(int id)
        {
            Piso piso = new Piso();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/pisos/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            piso = JsonConvert.DeserializeObject<Piso>(mensajeJson);
            return piso;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/pisos/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Piso> update(Piso tareaModificada, int id)
        {
            Piso piso = new Piso();
            string json = JsonConvert.SerializeObject(tareaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/pisos/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            piso = JsonConvert.DeserializeObject<Piso>(mensajeJson);
            return piso;
        }
    }
}
