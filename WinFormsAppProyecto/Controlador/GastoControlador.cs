using Modelos;
using Newtonsoft.Json;
using System.Text;

namespace Controlador
{
    public class GastoControlador : IControlador<Gasto>
    {
        private HttpClient cliente;

        public GastoControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Gasto> add(Gasto gastoNuevo)
        {
            Gasto gasto = new Gasto();
            string json = JsonConvert.SerializeObject(gastoNuevo);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/tareas", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }

        public async Task<List<Gasto>> getAll()
        {
            List<Gasto> listaGastos = new List<Gasto>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/tareas");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaGastos = JsonConvert.DeserializeObject<List<Gasto>>(mensajeJson);

            return listaGastos;
        }

        public async Task<Gasto> getById(int id)
        {
            Gasto gasto = new Gasto();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/tareas/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }

        public async Task<bool> remove(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/tareas/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Gasto> update(Gasto tareaModificada, int id)
        {
            Gasto gasto = new Gasto();
            string json = JsonConvert.SerializeObject(tareaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/tareas/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }
    }
}
