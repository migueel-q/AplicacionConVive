using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    internal class OfertaControlador : IControlador<Oferta>
    {
        private HttpClient cliente;

        public OfertaControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Oferta> add(Oferta ofertaNueva)
        {
            Oferta oferta = new Oferta();
            string json = JsonConvert.SerializeObject(ofertaNueva);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/ofertas", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            oferta = JsonConvert.DeserializeObject<Oferta>(mensajeJson);
            return oferta;
        }

        public async Task<List<Oferta>> getAll()
        {
            List<Oferta> listaOfertas = new List<Oferta>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/ofertas");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaOfertas = JsonConvert.DeserializeObject<List<Oferta>>(mensajeJson);

            return listaOfertas;
        }

        public async Task<Oferta> getById(int id)
        {
            Oferta oferta = new Oferta();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/ofertas/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            oferta = JsonConvert.DeserializeObject<Oferta>(mensajeJson);
            return oferta;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/ofertas/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Oferta> update(Oferta ofertaModificada, int id)
        {
            Oferta oferta = new Oferta();
            string json = JsonConvert.SerializeObject(ofertaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/ofertas/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            oferta = JsonConvert.DeserializeObject<Oferta>(mensajeJson);
            return oferta;
        }
    }
}
