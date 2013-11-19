/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lgmachinetranslation;

/**
 *
 * @author acer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author acer
 */
public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/mesin_translasi";
    private String dbName = "mesin_translasi";
    private String host = "localhost:3306";
    private String userName = "naufal";
    private String password = "12345";
    private Connection connection = null;
    private static DBConnection myConn = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        DBConnection conn = null;
        try {
            if (myConn == null) {
                myConn = new DBConnection();
                conn = myConn;
            } else if (myConn.getConnection().isClosed()) {
                myConn = new DBConnection();
                conn = myConn;
            } else {
                conn = myConn;
            }
            return conn;
        } catch (SQLException ex) {
            return new DBConnection();
        }
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        }
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

// <editor-fold defaultstate="collapsed" desc=" Get Set ">
    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        String urlNew = "jdbc:mysql://" + getHost() + "/" + getDbName();
        this.url = urlNew;
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// </editor-fold>
}