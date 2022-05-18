import controller.InitialController;
import util.JdbcUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        String dbConfigPath = Application.class.getClassLoader()
                .getResource("jdbc.properties").getPath();
        properties.load(new FileInputStream(dbConfigPath));
        Connection connection = JdbcUtil.createDbConnection(properties);

        InitialController initialController = new InitialController();
        initialController.init();
    }
}
