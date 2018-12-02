package studio.bed.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.stream.Collectors;


public class UserController {
    private String name;
    private int ID;

    UserList userList = new UserList();


    @FXML
    private TextField setName1;

    @FXML
    private TextField setID1;

    @FXML
    private Button addButton;

    @FXML
    private TextField setName2;

    @FXML
    private TextField setID2;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listViwe;

    @FXML
    private Label errorLabel;

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @FXML
    void EAdd(ActionEvent event) {
        errorLabel.setText("");
        if(setName1.getText().length() <3){
            errorLabel.setText(" User's name is very short");
            return;
        }
        if(setID1.getText().length() <3) {
            errorLabel.setText(" User's ID is very short");
            return;
        }
        this.name = setName1.getText();
        this.ID = Integer.parseInt(setID1.getText());
        if(userList.HasUser(UserList.Create(this.name, this.ID))){
            return;
            }
        else {
            setName1.setText("");
            setID1.setText("");
            userList.Add(UserList.Create(this.name, this.ID));
            UpdateList();
        }
    }

    @FXML
    void EDelete(ActionEvent event) {
        errorLabel.setText("");
        if(setName2.getText().length() <3){
            errorLabel.setText(" User's name is very short");
            return;
        }
        if(setID2.getText().length() <3) {
            errorLabel.setText(" User's ID is very short");
            return;
        }
        this.name = setName2.getText();
        this.ID = Integer.parseInt(setID2.getText());
        if(userList.HasUser(UserList.Create(this.name, this.ID))){
            userList.Remove(UserList.Create(this.name, this.ID));
        }
        UpdateList();
    }

    private void UpdateList(){
        listViwe.setItems(null);
        for(User e : this.userList.getUsers()){
            listViwe.getItems().addAll(">>" + e.getName() + ": " + e.getID());
        }

    }
}
