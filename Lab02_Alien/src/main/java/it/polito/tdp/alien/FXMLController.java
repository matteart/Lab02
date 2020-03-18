package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
private AlienDictionary ad;
private List <String> wordTranslated = new LinkedList <String> ();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtArea;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {
      this.wordTranslated.clear();
      String rtrn="";
      for(String s:wordTranslated)
     	 if(s!=null )
     		 rtrn += s+"\n";
      txtResult.setText(rtrn);
    }

    @FXML
    void doTranslate(ActionEvent event) {
     String alienW = txtArea.getText();
     
     String translate = ad.translateWord(alienW);
     if(translate==null)
    	 translate="Nessuna parola inserita";
     wordTranslated.add(translate);
     String rtrn="";
     for(String s:wordTranslated)
    	 if(s!=null )
    		 rtrn += s+"\n";
     txtResult.setText(rtrn);
     
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
ad = new AlienDictionary();
ad.addWord("buga", "ciao");
ad.addWord("lol", "che ridere");

    }
}
