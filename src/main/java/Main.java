import dao.UserDAO;
import modelo.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();
        User user = new User("Pepito", "Conejo", "pepitoconejo@gmail.com");

        boolean usuarioCreado = userDao.agregar(user);

        if (usuarioCreado) {
            System.out.println("El usuario ha sido creado");
        } else {
            System.err.println("Hubo un problema al crear al usuario");
        }

        ArrayList<User> usuarios = userDao.consultar();
        System.out.println(usuarios.toString());
    }
}