using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class ContratoControlador : IControlador<Contrato>
    {
        private HttpClient cliente;

        public ContratoControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<Contrato> add(Contrato contratoNuevo)
        {
            Contrato contrato = new Contrato();
            string json = JsonConvert.SerializeObject(contratoNuevo);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PostAsync("http://localhost:8080/api/contratos", content);
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            contrato = JsonConvert.DeserializeObject<Contrato>(mensajeJson);
            return contrato;
        }

        public async Task<List<Contrato>> getAll()
        {
            List<Contrato> listaContratos = new List<Contrato>();
            HttpResponseMessage mensaje = await cliente.GetAsync("http://localhost:8080/api/contratos");

            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            listaContratos = JsonConvert.DeserializeObject<List<Contrato>>(mensajeJson);

            return listaContratos;
        }

        public async Task<Contrato> getById(int id)
        {
            Contrato contrato = new Contrato();
            HttpResponseMessage mensaje = await cliente.GetAsync($"http://localhost:8080/api/contratos/{id}");
            mensaje.EnsureSuccessStatusCode();
            string mensajeJson = await mensaje.Content.ReadAsStringAsync();

            contrato = JsonConvert.DeserializeObject<Contrato>(mensajeJson);
            return contrato;
        }

        public async Task<bool> delete(int id)
        {
            HttpResponseMessage mensaje = await cliente.DeleteAsync($"http://localhost:8080/api/contratos/{id}");
            mensaje.EnsureSuccessStatusCode();
            return true;
        }

        public async Task<Contrato> update(Contrato ofertaModificada, int id)
        {
            Contrato contrato = new Contrato();
            string json = JsonConvert.SerializeObject(ofertaModificada);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage mensaje = await cliente.PutAsync($"http://localhost:8080/api/contratos/{id}", content);
            mensaje.EnsureSuccessStatusCode();

            string mensajeJson = await mensaje.Content.ReadAsStringAsync();
            contrato = JsonConvert.DeserializeObject<Contrato>(mensajeJson);
            return contrato;
        }
    }
}
