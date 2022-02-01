/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxhomworku;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jimbrimu
 */
public class FXMain extends Application {

 
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/javafxhomworku/FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Valuta váltó program 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

/*    
    public java.util.Map<String, Double> xmlBeolvas(String filename1) {
        java.util.Map<String, Double> currencies = new HashMap<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename1));
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
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return currencies;
    }
  */  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
