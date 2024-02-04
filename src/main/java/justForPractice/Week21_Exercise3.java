package justForPractice;


import java.sql.*;

public class Week21_Exercise3 {
    public static void main(String[] args) {
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
            resultSet = statement.executeQuery("select * from account");

            int newAccountId = 0;
            int newOwnerId = 0;
            int newAccountNumber = 0;
            String checkingAcctName = "Week 21 Single Checking Acct";
            int checkingInterestRate = 0;
            int checkingAccountTypeId = 8;
            int singleOwnershipTypeId = 17;


            while(resultSet.next()){
                newAccountId = resultSet.getInt("id") + 1;
                newOwnerId = resultSet.getInt("owner_id");
                newAccountNumber = resultSet.getInt("account_number") + 1;
            }

            resultSet = statement.executeQuery("SELECT * FROM account");

System.out.println(resultSet);

            while(resultSet.next()){
                System.out.println("name: " + resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
    }
}