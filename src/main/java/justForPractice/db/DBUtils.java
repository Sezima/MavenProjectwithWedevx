package justForPractice.db;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DBUtils {

    /**
     * Здесь объявлена статическая переменная типа Connection с именем connection.
     * Ключевое слово static означает, что эта переменная принадлежит самому классу,
     * а не какому-то конкретному экземпляру класса.
     */
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;


    //method to establish connection with the db

    /**
     * метод с именем establishConnection.
     * Этот метод отвечает за создание соединения с базой данных
     */
    public static void establishConnection() {


        /**
         * Детали соединения с базой данных:  Это URL-адрес соединения с базой данных MySQL,
         * Это URL-адрес соединения с базой данных MySQL, включающий IP-адрес (3.249.240.23),
         * номер порта (3306) и имя базы данных (forcheck).
         * включающий IP-адрес (3.249.240.23), номер порта (3306) и имя базы данных (forcheck). Username and password
         */

        String url = "jdbc:mysql://3.249.240.23:3306/sezimosm148";

        String username = "sezimosm148";

        String password = "rhznpjlawootxatm";

        try {
            /**
             * Class.forName("com.mysql.jdbc.Driver");: Эта строка загружает класс драйвера JDBC для MySQL.
             *Эта строка необходима для более старых версий драйверов JDBC (до JDBC 4.0). В более новых версиях эта строка не требуется.
             */
            Class.forName("com.mysql.jdbc.Driver");

            /**
             * connection = DriverManager.getConnection(url, username, password);: Эта строка устанавливает фактическое соединение с базой данных,
             * используя указанный URL, имя пользователя и пароль. Объект соединения сохраняется в переменной connection.
             */
            connection = DriverManager.getConnection(url, username, password);


            /**
             * atch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }: Этот блок перехватывает любые исключения,
             * которые могут возникнуть в процессе соединения, и выводит трассировку стека для целей отладки.
             */
        } catch (ClassNotFoundException | SQLException e) {

            /**
             * `e.printStackTrace();` в Java используется для вывода подробной информации об исключении в консоль,
             * включая последовательность вызовов методов (трассировку стека). Это помогает разработчикам отслеживать
             * и исправлять ошибки, предоставляя контекст об исключении.
             */
            e.printStackTrace();
        }

    }


    //a method that can dynamically send select statements
    //and returns a list of map of all column


    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery){
        /**
         * Создается список (ArrayList), в котором каждый элемент представляет собой отображение (Map) столбцов.
         */
        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try{

            /**
             * Создается объект Statement (statement), который используется для выполнения SQL-запросов,
             * и выполняется запрос с использованием метода executeQuery()
             */
            statement = connection.createStatement();

            /**
             *  Этот вызов выполняет SQL-запрос, переданный в виде строки sqlQuery
             *  executeQuery() используется только для SQL-запросов, которые возвращают результат, как, например, SELECT
             *  for crad i need to use executeUpdate
             */
            resultSet = statement.executeQuery(sqlQuery);

            //getMetaData method return info about ypur info
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()){
                Map<String, Object> rowMap = new HashMap<>();

                for(int col = 1; col <= columCount; col++){
                    rowMap.put(resultSetMetaData.getCatalogName(col), resultSet.getObject(col));
                }
                dbResultList.add(rowMap);
            }

            // throwbles and e are just variable
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return dbResultList;

    }


    //create a method that inserts and update into db
    //return the nums of rows updated of 0 when action is not taken

    //update query
    public static int runSQLUpdateQuery(String sqlQuery){
        int rowsAffected = 0;
        try {
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sqlQuery);

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return  rowsAffected;
    }


    //close connection

    public static void closeConnection(){
        try {
            if(resultSet!=null){
                resultSet.close();
            }

            if(statement!= null){
                statement.close();
            }

            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }


}


/**
 * Create JDBC Utils Class and Methods
 *
 * What is bd util class ? we're going to create some utilities class which is going to have some methods that is going to make our life easier to deal with database

 * driver manager got connection we already know in our previous class we just populated wwe kind of hardcoded all this stuff in the code.
 *
 * But this is like a variable that changes configuration that changes from environment to environment.
 * whenever a configuration changes from environment to environment . You have to go and put it in the exam java properties file So it should be taken from the properties file
 */