import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    // Ponto 1: Início
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Ponto 2: Conecta ao banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Ponto 3: Exceção de conexão
        }
        return conn; // Ponto 4: Vai Retorna (null ou válida)
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Ponto 5: Chama a classe conectarBD()

        // Ponto 6: query SQL
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "' ";
        sql += "AND senha = '" + senha + "'";

        try {
            // Ponto 7: Criação de Statement e execução da query
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Ponto 8: Verifica se a query retornou resultados
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome"); // Ponto 9: Atualiza as variáveis
            }
        } catch (Exception e) {
            // Ponto 10: Parametro de exceção
        }
        return result; // Ponto 11: Retorna o resultado
    }
}