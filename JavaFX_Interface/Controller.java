import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Get text from the FXML text box
 * Process the text
 * Show the text in the FXML folder
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
   @FXML
    private TextField namefield;
   
    @FXML
   private Label outputLabel;
   
   @FXML
   protected void onHelloClicked()
   {
       String name = namefield.getText();
       outputLabel.setText("Hello" + name);
   }
}