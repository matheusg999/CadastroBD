package cadastro.model.util;

import java.sql.*;




public class ConectorBD {
    
      private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "loja";   
    private static final String PASSWORD = "loja"; 

    // Retorna uma conexão com o banco
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Retorna um PreparedStatement para o SQL informado e conexão fornecida
    public static PreparedStatement getPrepared(String sql, Connection con) throws SQLException {
        return con.prepareStatement(sql);
    }

    // Retorna um ResultSet para uma consulta SQL e conexão fornecida
    public static ResultSet getSelect(String sql, Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }

    // Métodos close para fechar Statement, ResultSet e Connection

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    

