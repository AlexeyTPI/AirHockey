

public class Bat {
    /**
     * Constructor for objects of class Bat
     */
    private CustomRectangle rectangle;
    private int positionY;

    public Bat(boolean isRight) {
        this.positionY = Poligon.heightPoligon / 2;
        this.rectangle = new CustomRectangle();
        this.rectangle.changeColor("black");
        this.rectangle.changeSide(10, 50);
        this.rectangle.moveVertical(Poligon.heightPoligon / 2 - 25 - 50 - 50);
        if (isRight) {
            this.rectangle.moveHorizontal(Poligon.widthPoligon - 10 - 60);

        } else {
            this.rectangle.moveHorizontal(-60);
        }
        this.rectangle.show();
    }

    public void moveUp() {
        if (this.positionY > 25 + 50) {
            this.rectangle.moveVertical(-5);
            this.positionY -= 5;
        }
    }

    public void moveDown() {
        if (this.positionY < Poligon.heightPoligon - 100 - 25 + 50) {
            this.rectangle.moveVertical(5);
            this.positionY += 5;
        }
    }

    public boolean hit(int x, int y) {
        if (x <= 10 || x >= Poligon.widthPoligon - 10) {
            return y <= this.positionY + 20 - 50 && y >= this.positionY + 3 - 50
                    || this.positionY - 20 - 50 <= y && this.positionY - 3 - 50 >= y;
        }
        return false;
    }

    public boolean hitSide(int x, int y) {
        if (x <= 10 || x >= Poligon.widthPoligon - 10) {
            return y >= this.positionY - 25 - 50 && y <= this.positionY - 21 - 50
                    || y <= this.positionY + 25 - 50 && y >= this.positionY + 21 - 50;
        }
        return false;
    }


    public boolean hitCenter(int x, int y) {
        if (x <= 10 || x >= Poligon.widthPoligon - 10) {
            return this.positionY - 3 - 50 <= y && y <= this.positionY + 3 - 50;
        }
        return false;
    }

    public boolean hitFlank(int x, int y) {
        if (x <= 10 && x > 0 || x > Poligon.widthPoligon - 10 && x <= Poligon.widthPoligon) {
            return y == this.positionY + 25 - 50 || y == this.positionY - 25 - 50;
        }
        return false;
    }

}
