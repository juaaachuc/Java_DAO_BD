import dao.UserDAO;
import modelo.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println(arg);
        }

        if (args.length > 0) {
            UserDAO userDao = new UserDAO();
            User user = new User(args[0], args[1], args[2]);

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
}