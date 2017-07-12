import java.sql.*;

/**
 * Created by Zufar on 12-Jul-17.
 */
public class DAO {
    public static void main(String[] args) {
        // Загружаем класс драйвера
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("НЕ удалось загрузить драйвер ДБ.");
            e.printStackTrace();
            System.exit(1);
        }

        // Cоздаем соединение, здесь dbpath это путь к папке где будут хранится
        // файлы БД. dbname имя базы данных. SA это имя пользователя который
        // создается автоматически при создании БД пароль для него пустой. Если
        // такой базы данных нет она будет автоматически создана.
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:dbpath/dbname", "SA", "");
        } catch (SQLException e) {
            System.err.println("НЕ удалось оздать соединение.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            Statement statement = connection.createStatement();
            // создаем таблицу со столбцами id и value.
            String query = "CREATE TABLE mytable (id IDENTITY , value VARCHAR(32))";
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                // если таблица создана, будет исключение, игнорируем его.
                //в реальных проектах так не делают
            }
            statement.close();

            // добавляю записи в таблицу.
            statement = connection.createStatement();
            query = "INSERT INTO mytable (value) VALUES('Киев')";
            statement.executeUpdate(query);
            statement.close();

            statement = connection.createStatement();
            query = "INSERT INTO mytable (value) VALUES('Киев')";
            statement.executeUpdate(query);
            statement.close();

            statement = connection.createStatement();
            query = "INSERT INTO mytable (value) VALUES('Киев')";
            statement.executeUpdate(query);
            statement.close();


            // достаю записи из таблицы
            statement = connection.createStatement();
            query = "SELECT id, value FROM mytable";
            ResultSet resultSet = statement.executeQuery(query);

            // распечатываю
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2));
            }
            statement.close();

            // тключаюсь от БД
            statement = connection.createStatement();
            query = "SHUTDOWN";
            statement.execute(query);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
