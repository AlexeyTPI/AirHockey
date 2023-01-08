/**
Bat is a controller to hit the puck
 */
public class Bat {
    /**
     * Constructor for objects of class Bat
     */
    private final CustomRectangle rectangle;
    private int positionY;

    public Bat(boolean isRight) {
        this.positionY = Polygon.heightPolygon / 2;
        this.rectangle = new CustomRectangle();
        this.rectangle.changeColor("black");
        this.rectangle.changeSide(10, 50);
        this.rectangle.moveVertical(Polygon.heightPolygon / 2 - 25 - 50 - 50);
        if (isRight) {
            this.rectangle.moveHorizontal(Polygon.widthPolygon - 10 - 60);

        } else {
            this.rectangle.moveHorizontal(-60);
        }
        this.rectangle.show();
    }
    /**
     Bat moves up
     */
    public void moveUp() {
        if (this.positionY > 25 + 50) {
            this.rectangle.moveVertical(-5);
            this.positionY -= 5;
        }
    }
    /**
     Bat moves down
     */
    public void moveDown() {
        if (this.positionY < Polygon.heightPolygon - 100 - 25 + 50) {
            this.rectangle.moveVertical(5);
            this.positionY += 5;
        }
    }
    /**
     Bat hits the puck
     */
    public boolean hit(int x, int y) {
        if (x <= 10 || x >= Polygon.widthPolygon - 10) {
            return y <= this.positionY + 20 - 50 && y >= this.positionY + 3 - 50
                    || this.positionY - 20 - 50 <= y && this.positionY - 3 - 50 >= y;
        }
        return false;
    }
    /**
     Bat hits the side
     */
    public boolean hitSide(int x, int y) {
        if (x <= 10 || x >= Polygon.widthPolygon - 10) {
            return y >= this.positionY - 25 - 50 && y <= this.positionY - 21 - 50
                    || y <= this.positionY + 25 - 50 && y >= this.positionY + 21 - 50;
        }
        return false;
    }

    /**
     Bat hits center
     */
    public boolean hitCenter(int x, int y) {
        if (x <= 10 || x >= Polygon.widthPolygon - 10) {
            return this.positionY - 3 - 50 <= y && y <= this.positionY + 3 - 50;
        }
        return false;
    }
    /**
     Bat hits the flank
     */
    public boolean hitFlank(int x, int y) {
        if (x <= 10 && x > 0 || x > Polygon.widthPolygon - 10 && x <= Polygon.widthPolygon) {
            return y == this.positionY + 25 - 50 || y == this.positionY - 25 - 50;
        }
        return false;
    }

}
