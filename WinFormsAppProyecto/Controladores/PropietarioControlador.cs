using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    internal class PropietarioControlador : IControlador<Propietario>
    {
        private HttpClient cliente;

        public PropietarioControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Propietario> add(Propietario propietarioNuevo)
        {
            Propietario gasto = new Propietario();
            string json = JsonConvert.SerializeObject(propietarioNuevo);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/propietarios", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Propietario>(mensajeJson);
            return gasto;
        }

        public async Task<List<Propietario>> getAll()
        {
            List<Propietario> listaPropietarios = new List<Propietario>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/propietarios");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaPropietarios = JsonConvert.DeserializeObject<List<Propietario>>(mensajeJson);

            return listaPropietarios;
        }

        public async Task<Propietario> getById(int id)
        {
            Propietario propietario = new Propietario();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/propietarios/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            propietario = JsonConvert.DeserializeObject<Propietario>(mensajeJson);
            return propietario;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/propietarios/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Propietario> update(Propietario propietarioModificado, int id)
        {
            Propietario propietario = new Propietario();
            string json = JsonConvert.SerializeObject(propietarioModificado);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/propietarios/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            propietario = JsonConvert.DeserializeObject<Propietario>(mensajeJson);
            return propietario;
        }
    }
}
