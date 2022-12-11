package group13.backend;

import group13.SnakeGameMain;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Map;
import java.util.List;

public class LeaderBoard {

        public static Scene getLeaderScene () throws Exception {

        VBox leaderLayout = new VBox(8);
        leaderLayout.setPrefSize(700, 700);
        leaderLayout.setAlignment(Pos.CENTER);

        Button backToMenu = new Button("Back To Menu");
        backToMenu.setOnMousePressed(e -> {
                    try {
                        SnakeGameMain.showMenu();
                    } catch (Exception e1) {
                        System.out.println("Please try again later");
                    }
                }
        );

        ScoreHandler handler = new ScoreHandler();
        List<Map<String, Object>> LeaderList = handler.getHighScoreList(11);

            for( int i = 0; i < LeaderList.size(); i++){
                String player = (String) LeaderList.get(i).get("name");
                int score = (Integer) LeaderList.get(i).get("score");

                int j=i+1;
                String display = ("#" + j +" " + player + ", " + score);
                Label result = new Label(display);
                result.setPrefSize(300, 35);
                leaderLayout.getChildren().addAll(result);

                result.setStyle("-fx-background-color: #ffffff; " +
                        "-fx-text-fill: #000000;" +
                        "-fx-font-size: 30px;" +
                        "-fx-padding: 5 10 5 10; " +
                        "-fx-border-width: 5px;" +
                        "-fx-border-color: #83B799;" +
                        "-fx-font-family:'Pixeboy';" +
                        "src: url('Pixeboy-z8XGD.ttf');" +
                        "-fx-text-alignment: center;");
            }

            //Styling of the Leader Board

            leaderLayout.setStyle("-fx-background-color:" +
                    "            linear-gradient(#3a3838, #ababab)," +
                    "            linear-gradient(#000000, #5b5550)," +
                    "            linear-gradient(from 0% 0% to 30% 50%, rgba(255, 255, 255, 0.9), rgba(0, 0, 0, 0));\n");

            backToMenu.setStyle(
                    "-fx-background-color: " +
                    "   linear-gradient(#83B799, #83B799)," +
                    "   linear-gradient(#83B799, #83B799)," +
                    "   linear-gradient(#83B799, #83B799)," +
                    "   linear-gradient(#000000 0%, #000000 50%, #050505 100%)," +
                    "   linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                    "    -fx-background-radius: 30;" +
                    "    -fx-background-insets: 0,1,2,3,0;" +
                    "    -fx-text-fill: White;" +
                    "    -fx-font-weight: bold;" +
                    "    -fx-font-size: 20px;" +
                    "    -fx-padding: 15 20 15 20;" +
                    "    -fx-font-family: 'Pixeboy';" +
                    "    src: url('Pixeboy-z8XGD.ttf')");

            leaderLayout.getChildren().addAll(backToMenu);
        SnakeGameMain.stage.show();
        return new Scene(leaderLayout);
        }




}