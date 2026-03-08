import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;

public class HelloApp extends Application
{
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HelloView.fxml"));
        Scene scene = new Scene(loader.load(), 500, 300);
        stage.setTitle("Hello FXML App");
        stage.setScene(scene);
        stage.show();
        
    }
}
