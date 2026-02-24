using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class InquilinoControlador : IControlador<Inquilino>
    {
        private HttpClient cliente;

        public InquilinoControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Inquilino> add(Inquilino inquilinoNuevo)
        {
            Inquilino gasto = new Inquilino();
            string json = JsonConvert.SerializeObject(inquilinoNuevo);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/inquilinos", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            gasto = JsonConvert.DeserializeObject<Inquilino>(mensajeJson);
            return gasto;
        }

        public async Task<List<Inquilino>> getAll()
        {
            List<Inquilino> listaInquilinos = new List<Inquilino >();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/inquilinos");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaInquilinos = JsonConvert.DeserializeObject<List<Inquilino>>(mensajeJson);

            return listaInquilinos;
        }

        public async Task<Inquilino> getById(int id)
        {
            Inquilino inquilino = new Inquilino();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/inquilinos/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            inquilino = JsonConvert.DeserializeObject<Inquilino>(mensajeJson);
            return inquilino;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/inquilinos/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Inquilino> update(Inquilino inquilinoModificado, int id)
        {
            Inquilino inquilino = new Inquilino();
            string json = JsonConvert.SerializeObject(inquilinoModificado);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/inquilinos/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            inquilino = JsonConvert.DeserializeObject<Inquilino>(mensajeJson);
            return inquilino;
        }

        public async Task<List<Inquilino>> GetInquilinosDePropietario(int propietarioId) { 
            HttpResponseMessage resp = await cliente.GetAsync($"http://localhost:8080/api/pisos/propietario/{propietarioId}/inquilinos");
            resp.EnsureSuccessStatusCode(); 
            string json = await resp.Content.ReadAsStringAsync();
            return JsonConvert.DeserializeObject<List<Inquilino>>(json); 
        }
    }
}
