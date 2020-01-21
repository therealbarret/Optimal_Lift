package sample.MySQL_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_Update
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/FinalProject";
        String user = "root";
        String password = "Kabylake#2017";

        try {
            //get connection
            Connection myConn = DriverManager.getConnection(url, user, password);

            //create statement
            Statement myStat = myConn.createStatement();

            //execute SQL query
            String sql = "update Player "
                    + "set playerWeight = '155 lbs'"
                    + "where playerName = 'Barret Margin Jr'";

            myStat.executeUpdate(sql);

            System.out.println("Update complete!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

