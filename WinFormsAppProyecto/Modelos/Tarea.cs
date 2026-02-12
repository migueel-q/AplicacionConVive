namespace Modelos
{
    public class Tarea
    {
        public int id {  get; set; }
        public string descripcion { get; set; }
        public Inquilino inquilinoId { get; set; }
    }
}
