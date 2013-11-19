/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lgmachinetranslation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Prunning {

    ResultSet rs = null;
    PreparedStatement st = null;
    private Connection conn;

    public Prunning(Connection connection) {
        this.conn = connection;
    }

    String[][] getPrunning(String word) throws SQLException {
        int i = 0, j = 0;
        String temp[][] = new String[100][100];
        String sql = "SELECT * FROM kata WHERE inggris=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, word);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            temp[j][0] = rs.getString("inggris");
            temp[j][1] = rs.getString("indonesia");
            temp[j][2] = rs.getString("fungsi_kata");
            j++;
        }
        return temp;
    }

    int getCount(String word) throws SQLException {
        int count = 0;
        String sql = "SELECT count(inggris) as inggris FROM kata WHERE inggris=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, word);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            count = rs.getInt("inggris");
        }
        return count;
    }
}
