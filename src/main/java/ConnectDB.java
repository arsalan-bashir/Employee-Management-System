import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance;
    private Connection connection;

    private static  String URL = System.getProperty("JDBC_URL");
    private static String USERNAME = System.getProperty("JDBC_USERNAME");
    private static String PASSWORD = System.getProperty("JDBC_PASSWORD");
    
     

    private ConnectDB() throws SQLException {
    	
    	if (URL == null) URL = "jdbc:mysql://localhost:3306/kodnestdb";
        if(USERNAME == null) USERNAME = "remote";
        if(PASSWORD == null) PASSWORD = "remote";
        
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

