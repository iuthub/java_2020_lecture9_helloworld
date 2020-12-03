package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public void initialize() {
        txtGreeting.setText("Hey World");
    }

    @FXML
    private TextField txtGreeting;

    @FXML
    private Label lblGreeting;

    @FXML
    public void onButtonClicked(ActionEvent e) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblGreeting.setText("Hello, " + txtGreeting.getText());
                        }
                    });
                } catch (InterruptedException e) {

                }
            }
        };
        new Thread(task).start();
    }

    @FXML
    public void onKeyPressed() {
        lblGreeting.setText("You typed: " + txtGreeting.getText());
    }
}
