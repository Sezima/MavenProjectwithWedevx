package justForPractice.db;

import java.sql.*;

public class PracticeSQL {

    public static void main(String[] args) throws SQLException {
        //database URL (ip or hostname), username, password

//jdbs - is mandatory is not change
//mysql is varibale , it changes to oracle, sqlserver

//String url = "jdbs:mysql://hostname:port/defaultschemaname"

        String url = "jdbc:mysql://3.249.240.23:3306/forcheck";

        String username = "forcheck";

        String password = "xgcotqpavifizurk";

//tell the jdbs which driver to use

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Establish
            connection = DriverManager.getConnection(url, username, password);
            // statement is a pre req to send a query
             statement = connection.createStatement();

            //execute select query  and save the result in an sql custom object
             resultSet = statement.executeQuery("select * from users");

            //result set returns a list of all rows
            //newxt method is like a pointer
            // when you run next your resultSet is going to be pointing to the next row




            resultSet.next();
            System.out.println(resultSet.getString("username"));


            resultSet.next();
            System.out.println(resultSet.getInt("profile_id"));


            System.out.println("===============dinamic code================");
            while (resultSet.next()){
                System.out.print(resultSet.getInt("id") + " |");
                System.out.print(resultSet.getInt("account_non_expired") + " |");
                System.out.print(resultSet.getInt("account_non_locked") + " |");
                System.out.print(resultSet.getInt("credentials_non_expired") + " |");
                System.out.print(resultSet.getInt("enabled") + " |");
                System.out.print(resultSet.getString("username") + " |");
                System.out.println(resultSet.getInt("profile_id") + " |");
            }


            int rowsAffected = statement.executeUpdate("UPDATE user_profile SET address = 'Canggu Bali' WHERE email_address = 'elon@tesla.com'");
            System.out.println(rowsAffected);
            System.out.println(rowsAffected);

            resultSet = statement.executeQuery("select * from user_profile");
            while (resultSet.next()){
                System.out.println(resultSet.getString("address"));
                System.out.println(resultSet.getString("email_address"));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }

        }
    }
}
