package org.example.DAO;

import org.example.modelos.Inquilino;

import java.util.List;

public interface IDAOGeneral<T, Integer> {
    public void   insertar(T t);
    public void   actualizar(T t);
    public void  eliminar(Integer id);
    public List<T> obtenerTodos();
    public T obtenerPorId(Integer id);
}
