package 享元.连接池;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * @author: TangLiang
 * @date: 2020/9/27 16:52
 * @since: 1.0
 */
public class ConnectionPool {
    private Vector<Connection> pool;
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "mysql";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        try {
            Class.forName(driverClassName);
            for (int i = 0; i < poolSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }
        return null;
    }

    public synchronized void release(Connection conn) {
        pool.add(conn);
    }

}
