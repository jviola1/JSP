package murach.data;

import java.sql.*;
import java.util.*;
import murach.business.Product;

public class UserDB {
    
    public static boolean isAllowed(String uName, String uPass)
    {
        ConnectionPool pool = ConnectionPool.getInstance(1);
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM userpass"
                + "WHERE Username = ? AND Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, uPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM userrole WHERE Username = ?");
                ps2.setString(1, uName);
                ResultSet rs2 = ps2.executeQuery();
                return (rs.getString("Rolename").equals("programmer") || rs.getString("Rolename").equals("service"));
                
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
