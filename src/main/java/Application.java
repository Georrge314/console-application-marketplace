import controller.InitialController;
import dao.StoreRepository;
import dao.UserRepository;
import dao.impl.StoreRepositoryJDBC;
import dao.impl.UserRepositoryJDBC;
import service.ServiceContainer;
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
        ServiceContainer.createUserService(userRepository);

        StoreRepository storeRepository = new StoreRepositoryJDBC(connection);
        ServiceContainer.createStoreService(storeRepository);

        InitialController initialController = new InitialController(ServiceContainer.getUserService());
        initialController.init();
    }
}
