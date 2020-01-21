package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import jdk.internal.org.jline.terminal.MouseEvent.Button;

public class Controller
{
    @FXML
    public Button Login;
    public Button sendToAddForm;
    public Button sendToEditForm;
    public Button sendToDeleteForm;
    public Button begin;
    @FXML
    private Label lblStatus;
    @FXML
    private TextField  txtUsername;
    @FXML
    private TextField  txtPassword;

    //login window with credentials
    public void login(ActionEvent event) throws Exception
    {
        if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Successful");

            //next window
            Stage menu = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/sample/PlayerDiscovery.fxml"));
            Scene scene = new Scene(root, 485,319);
            scene.getStylesheets().add(getClass().getResource("PlayerDiscovery.fxml").toExternalForm());
            menu.setScene(scene);
            menu.show();

            //next window
            Stage dataview = new Stage();
            root = FXMLLoader.load(getClass().getResource("/sample/ViewTable.fxml"));
            scene = new Scene(root, 400,400);
            scene.getStylesheets().add(getClass().getResource("ViewTable.fxml").toExternalForm());
            dataview.setScene(scene);
            dataview.show();
        } else {
            lblStatus.setText("Login Failed");
        }
    }

    public void addPlayer (ActionEvent event) throws IOException
    {
        //next window
        Stage addition = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/addPlayer.fxml"));
        Scene scene = new Scene(root, 472,314);
        scene.getStylesheets().add(getClass().getResource("addPlayer.fxml").toExternalForm());
        addition.setScene(scene);
        addition.show();
    }

    @FXML
    private TextField addFullName;
    @FXML
    private TextField addGender;
    @FXML
    private TextField addWeight;
    @FXML
    private Button save;
    public void add (ActionEvent event)
    {
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
            String sql = "INSERT INTO Player (playerName, playerGender, playerWeight)" +
                    "VALUES ('"+ addFullName.getText() +"','"+ addGender.getText() +"','"+ addWeight.getText() +"')";
            myStat.executeUpdate(sql);
            myConn.setAutoCommit(true);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button CloseAdd;
    public void CloseAddPlayer (ActionEvent event) {
        Stage addition = (Stage) CloseAdd.getScene().getWindow();
        addition.close();
    }

    //window to edit player
    public void editPlayer (ActionEvent event) throws Exception
    {
        //next window
        Stage edit = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/editPlayer.fxml"));
        Scene scene = new Scene(root, 469,322);
        scene.getStylesheets().add(getClass().getResource("editPlayer.fxml").toExternalForm());
        edit.setScene(scene);
        edit.show();
    }

    @FXML
    private TextField editWeight;
    @FXML
    private TextField getPlayerID;
    @FXML
    private Button edit;
    public void edit (ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //get connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            //create statement
            Statement myStat = myConn.createStatement();
            String sql = ("UPDATE Player set playerWeight = ('"+ editWeight.getText() +"') where PlayerID = ('"+ getPlayerID.getText() +"')");

            //execute query
            myStat.executeUpdate(sql);
            myConn.setAutoCommit(true);

            System.out.println("Update complete!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private Button close;

    public void CloseEditPlayer(ActionEvent event) {
        Stage edit = (Stage) close.getScene().getWindow();
        edit.close();
    }

    //window to delete player
    public void deletePlayer(ActionEvent event) throws Exception
    {
        //next window
        Stage delete = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/deletePlayer.fxml"));
        Scene scene = new Scene(root, 491,274);
        scene.getStylesheets().add(getClass().getResource("deletePlayer.fxml").toExternalForm());
        delete.setScene(scene);
        delete.show();
    }

    @FXML
    private TextField getPlayerName;
    @FXML
    private Button deleteYes;
    public void delete (ActionEvent event)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //get connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            //execute SQL query
            Statement myStat = myConn.createStatement();
            String sql = "DELETE FROM Player WHERE playerName = ('"+ getPlayerName.getText() +"')";

            myStat.executeUpdate(sql);
            myConn.setAutoCommit(true);

            System.out.println("Delete complete!");
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private Button deleteNow;
    public void CloseDeletePlayer (ActionEvent event) {
        Stage delete = (Stage) deleteNow.getScene().getWindow();
        delete.close();
    }

    //window to begin Events
    public void showEvent (ActionEvent event) throws IOException {
        //next window
        Stage show = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/startEvent.fxml"));
        Scene scene = new Scene(root, 600,400);
        scene.getStylesheets().add(getClass().getResource("startEvent.fxml").toExternalForm());
        show.setScene(scene);
        show.show();
    }
}