import java.awt.Rectangle;

/**
 * Rectangle with which you can move, and you can see it on the polygon.
 *
 */
public class CustomRectangle {
    private int sideA;
    private int sideB;
    private int leftTopX;
    private int leftTopY;
    private String color;
    private boolean isVisible;

    /**
     * Creates new rectangle with the pre-definition color on the pre-definition position.
     */
    public CustomRectangle() {
        this.sideA = 30;
        this.sideB = 60;
        this.leftTopX = 60;
        this.leftTopY = 50;
        this.color = "black";
        this.isVisible = false;
    }

    /**
     * (Rectangle) Display.
     */
    public void show() {
        this.isVisible = true;
        this.draw();
    }

    /**
     * (Rectangle) Hide.
     */
    public void hide() {
        this.delete();
        this.isVisible = false;
    }

    /**
     * (Rectangle) Move UP on the certain distance.
     */

    /**
     * (Rectangle) Move Horizontal on the certain distance.
     */
    public void moveHorizontal(int distance) {
        this.delete();
        this.leftTopX += distance;
        this.draw();
    }

    /**
     * (Rectangle) Move Vertically according to the parameter.
     */
    public void moveVertical(int distance) {
        this.delete();
        this.leftTopY += distance;
        this.draw();
    }

    /**
     * (Rectangle) Move slowly Horizontally according to the parameter.
     */


    /**
     * (Rectangle) Change side sizes on these parameters.
     * The side size must be > 0
     */
    public void changeSide(int sideA, int sideB) {
        this.delete();
        this.sideA = sideA;
        this.sideB = sideB;
        this.draw();
    }

    /**
     * (Rectangle) Change the color on the printed value.
     * Name of the color must be in English.
     * Number of colors:
     * blue;
     * red;
     * black;
     * white;
     * yellow;
     * green;
     * magenta.
     */
    public void changeColor(String color) {
        this.color = color;
        this.draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    private void draw() {
        if (this.isVisible) {
            Polygon canvas = Polygon.getPolygon();
            canvas.draw(this, this.color,
                    new Rectangle(this.leftTopX, this.leftTopY, this.sideA, this.sideB));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    private void delete() {
        if (this.isVisible) {
            Polygon canvas = Polygon.getPolygon();
            canvas.erase(this);
        }
    }
}
