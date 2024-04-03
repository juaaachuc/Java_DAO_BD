package dao;

import java.util.ArrayList;

public interface IDao<T> {
    public ArrayList<T> selectAll();

    public Object select();

    public void insertar(Object objeto);

    public void actualizar(Object objeto);

    public void eliminar(int id);
}
