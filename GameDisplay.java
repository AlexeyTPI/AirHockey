


/**
 * Class represents one numeric display in a digital clock.
 * Takes care of changing the value within the specified limits and formatting
 * a number into a two-digit value.
 */
public class GameDisplay {
    private final int upperLimit;
    private int value;

    private final SegmentNumber tenth;
    private final SegmentNumber one;
    private final SegmentNumber hundreds;


    /**
     * Initializes the numeric display to 0. The upper limit is used
     * the one entered by the user in the parameter.
     *
     * @param upperLimit Represents the number that the value of the numeric
     * @param x Represents the way by X;
     * @param y Represents the way by Y;
     * cannot reach the display.
     */
    public GameDisplay(int upperLimit, int x, int y) {
        this.upperLimit = upperLimit;
        this.value = 0;
        this.tenth = new SegmentNumber(x, y);
        this.one = new SegmentNumber(x + 45, y);
        this.hundreds = new SegmentNumber(x - 45, y);
    }


    /**
     * Sets the new value of the numeric display in the form of an integer of type int.
     * Checks the validity of the entered number. If it is out of range,
     * leaves the flood value.
     *
     *
     * @param value to be set.
     */
    public void setValue(int value) {
        if (value >= 0) {
            if (value < this.upperLimit) {
                this.value = value;
                this.hundreds.setValue(this.value / 10);
                this.tenth.setValue(this.value / 10);
                this.one.setValue(this.value % 10);
            }
        }
    }
}