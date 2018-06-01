/**
 * Sample Skeleton for 'Bar.fxml' Controller Class
 */

package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Simula"
    private Button Simula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doSimulazione(ActionEvent event) {
    	model.init();
    	int numClienti=model.getTotClienti();
    	int numClientiSoddisfatti=model.getTotClientiSoddisfatti();
    	int numClientiInsoddisfatti=model.getTotClientiInsoddisfatti();
    	
    	txtResult.setText("Tot clienti: "+numClienti+"\n Tot clienti soddisfatti: "+numClientiSoddisfatti+"\n"
    			+ "Tot clienti non soddisfatti: "+numClientiInsoddisfatti);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Simula != null : "fx:id=\"Simula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    private Simulatore model;
	public void setModel(Simulatore model) {
		this.model=model;
		
		
	}
}
