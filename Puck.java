
/**
 * Write a description of class Puck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Puck {
    private Bat bat;
    private Puck puck;
    private CustomCircle circle;
    private int positionX;
    private int positionY;
    private int sizeMoveX = 10;
    private int sizeMoveY = 10;
    private int moveX;
    private int moveY;
    public int a = 0;
    public int b = 0;

    public Puck() {
        this.positionX =
                this.positionY =

                        this.moveX = sizeMoveX;
        this.moveY = sizeMoveY;

        this.circle = new CustomCircle();
        this.circle.changePaint("black");
    }
}
