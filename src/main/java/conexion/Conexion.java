package conexion;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public final class Conexion {

    private static final String bd = "tamp1_5_guimvc";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String host = "localhost";
    private static final String puerto = "3306";
    private final String url;

    private Connection conexion;

    public Conexion() {
        url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
    }

    public boolean abrir () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
    }

    public Connection obtener() {
        return conexion;
    }

    public boolean cerrar() {
        try {
            conexion.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<ArrayList<String>> ejecutarConsulta(String query, String[] columnas) {
        if (!query.isBlank()) {
            try {
                Statement st = this.conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData metadata = rs.getMetaData();

                if (columnas.length == 0) {
                    int numColumnas = metadata.getColumnCount();
                    columnas = new String[numColumnas];

                    for (int i = 1; i <= numColumnas; i++) {
                        columnas[i-1] = metadata.getColumnName(i);
                    }
                }

                ArrayList<ArrayList<String>> registros = new ArrayList<ArrayList<String>>();

                while (rs.next()) {
                    ArrayList<String> registro = new ArrayList<String>();
                    for (String columna: columnas) {
                        registro.add(rs.getString(columna));
                    }
                    registros.add(registro);
                }

                return registros;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}