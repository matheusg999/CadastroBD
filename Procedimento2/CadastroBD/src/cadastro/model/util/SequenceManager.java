package cadastro.model.util;

import java.sql.*;

public class SequenceManager {

    // Retorna o próximo valor da sequência informada
    public static long getValue(String sequenceName) {
        long value = -1;
        String sql = "SELECT NEXT VALUE FOR " + sequenceName + " AS nextVal";
        
        try (Connection con = ConectorBD.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                value = rs.getLong("nextVal");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value;
    }
}