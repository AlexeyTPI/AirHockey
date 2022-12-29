import java.awt.Rectangle;

/**
 * Rectangle with wich you can move, and you can see it on the poligon.
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
     * Creates new rectangle with the pre-definitioned color on the pre-definitioned position.
     */
    public CustomRectangle() {
        this.sideA = 30;
        this.sideB = 60;
        this.leftTopX = 60;
        this.leftTopY = 50;
        this.color = "red";
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
     * (Rectangle) Move right on the sertain distance.
     */
    public void moveRight() {
        this.moveHorizontal(20);
    }

    /**
     * (Rectangle) Move left on the sertain distance.
     */
    public void moveLeft() {
        this.moveHorizontal(-20);
    }

    /**
     * (Rectangle) Move UP on the sertain distance.
     */
    public void shiftUp() {
        this.moveVertical(-20);
    }

    /**
     * (Rectangle) Move DOWN on the sertain distance.
     */
    public void shiftDown() {
        this.moveVertical(20);
    }

    /**
     * (Rectangle) Move Horizontal on the sertain distance.
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
    public void moveSlowlyHoriizontally(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else  {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            this.leftTopX += delta;
            this.draw();
        }
    }

    /**
     * (Rectangle) Move slowly Vertically according to the parameter.
     */
    public void moveSlowlyVertically(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            this.leftTopY += delta;
            this.draw();
        }
    }

    /**
     * (Rectangle) Change side sizes on these parametres.
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

    /*
     * Draw the square with current specifications on screen.
     */
    private void draw() {
        if (this.isVisible) {
            Poligon canvas = Poligon.getPoligon();
            canvas.draw(this, this.color,
                    new Rectangle(this.leftTopX, this.leftTopY, this.sideA, this.sideB));
            canvas.wait(10);
        }
    }

    /*
     * Erase the square on screen.
     */
    private void delete() {
        if (this.isVisible) {
            Poligon canvas = Poligon.getPoligon();
            canvas.erase(this);
        }
    }
}
