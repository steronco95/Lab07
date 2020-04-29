/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Event;
import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblNerc"
    private Label lblNerc; // Value injected by FXMLLoader

    @FXML // fx:id="lblYears"
    private Label lblYears; // Value injected by FXMLLoader

    @FXML // fx:id="lblHours"
    private Label lblHours; // Value injected by FXMLLoader

    @FXML // fx:id="cBoxNerc"
    private ChoiceBox<Nerc> cBoxNerc; // Value injected by FXMLLoader

    @FXML // fx:id="txtGetYears"
    private TextField txtGetYears; // Value injected by FXMLLoader

    @FXML // fx:id="txtGetHours"
    private TextField txtGetHours; // Value injected by FXMLLoader

    @FXML // fx:id="btnWorstCase"
    private Button btnWorstCase; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

	private Model model;

    @FXML
    void doSimulation(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	String anni = txtGetYears.getText();
    	String ore = txtGetHours.getText();
    	
    	
    		
    	
//    	for(Event e : model.listaEventi(cBoxNerc.getValue())) {
//			txtResult.appendText(e+ " \n");
//		}
//    	
    		model.listaEventi(cBoxNerc.getValue());
    		
    		
    		StringBuffer result = new StringBuffer();
    		
    		for(Event e : model.maxEventi(Integer.parseInt(anni), Integer.parseInt(ore))) {
    			result.append(e).append("\n");
    		}
    		
    		txtResult.appendText("numero massimo persone = " + model.getMaxPersone() + "\n");
    		txtResult.appendText(result.toString());
    	}

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert lblNerc != null : "fx:id=\"lblNerc\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblYears != null : "fx:id=\"lblYears\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblHours != null : "fx:id=\"lblHours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cBoxNerc != null : "fx:id=\"cBoxNerc\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGetYears != null : "fx:id=\"txtGetYears\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGetHours != null : "fx:id=\"txtGetHours\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnWorstCase != null : "fx:id=\"btnWorstCase\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }

	public void setModel(Model model) {
		this.model = model;
		cBoxNerc.getItems().addAll(model.getNercList());
	}
}