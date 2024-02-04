package justForPractice;

import java.sql.*;

public class Week21_Exercise2 {
    public static void main(String[] args) throws SQLException  {
        String url = "jdbc:mysql://3.249.240.23:3306/isabella911";
        String username = "isabella911";
        String password = "wiqltojxvpoyyxru";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.setMaxRows(3);
            resultSet = statement.executeQuery("select * from account");

            while(resultSet.next()){
                System.out.print("id: " + resultSet.getString("id") + " ");
                System.out.println("current_balance: " + resultSet.getString("current_balance"));
            }
            System.out.println("===========================================================================================================");

            resultSet = statement.executeQuery("select * from account");

            resultSet.next();
            int rowCounter = 1;
            int savedId;
            int rowsAffected;

            while (resultSet.next()) {
                rowCounter++;

                if (rowCounter == 3) {
                    int id = resultSet.getInt("id");
                    // Update the current_balance column with the id of the third row
                    rowsAffected = statement.executeUpdate("UPDATE account SET current_balance = " + id + " WHERE id = " + id);
                    break; // Exit the loop after updating the third row
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Handle SQL exception
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
