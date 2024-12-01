import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe User para operações de autenticação do usuário.
 */
public class User {

    /**
     * Estabelece conexão com o banco de dados.
     * 
     * @return Objeto Connection ou null em caso de falha.
     */
    public Connection conectarBancodeDados() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Exceção tratada
        }
        return conn;
    }
    public String nome = "";
    public boolean result = false;

    /**
     * Verifica a existência de um usuário no banco de dados.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return True se o usuário for encontrado, False caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        boolean result = false;
        Connection conn = conectarBancodeDados();
        String sql = "";
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";
        sql += " and senha = '" + senha + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");   
            }
        } catch (Exception e) {
            // Exceção tratada
        }
        return result;
    }
}