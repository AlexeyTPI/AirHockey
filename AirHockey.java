
/**
 *AirHockey game;
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AirHockey {

    private final Puck puck;
    private final Bat batLeft;
    private final Bat batRight;
    public GameDisplay goalLeft;
    public GameDisplay goalRight;


    /**
     * Constructor for objects of class Hockey
     */
    public AirHockey() {
        this.puck = new Puck();
        this.batLeft = new Bat(false);
        this.batRight = new Bat(true);
        this.goalLeft = new GameDisplay(999, -10, Polygon.heightPolygon - 140);
        this.goalRight = new GameDisplay(999, Polygon.widthPolygon - 105 - 45, Polygon.heightPolygon - 140);
        this.goalLeft.setValue(this.puck.a);
        this.goalRight.setValue(this.puck.b);
    }
    /**
     * writes goals for the player "a" and player "b"
     */
    public void writeGoal() {
        this.goalLeft.setValue(this.puck.a);
        this.goalRight.setValue(this.puck.b);
    }

    /**
     * writes goals
     */
    public void tick() {
        this.puck.move(this.batLeft, this.batRight);
        this.writeGoal();
    }
    /**
     * bat moves UP
     */
    public void moveUp() {
        this.batLeft.moveUp();
    }
    /**
     * bat moves Down
     */
    public void moveDown() {
        this.batLeft.moveDown();
    }
    /**
     * bat moves Right
     */
    public void moveRight() {
        this.batRight.moveUp();
    }
    /**
     * bat moves Left
     */
    public void moveLeft() {
        this.batRight.moveDown();
    }
    /**
     * Run the game
     */
    public void runGame() {
        Manager manager = new Manager();
        manager.manageObjects(this);
    }
    /**
     * Cancel the game
     */
    public void cancel() {
        System.exit(0);
    }
}
