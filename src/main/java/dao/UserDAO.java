package dao;

import conexion.Conexion;
import modelo.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDAO implements IDao<User> {
    private Conexion c;
    public UserDAO() {
        c = new Conexion();
        c.abrir();
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> users = new ArrayList<User>();

        String query = "SELECT * FROM users";
        String[] columnas = {};

        ArrayList<ArrayList<String>> registros = c.ejecutarConsulta(query, columnas);

        for (ArrayList<String> registro : registros) {
            User user = new User();
            user.setId(Integer.parseInt(registro.get(0)));
            user.setName(registro.get(1));
            user.setEmail(registro.get(2));
            user.setPassword(registro.get(3));
            user.setCreated_at(registro.get(4));

            users.add(user);
        }

        return users;
    }

    @Override
    public Object select() {
        return null;
    }

    @Override
    public void insertar(Object objeto) {

    }

    @Override
    public void actualizar(Object objeto) {

    }

    @Override
    public void eliminar(int id) {

    }
}
