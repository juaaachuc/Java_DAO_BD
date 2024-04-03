import dao.UserDAO;
import modelo.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserDAO userDao = new UserDAO();
        ArrayList<User> users = userDao.selectAll();

        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}