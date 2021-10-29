import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorBD {
    private static Connection connection = null;

    public static Connection getConnection()
    {
        if(connection != null)
        {
            return connection;
        }
        else
        {
            try
            {
                Properties properties = new Properties();
                properties.load(new FileInputStream("bd.properties"));

                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

                Class.forName(driver);

                connection = DriverManager.getConnection(url, user, password);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
