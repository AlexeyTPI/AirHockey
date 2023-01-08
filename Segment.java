
public class Segment {
    private final CustomRectangle customRectangle;

    public Segment(int width, int height, int x, int y) {
        this.customRectangle = new CustomRectangle();
        this.customRectangle.changeSide(width, height);
        this.customRectangle.moveHorizontal(x);
        this.customRectangle.moveVertical(y);
        this.customRectangle.show();
    }

    public void turnOn() {
        this.customRectangle.show();
    }

    public void turnOff() {
        this.customRectangle.hide();
    }
}

