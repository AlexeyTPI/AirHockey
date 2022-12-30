
/**
 * Write a description of class Hockey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AirHockey {

    private Puck puck;
    private Bat batLeft;
    private Bat batRight;
    public GameDisplay goalLeft;
    public GameDisplay goalRight;
    private Puck rightGoal;
    private Puck leftGoal;
    private Puck goal;

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

    public void writeGoal() {
        this.goalLeft.setValue(this.puck.a);
        this.goalRight.setValue(this.puck.b);
    }

    public void tick() {
        this.puck.move(this.batLeft, this.batRight);
        this.writeGoal();
    }

    public void moveUp() {
        this.batLeft.moveUp();
    }

    public void moveDown() {
        this.batLeft.moveDown();
    }

    public void moveRight() {
        this.batRight.moveUp();
    }

    public void moveLeft() {
        this.batRight.moveDown();
    }

    public void runGame() {
        Manager manager = new Manager();
        manager.manageObjects(this);
    }

    public void cancel() {
        System.exit(0);
    }
}
