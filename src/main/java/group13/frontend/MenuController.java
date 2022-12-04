package group13.frontend;

import group13.SnakeGameMain;
import group13.snakegame.SnakeGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {
    SnakeGame game = new SnakeGame();

    public void startGame() throws Exception {
        SnakeGameMain.stage.setScene(game.getScene());
        game.startGame();
    }

    public void leaderBoard(){
        System.out.println("Coming soon...");

    }

    public  void exitGame(){
        System.out.println("Coming soon...");

    }

    public void howToPlay() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HowToPlayController.class.getResource("/HowToPlay.fxml"));
        Parent root = loader.load();
        Scene howToPlayScene = new Scene(root);
        SnakeGameMain.stage.setScene(howToPlayScene);

    }


}