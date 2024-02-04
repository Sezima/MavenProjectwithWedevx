package utils;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    //This method is used to establish connection with Data Base
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static void establishConnection(){
        String url = "jdbc:mysql://3.249.240.23:3306/marinapr1214";
        String username = "marinapr1214";
        String password = "omverfbrtikyltan";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //A method that can dynamically sent Select Statements
    //and return a list of map of all columns
    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery){
        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            //getMetaData method returns the info about your info
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            while(resultSet.next()){
                Map<String, Object> rowMap = new HashMap<>();
                for(int col = 1; col<= columnCount; col++){
                    rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
                }
                dbResultList.add(rowMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbResultList;
    }

    //delete or truncate method
    public static int runSQLUpdateQuery(String sqlQuery){
        int rowsAffected = 0;
        try {
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }


    //method to close the connection
    public static void closeConnection(){
        try{
            if(resultSet != null ){
                resultSet.close();
            }
            if(statement != null ) {
                statement.close();
            }
            if(connection != null ) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteUser(String email, String ssn) throws SQLException {

        String querySsnForUserProfile = String.format("DELETE FROM user_profile WHERE ssn =\"%s\"", ssn);
        String queryEmailForUserProfile = String.format("DELETE FROM user_profile WHERE email_address=\"%s\"", email);
        String queryEmailForUsers = String.format("DELETE FROM users WHERE username=\"%s\"", email);


        String queryToGetNextValInHibernateSequence = String.format("SELECT * FROM hibernate_sequence");
        List<Map<String, Object>> nextValList = runSQLSelectQuery(queryToGetNextValInHibernateSequence);
        runSQLUpdateQuery(queryEmailForUserProfile);
        DBUtils.runSQLUpdateQuery(queryEmailForUsers);
        DBUtils.runSQLUpdateQuery(querySsnForUserProfile);
    }


    public static String formatSqlDate(Object sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        // Parse SQL date and format it to the desired format
        String date = dateFormat(sqlDate.toString());
        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

    private static String dateFormat(String date) {
        // Splitting the date into date and time parts
        String[] parts = date.split("T");

        // Extracting the hour part
        String[] timeParts = parts[1].split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if(hour>12){
            hour%=12;
        }
        // Ensuring the hour part is in two-digit format
        String formattedHour = String.format("%02d", hour);

        // Constructing the formatted date
        return parts[0] + "T" + formattedHour + ":" + timeParts[1] + ":" + timeParts[2];
    }
}
