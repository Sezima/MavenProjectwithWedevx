package justForPractice.db;

import java.sql.*;

public class PracticeSQL {

    public static void main(String[] args) {
        //database URL (ip or hostname), username, password

//jdbs - is mandatory is not change
//mysql is varibale , it changes to oracle, sqlserver

//String url = "jdbs:mysql://hostname:port/defaultschemaname"

        String url = "jdbc:mysql://3.249.240.23:3306/forcheck";

        String username = "forcheck";

        String password = "xgcotqpavifizurk";

//tell the jdbs which driver to use

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Establish
            Connection connection = DriverManager.getConnection(url, username, password);
            // statement is a pre req to send a query
            Statement statement = connection.createStatement();

            //execute select query  and save the result in an sql custom object
            ResultSet resultSet = statement.executeQuery("select * from users");

            //result set returns a list of all rows
            //newxt method is like a pointer
            // when you run next your resultSet is going to be pointing to the next row




            resultSet.next();
            System.out.println(resultSet.getString("username"));


            resultSet.next();
            System.out.println(resultSet.getInt("profile_id"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
