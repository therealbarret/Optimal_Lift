package sample.MySQL_conn;

import java.sql.*;

public class MySQL_insert
{
    public static void main(String[] args){
        String url = "jdbc:mysql://127.0.0.1:3306/FinalProject";
        String user = "root";
        String password = "Kabylake#2017";

        try {
            //get connection
            Connection myConn = DriverManager.getConnection(url, user, password);

            //create statement
            Statement myStat = myConn.createStatement();

            //execute SQL query
            String sql = "INSERT INTO Player "
                    + "VALUES ('Jorydn Woods', 'Female', '135 lbs')";

            myStat.executeUpdate(sql);

            System.out.println("Insert complete!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

