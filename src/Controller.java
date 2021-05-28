import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField text;
    @FXML
    Label log;
    @FXML
    Button verser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
verser.setOnAction(event -> {
    try {
        Registry registry = LocateRegistry.getRegistry("192.168.43.239", 1099);
        IRemote objet = (IRemote) registry.lookup("objet-calculatrice");


        String s = text.getText();
        log.setText("Resultat : "+objet.Calculatrice(s));
        System.out.println(objet.Calculatrice(s));
    } catch (Exception e) {
        e.printStackTrace();
    }
});

    }
}
