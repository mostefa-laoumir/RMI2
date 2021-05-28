import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.InetAddress;
import java.net.URL;
import java.rmi.Naming;
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

        String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":9024/IRemote";
        IRemote obj = (IRemote) Naming.lookup(url);


        String s = text.getText();
        log.setText("Resultat : "+obj.Calculatrice(s));
        System.out.println(obj.Calculatrice(s));
    } catch (Exception e) {
        e.printStackTrace();
    }
});

    }
}
