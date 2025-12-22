using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controlador
{
    public interface IControlador<T>
    {
        public Task<List<T>> getAll();
        public Task<T> getById(int id);
        public Task<T> add(T t);
        public Task<T> update(T t, int id);
        public Task<bool> remove(int id);

    }
}
