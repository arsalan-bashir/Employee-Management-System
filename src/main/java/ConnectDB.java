import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/kodnestdb";
    private static final String USERNAME = "project";
    private static final String PASSWORD = "project";

    private ConnectDB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database Driver not found!", e);
        }
    }

    public static ConnectDB getInstance() throws SQLException {
        if (instance == null) {
            synchronized (ConnectDB.class) {
                if (instance == null) {
                    instance = new ConnectDB();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

