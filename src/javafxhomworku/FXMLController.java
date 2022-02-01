/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxhomworku;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author plosz
 */
public class FXMLController implements Initializable {
    private String fileNameXML;
 
    
    
    @FXML
    private TextField filenameXML;
    
    @FXML
    private ComboBox<?> comboBox1;
    @FXML
    private Button btnAtvaltas;
    
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private TextField mennyiFt;
    @FXML
    private TextField osszegFt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionXMLloader(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Válassza ki a valuta árfolyamokat tartalmazó XML-t!");
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        File file = filechooser.showOpenDialog(stage);
        
        fileNameXML = file.getPath();
        filenameXML.setText(fileNameXML);
        
        if (file != null) {
            
            
        Map<String, Double> currencies = new HashMap<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(fileNameXML));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Cube");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element elem = (Element) nodeList.item(i);
                if (elem.getAttribute("currency") != null && !elem.getAttribute("currency").isEmpty()) {
                    currencies.put(elem.getAttribute("currency"), Double.valueOf(elem.getAttribute("rate")));

                    
//                    if ("HUF".equalsIgnoreCase(elem.getAttribute("currency"))) {
//                        forintArfolyam = Float.valueOf(elem.getAttribute("rate"));
//                    }
                }
            }
//            comboBox1 = FXCollections.observableMap(currencies.values());
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


            
            
            
            
        comboBox1.setDisable(false);
        btnAtvaltas.setDisable(false);
        mennyiFt.setDisable(false);
        osszegFt.setDisable(false);
                
        }
//        System.out.println(file.getPath());
        
        
    }

    @FXML
    private void actionCombobox1(ActionEvent event) {
    }

    @FXML
    private void actionAtvaltas(ActionEvent event) {
    }
    
}
