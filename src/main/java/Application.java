import controller.InitialController;
import dao.UserRepository;
import dao.impl.UserRepositoryJDBC;
import service.UserService;
import service.impl.UserServiceImpl;
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

        UserRepository userRepository = new UserRepositoryJDBC(connection);
        UserService userService = new UserServiceImpl(userRepository);
        InitialController initialController = new InitialController(userService);
        initialController.init();
    }
}
