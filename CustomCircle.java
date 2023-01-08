import java.awt.geom.Ellipse2D;

public class CustomCircle {
    private int average;
    private int leftTopX;
    private int leftTopY;
    private String paint;
    private boolean isVisible;

    /**
     * Create a new circle of a predefined color at a predefined position.
     */
    public CustomCircle() {
        this.average = 30;
        this.leftTopX = 20;
        this.leftTopY = 60;
        this.paint = "green";
        this.isVisible = false;
    }

    /**
     * (CustomCircle) create yourself.
     */
    public void show() {
        this.isVisible = true;
        this.draw();
    }

    /**
     * (CustomCircle) delete yourself.
     */
    public void hide() {
        this.isVisible = false;
        this.deleteCircle();
    }


    /**
     * (CustomCircle) Shift horizontally on the certain distance.
     */
    public void moveHorizontally(int distance) {
        this.deleteCircle();
        this.leftTopX += distance;
        this.show();
    }

    /**
     * (CustomCircle) Shift vertically on the certain distance.
     */
    public void moveVertically(int distance) {
        this.deleteCircle();
        this.leftTopY += distance;
        this.show();
    }

    /**
     * (CustomCircle) change the number by the given parameter.
     * Number must be > 0;
     */
    public void changeNumber(int number) {
        this.deleteCircle();
        this.average = number;
        this.draw();
    }

    /**
     * (CustomCircle) Change the color by such variants:
     * - "red"
     * - "yellow"
     * - "blue"
     * - "green"
     * - "magenta"
     * - "black"
     */
    public void changePaint(String paint) {
        this.paint = paint;
        this.draw();
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw() {
        if (this.isVisible) {
            Polygon canvas = Polygon.getPolygon();
            canvas.draw(this, this.paint, new Ellipse2D.Double(this.leftTopX, this.leftTopY,
                    this.average, this.average));
            canvas.wait(10);
        }
    }

    /**
     * Erase the circle on screen.
     */
    private void deleteCircle() {
        if (this.isVisible) {
            Polygon canvas = Polygon.getPolygon();
            canvas.erase(this);
        }
    }
}

