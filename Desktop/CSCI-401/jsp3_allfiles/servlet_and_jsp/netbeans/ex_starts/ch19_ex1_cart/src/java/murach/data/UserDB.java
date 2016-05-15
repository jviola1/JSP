package murach.data;

import java.sql.*;

public class UserDB {
    
    public static boolean isAllowed(String uName, String uPass)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM murach.userpass"
                + " WHERE Username = ? AND Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, uName);
            ps.setString(2, uPass);
            rs = ps.executeQuery();
            if (rs.next()) {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM murach.userrole WHERE Username = ?");
                ps2.setString(1, uName);
                ResultSet rs2 = ps2.executeQuery();
                boolean x = false;
                
                while(rs2.next() && x == false)
                {
                    x = (rs2.getString("Rolename").equals("programmer") || rs2.getString("Rolename").equals("service"));
                }
                
                DBUtil.closeResultSet(rs2);
                DBUtil.closePreparedStatement(ps2);
                pool.freeConnection(connection);
                return x;
                
            } else {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
}
