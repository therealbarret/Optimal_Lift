package sample;

import static java.lang.Integer.parseInt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jdk.internal.org.jline.terminal.MouseEvent.Button;

public class BeginEvent {
    @FXML
    private Button eventBeginning;
    @FXML
    private TextField enterName;
    @FXML
    private TextField selectKG;
    @FXML
    private Label stringName;
    @FXML
    private Label totalLift;
    @FXML
    private TextField attempt1;
    @FXML
    private TextField attempt2;
    @FXML
    private TextField attempt3;
    @FXML
    private Label distribution;

    public void begin(ActionEvent event)
    {
        int lift = parseInt(selectKG.getText());

        //get player
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //get connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            //create statement to player
            Statement myStat = myConn.createStatement();
            String sql = ("SELECT ('" + stringName.getText() + "') FROM Player");

            //execute query
            myStat.executeQuery(sql);
            stringName.setText(enterName.getText());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //show total to be lifted
        double total = lift - 20;
        totalLift.setText(String.valueOf(total));
        /*
        double plates = 0;

        if(total >= 50)
        {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if(total >= 25)
        {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);

        }
        else if (total >= 20)
        {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= 15)
        {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= 10)
        {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= 5){
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= 2.5) {
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= 1.25){
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= .5){
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else if (total >= .25){
            double count = total / plates;
            System.out.println("Amount of 50 plates is: x" + count);
        }
        else {
            System.out.println("Either your lifting the bar or nothing!");
        }
        */

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
            String sql = "INSERT INTO Player_Attempt (PlayerName, WeightLifted, BenchAttempt, DeadLiftAttempt, SquatAttempt)" +
                    "VALUES ('"+ stringName.getText() +"','"+ totalLift.getText() +"','"+ attempt1.getText() +"','"+ attempt2.getText() +"','"+ attempt3.getText() +"')";

            myStat.executeUpdate(sql);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

