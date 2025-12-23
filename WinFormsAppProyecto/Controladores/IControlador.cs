namespace Controladores
{
    public interface IControlador<T>
    {
        public Task<List<T>> getAll();
        public Task<T> getById(int id);
        public Task<T> add(T t);
        public Task<T> update(T t, int id);
        public Task<bool> delete(int id);
    }
}
