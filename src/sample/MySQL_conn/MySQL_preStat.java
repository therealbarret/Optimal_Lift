package sample.MySQL_conn;

import java.sql.*;

public class MySQL_preStat
{
    public static void main(String[] args)
    {
        Connection myConn = null;
        PreparedStatement myStat = null;
        try {
            // get connection
            myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            // create statement
            myStat = myConn.prepareStatement("UPDATE Player set playerWeight = ? where playerID = ?");

            // set param
            myStat.setString(1, "155 lbs");
            myStat.setString(2, "Barret Margin Jr");

            System.out.println("Update complete!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

