package dao;

import conexion.Conexion;
import modelo.User;

import java.util.ArrayList;

public class UserDAO implements DAOGeneral<Integer, User> {
    private final Conexion c;
    public UserDAO() {
        c = new Conexion<User>();
    }

    @Override
    public boolean agregar(User user) {
        String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

        return c.ejecutarActualizacion(query, user.getAll());
    }

    @Override
    public ArrayList<User> consultar() {
        String query = "SELECT * FROM users";

        ArrayList<ArrayList<String>> res = c.ejecutarConsulta(query, new String[]{});
        ArrayList<User> users = new ArrayList<User>();

        for (ArrayList<String> r: res) {
            users.add(new User(Integer.parseInt(r.get(0)), r.get(1), r.get(2), r.get(3), r.get(4)));
        }

        return users;
    }

    @Override
    public boolean actualizar(Integer id, User nuevo) {
        String query = "UPDATE users SET name=?, email=?, password=? WHERE id=?";

        return c.ejecutarActualizacion(query, new Object[]{
                nuevo.getName(),
                nuevo.getEmail(),
                nuevo.getPassword(),
                id
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }
}
