using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelos;

namespace Controladores
{
    internal class GastoControlador
    {
        private HttpClient cliente;

        public GastoControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Gasto> add(Gasto tareaNueva)
        {
            Gasto gasto = new Gasto();
            string json = JsonConvert.SerializeObject(tareaNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/gastos", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }

        public async Task<List<Gasto>> getAll()
        {
            List<Gasto> listaGastos = new List<Gasto>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/gastos");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaGastos = JsonConvert.DeserializeObject<List<Gasto>>(mensajeJson);

            return listaGastos;
        }

        public async Task<Gasto> getById(int id)
        {
            Gasto gasto = new Gasto();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/gastos/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }

        public async Task<bool> remove(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/gastos/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Gasto> update(Gasto tareaModificada, int id)
        {
            Gasto gasto = new Gasto();
            string json = JsonConvert.SerializeObject(tareaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/gastos/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Gasto>(mensajeJson);
            return gasto;
        }
    }
}
