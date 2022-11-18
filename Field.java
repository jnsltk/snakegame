public class Field {
    private final int height;
    private final int width;

    private final int dimension = 20; //number of squares
    private Direction direction;
    private Food food;

    private Snake snake;

    public Field(int height, int width){
        this.height = height;
        this.width = width;
        this.snake = new Snake();
        this.food = food;
    }

    public void move(){             //The mechanism of moving the snake on the field is adding a new rectangle in front
        if (direction != null){     //of the snake head, considering the snake direction. Lastly removing the last rectangle.
            snake.grow();                                                 //Moving has the same principle as grow() method,
            snake.getSnakeBody().remove(snake.getSnakeBody().get(snake.getSnakeBody().size()-1));    //but we remove the last rectangle of the snake.
        }
    }

    public boolean die(){
        if(snake.getSnakeBody().get(0).getX() >= width* snake.getDimension() || snake.getSnakeBody().get(0).getX() <= 0 || snake.getSnakeBody().get(0).getY() >= height* snake.getDimension() || snake.getSnakeBody().get(0).getY() <= 0){
            return true;
        }   // Check if the head of the snake collide with the border, if yes return true.

        for (int i = 1; i < snake.getSnakeBody().size(); i++){
            if(snake.getSnakeBody().get(0).getX() == snake.getSnakeBody().get(i).getX() && snake.getSnakeBody().get(0).getY() == snake.getSnakeBody().get(i).getY()){
                return true;
            }        // Check if the head of the snake collide with the snake body, if yes return true.
        }
        return false;
    }


    public void up(){                           //Changes the direction of the snake.
        if(direction != Direction.DOWN){        //Make it not possible to change in the opposite direction.
            direction = Direction.UP;
        }
    }

    public void down(){
        if(direction != Direction.UP){
            direction = Direction.DOWN;
        }
    }

    public void right(){
        if(direction != Direction.LEFT){
            direction = Direction.RIGHT;
        }    }

    public void left(){
        if(direction != Direction.RIGHT){
            direction = Direction.LEFT;
        }    }


    public void spawnMouse() { //Spawns the mouse randomly

        boolean onSnake = false;

        //if mouse spawn position is at snake position then redo the process until you find a pos not on snake
        while (onSnake == false) {
            food.setMouseX((int) (Math.random() * (width * dimension)));
            food.setMouseY((int) (Math.random() * (height*dimension)));
            for (int i = 0; i < snake.getSnakeBody().size(); i++) {
                if (snake.getSnakeBody().get(i).getX() == food.getMouseX() && snake.getSnakeBody().get(i).getY()  == food.getMouseY()) {
                    onSnake = false;
                } else {
                    onSnake = true;
                }
            }
        }
    }

    public void eatMouse() { //if snakes position is at mouse position then spawn the mouse again

        if ((snake.getSnakeBody().get(0).getX() == food.getMouseX()) && (snake.getSnakeBody().get(0).getY() == food.getMouseY())) {
            spawnMouse();
        }
    }

    public int getHeight(){
        return this.height;
    }
    public int getWidth(){return this.width;}

}

