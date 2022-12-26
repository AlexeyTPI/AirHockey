import java.awt.Rectangle;

/**
 * Rectangle with wich you can move and you can see it on the poligon.
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
    public void display() {
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
     * (Rectangle) Move Horizontally according to the parameter.
     */
    public void moveVertical(int distance) {
        this.delete();
        this.leftTopY += distance;
        this.draw();
    }

    /**
     * (Obdĺžnik) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
     */
    public void pomalyPosunVodorovne(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else  {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.leftTopX += delta;
            this.draw();
        }
    }

    /**
     * (Obdĺžnik) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
     */
    public void pomalyPosunZvisle(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.leftTopY += delta;
            this.draw();
        }
    }

    /**
     * (Obdĺžnik) Zmeň dĺžky strán na hodnoty dané parametrami.
     * Dĺžka strany musí byť nezáporné celé číslo.
     */
    public void zmenStrany(int stranaA, int stranaB) {
        this.delete();
        this.sideA = stranaA;
        this.sideB = stranaB;
        this.draw();
    }

    /**
     * (Obdĺžnik) Zmeň farbu na hodnotu danú parametrom.
     * Nazov farby musí byť po anglicky.
     * Možné farby sú tieto:
     * červená - "red"
     * žltá    - "yellow"
     * modrá   - "blue"
     * zelená  - "green"
     * fialová - "magenta"
     * čierna  - "black"
     * biela   - "white"
     * hnedá   - "brown"
     */
    public void zmenFarbu(String farba) {
        this.color = farba;
        this.draw();
    }

    /*
     * Draw the square with current specifications on screen.
     */
    private void draw() {
        if (this.isVisible) {
            Platno canvas = Platno.dajPlatno();
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
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
}
