package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
 private static final String url = "jdbc:mysql://localhost:3306/mercado";
    private static final String usuario = "root";
    private static final String senha = "";
    
    public static Connection conectar() throws SQLException {
        return (Connection) DriverManager.getConnection(url, usuario, senha);
    }
}
