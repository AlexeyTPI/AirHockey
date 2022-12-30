
/**
 * Write a description of class Puck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Puck {
    private static final int RADIUS = 10;
    private Bat bat;
    private AirHockey airHockey;
    private CustomCircle circle;
    private int positionX;
    private int positionY;
    private int sizeMoveX = 10;
    private int sizeMoveY = 8;
    private int moveX;
    private int moveY;
    public int a = 0;
    public int b = 0;

    /**
     * Posuny( pozícia - POLOMER - povodnaPoziciaKruhu)
     */
    public Puck() {
        this.positionX = Polygon.widthPolygon / 2;
        this.positionY = Polygon.heightPolygon / 2 - 50;

        this.moveX = sizeMoveX;
        this.moveY = sizeMoveY;

        this.circle = new CustomCircle();
        this.circle.changePaint("red");
        this.circle.changeNumber(RADIUS * 2);
        this.circle.moveHorizontally(this.positionX - RADIUS - 20);
        this.circle.moveVertically(this.positionY - RADIUS - 60);
        this.circle.show();
    }

    private void reset() {
        this.circle.moveHorizontally(Polygon.widthPolygon / 2 - this.positionX);
        this.positionX = Polygon.widthPolygon / 2;
        this.moveX = -this.moveX;
    }


    public void move(Bat batLeft, Bat batRight) {
        if (batLeft.hitFlank(this.positionX - RADIUS, this.positionY)) {
            if (this.positionX < Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX / 3;
                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY * 2;
                } else {
                    this.moveY = -this.sizeMoveY * 2;
                }
            }
        }

        if (batLeft.hitSide(this.positionX - RADIUS, this.positionY)) {
            if (this.positionX < Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX / 3;
                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY * 2;
                } else {
                    this.moveY = -this.sizeMoveY * 2;
                }
            }
        }

        if (batLeft.hitCenter(this.positionX - RADIUS, this.positionY)) {
            if (this.positionX < Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX;
                this.moveY = 0;
            }
        }

        if (batLeft.hit(this.positionX - RADIUS, this.positionY)) {
            if (this.positionX < Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX;
                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY;
                } else {
                    this.moveY = -this.sizeMoveY;
                }
            }
        }


        if (batRight.hitFlank(this.positionX + RADIUS, this.positionY)) {
            if (this.positionX > Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX / 3;
                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY * 2;

                } else {
                    this.moveY = -this.sizeMoveY * 2;
                }
            }
        }

        if (batRight.hitSide(this.positionX + RADIUS, this.positionY)) {
            if (this.positionX > Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX / 3;

                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY * 2;

                } else {
                    this.moveY = -this.sizeMoveY * 2;
                }
            }
        }

        if (batRight.hitCenter(this.positionX + RADIUS, this.positionY)) {
            if (this.positionX > Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX;
                this.moveY = 0;

            }
        }

        if (batRight.hit(this.positionX + RADIUS, this.positionY)) {
            if (this.positionX > Polygon.widthPolygon / 2) {
                this.moveX = -this.moveX;
                if (this.moveY > 0) {
                    this.moveY = this.sizeMoveY;
                } else {
                    this.moveY = -this.sizeMoveY;
                }
            }
        }

        if (this.positionX - RADIUS >= Polygon.widthPolygon) {
            this.a++;
            this.reset();
        }

        if (this.positionX + RADIUS <= 0) {
            this.b++;
            this.reset();
        }

        if (this.positionY + RADIUS >= Polygon.heightPolygon - 100) {
            this.moveY = this.moveY * -1;
        }

        if (this.positionY - RADIUS <= 0) {
            this.moveY = this.moveY * -1;
        }

        this.positionX += this.moveX;
        this.positionY += this.moveY;


        this.circle.moveHorizontally(this.moveX);
        this.circle.moveVertically(this.moveY);

    }
}
