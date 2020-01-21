package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable
{
    @FXML
    private TableView<PlayerTableModel> dataView;
    @FXML
    private TableColumn<PlayerTableModel, String> col_id;
    @FXML
    private TableColumn<PlayerTableModel, String> col_name;
    @FXML
    private TableColumn<PlayerTableModel, String> col_gender;
    @FXML
    private TableColumn<PlayerTableModel, String> col_weight;

    private ObservableList<PlayerTableModel> oblist = FXCollections.observableArrayList ();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FinalProject", "root", "Kabylake#2017");

            //create statement
            ResultSet myRS = myConn.createStatement().executeQuery("SELECT * FROM Player");

            while (myRS.next()) {
                oblist.add(new PlayerTableModel(myRS.getString("PlayerID"), myRS.getString("playerName"),
                        myRS.getString("playerGender"), myRS.getString("playerWeight")));
            }
            myConn.setAutoCommit(true);

        }catch (SQLException e){
            Logger.getLogger(TableController.class.getName()).log(Level.SEVERE, null, e);
        }
        col_id.setCellValueFactory(new PropertyValueFactory<>("PlayerID"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("PlayerGender"));
        col_weight.setCellValueFactory(new PropertyValueFactory<>("PlayerWeight"));

        dataView.setItems(oblist);
    }
}
