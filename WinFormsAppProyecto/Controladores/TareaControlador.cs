using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelos;
using Newtonsoft.Json;

namespace Controladores
{
    public class TareaControlador : IControlador<Tarea>
    {
        private HttpClient cliente;

        public TareaControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Tarea> add(Tarea tareaNueva)
        {
            Tarea tarea = new Tarea();
            string json = JsonConvert.SerializeObject(tareaNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/tareas", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            tarea = JsonConvert.DeserializeObject<Tarea>(mensajeJson);
            return tarea;
        }

        public async Task<List<Tarea>> getAll()
        {
            try
            {
                List<Tarea> listaTarea = new List<Tarea>();
                HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/tareas");

                mensaje.EnsureSuccessStatusCode();
                string mensajeJson = await mensaje.Content.ReadAsStringAsync();

                listaTarea = JsonConvert.DeserializeObject<List<Tarea>>(mensajeJson);

                return listaTarea;
            }
            catch (Exception ex)
            {
                return new List<Tarea>();
            }
        }

        public async Task<Tarea> getById(int id)
        {
            Tarea tarea = new Tarea();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/tareas/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            tarea = JsonConvert.DeserializeObject<Tarea>(mensajeJson);
            return tarea;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/tareas/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Tarea> update(Tarea tareaModificada, int id)
        {
            Tarea tarea = new Tarea();
            string json = JsonConvert.SerializeObject(tareaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/tareas/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            tarea = JsonConvert.DeserializeObject<Tarea>(mensajeJson);
            return tarea;
        }
    }
}
