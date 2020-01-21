package sample.MySQL_conn;

import java.sql.*;
import java.lang.ClassNotFoundException;

public class MySQL_conn
{
    public static void main(String [] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {
            //get connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            //create statement
            Statement myStat = myConn.createStatement();

            //execute sql query
            ResultSet myRS = myStat.executeQuery("select * from Player");

            //process result
            while (myRS.next()){
                System.out.println(myRS.getString(2) + "," + myRS.getString(3) + "," + myRS.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


