package MyServlet.DAO;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpDAO {
    public static DataSource ds = null;
    static {
        try {
            Properties prop = new Properties();
            InputStream in = DbcpDAO.class.getClassLoader()
                    .getResourceAsStream("dbcpconfig.properties");
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnect(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
