using Modelos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controladores
{
    public class MensajeControlador
    {
        private HttpClient cliente;

        public MensajeControlador()
        {
            cliente = new HttpClient();
        }

        public async Task<List<Mensaje>> obtenerChat(int inquilinoId, int propietarioId)
        {
            List<Mensaje> listaMensajes = new List<Mensaje>();
            HttpResponseMessage respuesta = await cliente.GetAsync($"http://localhost:8080/api/{inquilinoId}/{propietarioId}");
            respuesta.EnsureSuccessStatusCode();

            string json = await respuesta.Content.ReadAsStringAsync();
            listaMensajes = JsonConvert.DeserializeObject<List<Mensaje>>(json);

            return listaMensajes;
        }

        public async Task<Mensaje> enviarMensaje(int inquilinoId, int propietarioId, string texto, bool enviadoPorInquilino)
        {
            string textoCodificado = Uri.EscapeDataString(texto);

            string url = $"http://localhost:8080/api/enviar" +
                         $"?inquilinoId={inquilinoId}" +
                         $"&propietarioId={propietarioId}" +
                         $"&mensaje={textoCodificado}" +
                         $"&enviadoPorInquilino={enviadoPorInquilino.ToString().ToLower()}";

            HttpResponseMessage respuesta = await cliente.PostAsync(url, null);

            respuesta.EnsureSuccessStatusCode();

            string json = await respuesta.Content.ReadAsStringAsync();
            Mensaje mensaje = JsonConvert.DeserializeObject<Mensaje>(json);
            return mensaje;
        }


    }
}
