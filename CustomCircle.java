    import java.awt.geom.Ellipse2D;

    public class CustomCircle{
        private int avarage;
        private int leftTopX;
        private int leftTopY;
        private String paint;
        private boolean isVisible;

        /**
         *  Create a new circle of a predefined color at a predefined position.
         */
        public CustomCircle() {
            this.avarage = 30;
            this.leftTopX = 20;
            this.leftTopY = 60;
            this.paint = "green";
            this.isVisible = false;
        }

        /**
         * (CustomCircle) create yourself.
         */
        public void create() {
            this.isVisible = true;
            this.create();
        }

        /**
         * (CustomCircle) delete yourself.
         */
        public void delete() {
            this.delete();
            this.isVisible = false;
        }

        /**
         * (CustomCircle) Shift right on the sertain distance.
         */
        public void moveRight() {
            this.shiftVertically(20);
        }

        /**
         *  (CustomCircle) Shift left on the sertain distance.
         */
        public void posunVlavo() {
            this.shiftVertically(-20);
        }

        /**
         *  (CustomCircle) Shift up on the sertain distance.
         */
        public void posunHore() {
            this.moveHorizontally(-20);
        }

        /**
         *  (CustomCircle) Shift down on the sertain distance.
         */
        public void posunDole() {
            this.shiftVertically(20);
        }

        /**
         * (CustomCircle) Shift horizontally on the sertain distance.
         */
        public void moveHorizontally (int distance) {
            this.zmaz();
            this.leftTopX += distance;
            this.create();
        }

        /**
         * (CustomCircle) Shift vertically on the sertain distance.
         */
        public void shiftVertically (int distance) {
            this.zmaz();
            this.leftTopY += distance;
            this.create();
        }

        /**
         * (CustomCircle) Shift slowly horizontally by the length given by the parameter.
         */
        public void slowlyMoveHorizontal (int distance) {
            int delta;

            if (distance < 0) {
                delta = -1;
                distance = -distance;
            } else {
                delta = 1;
            }

            for (int i = 0; i < distance; i++) {
                this.leftTopX += delta;
                this.create();
            }
        }

        /**
         * (CustomCircle) Move slowly vertically by the length given by the parameter.
         */
        public void slowlyMoveVertically (int distance) {
            int delta;

            if (distance < 0) {
                delta = -1;
                distance = -distance;
            } else {
                delta = 1;
            }

            for (int i = 0; i < distance; i++) {
                this.leftTopY += delta;
                this.create();
            }
        }

        /**
         * (Kruh) Zmeň priemer na hodnotu danú parametrom.
         * Priemer musí byť nezáporné celé číslo.
         */
        public void zmenPriemer(int priemer) {
            this.zmaz();
            this.avarage = priemer;
            this.nakresli();
        }

        /**
         * (Kruh) Zmeň farbu na hodnotu danú parametrom.
         * Nazov farby musí byť po anglicky.
         * Možné farby sú tieto:
         * červená - "red"
         * žltá    - "yellow"
         * modrá   - "blue"
         * zelená  - "green"
         * fialová - "magenta"
         * čierna  - "black"
         */
        public void zmenFarbu(String farba) {
            this.paint = farba;
            this.nakresli();
        }

        /*
         * Draw the circle with current specifications on screen.
         */
        private void nakresli() {
            if (this.isVisible) {
                Poligon canvas = Poligon.getPoligon();
                canvas.draw(this, this.paint, new Ellipse2D.Double(this.leftTopX, this.leftTopY,
                        this.avarage, this.avarage));
                canvas.wait(10);
            }
        }

        /*
         * Erase the circle on screen.
         */
        private void zmaz() {
            https://auto.bazos.sk/inzerat/145828911/bmw-e46-330d-135kw-touring-topas-blau.php
            if (this.isVisible) {
                Poligon canvas = Poligon.getPoligon();
                canvas.erase(this);
            }
        }
    }

