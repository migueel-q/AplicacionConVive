using Modelos;
using Newtonsoft.Json;

public class ChatRelacionControlador
{
    private HttpClient cliente = new HttpClient();

    // Devuelve el propietario con el que habla un inquilino
    public async Task<int?> ObtenerPropietarioDeInquilino(int inquilinoId)
    {
        var resp = await cliente.GetAsync($"http://localhost:8080/api/{inquilinoId}/0");
        if (!resp.IsSuccessStatusCode) return null;

        string json = await resp.Content.ReadAsStringAsync();
        var mensajes = JsonConvert.DeserializeObject<List<Mensaje>>(json);

        if (mensajes.Count == 0) return null;

        return mensajes[0].propietario.id;
    }

    // Devuelve el inquilino con el que habla un propietario
    public async Task<int?> ObtenerInquilinoDePropietario(int propietarioId)
    {
        var resp = await cliente.GetAsync($"http://localhost:8080/api/0/{propietarioId}");
        if (!resp.IsSuccessStatusCode) return null;

        string json = await resp.Content.ReadAsStringAsync();
        var mensajes = JsonConvert.DeserializeObject<List<Mensaje>>(json);

        if (mensajes.Count == 0) return null;

        return mensajes[0].inquilino.id;
    }
}
