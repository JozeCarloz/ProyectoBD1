package intranet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Intranet extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = 
           FXMLLoader.load(getClass().getResource("/intranet/IntranetAlumno.fxml"));
 
        Scene scene = new Scene(root);
        stage.setTitle("Intranet");
        stage.setScene(scene);
        stage.show();
        
    }
    
   public static void main(String[] args) {
      launch(args);
   }
}