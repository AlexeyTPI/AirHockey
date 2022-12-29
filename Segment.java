import java.awt.*;

public class Segment {
    private  CustomRectangle;
    public Segment(int width, int height, int x, int y) {
        this.rectangle = new Rectangle();
        this.rectangle.changeSide(width, height);
        this.rectangle.shiftHorizontal(x);
        this.rectangle.shiftVertically(y);
        this.rectangle.create();
    }

    public void zapni() {
        this.rectangle.create();
    }

    public void vypni() {
        this.rectangle.disappear();

    }
}

