import java.awt.*;

public class Bat {
    /**
     * Constructor for objects of class Bat
     */
            private Rectangle rectangle;
            private int positionY;


    public Bat() {
        // initialise instance variables
                this.positionY = Poligon.heightPoligon / 2;
                this.rectangle = new Rectangle;
                this.rectangle.changeColur("black");
                this.rectangle.changeSide(10 , 50);
                this.rectangle.moveVertical(Poligon.heightPoligon / 2 - 25 - 50 - 50);
                if (isRight) {
                    this.rectangle.moveHorizontal(Poligon.widthPoligon - 10 - 60);

                } else {
                    this.rectangle.moveHorizontal(-60);
                }
                this.rectangle.create();
            }

            public void posunHore() {

                if (this.positionY > 25 + 50) {
                    this.rectangle.moveVertical(-5);
                    this.positionY -= 5;

                }
            }

            public void posunDole() {
                if (this.positionY < Poligon.heightPoligon - 100 - 25 + 50) {
                    this.rectangle.moveVertical(5);
                    this.positionY += 5;
                }
            }

            public boolean koliduje(int x, int y) {

                if (x <= 10 || x >= Poligon.widthPoligon - 10) {
                    if (y <= this.positionY + 20 - 50 &&  y >= this.positionY + 3 - 50 || this.positionY - 20 - 50 <= y && this.positionY - 3 - 50 >= y) {
                        return true;
                    }
                }

                return false;
            }

            public boolean kolidujeNaStranach(int x, int y) {

                if (x <= 10 || x >= Poligon.widthPoligon - 10) {
                    if ( y >= this.positionY - 25 - 50 && y <= this.positionY - 21 - 50  || y <= this.positionY + 25 - 50 &&  y >= this.positionY + 21 - 50) {
                        return true;
                    }
                }

                return false;
            }


            public boolean kolidujeVstrede(int x, int y) {

                if (x <= 10 || x >= Poligon.widthPoligon - 10) {
                    if (this.positionY - 3 - 50 <= y && y <= this.positionY + 3 - 50) {
                        return true;
                    }
                }

                return false;
            }

            public boolean kolidujeNaBokoch(int x, int y) {

                if (x <= 10 && x > 0 || x > Poligon.widthPoligon- 10 && x <= Poligon.widthPoligon) {
                    if ( y == this.positionY + 25 - 50 || y == this.positionY - 25 - 50) {
                        return true;
                    }
                }

                return false;
            }




        }
