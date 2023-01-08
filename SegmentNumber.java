public class SegmentNumber {
    private final Segment firstSegment;
    private final Segment secondSegment;
    private final Segment thirdSegment;
    private final Segment fourthSegment;
    private final Segment fifthSegment;
    private final Segment sixthSegment;
    private final Segment seventhSegment;

    public SegmentNumber(int x, int y) {
        this.firstSegment = new Segment(30, 5, x + 5, y);
        this.secondSegment = new Segment(5, 30, x + 35, y + 5);
        this.thirdSegment = new Segment(5, 30, x + 35, y + 40);
        this.fourthSegment = new Segment(30, 5, x + 5, y + 70);
        this.fifthSegment = new Segment(5, 30, x, y + 40);
        this.sixthSegment = new Segment(5, 30, x, y + 5);
        this.seventhSegment = new Segment(30, 5, x + 5, y + 35);
    }

    public void setValue(int n) {
        if (n == 0) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOn();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOff();
        } else if (n == 1) {
            this.firstSegment.turnOff();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOff();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOff();
            this.seventhSegment.turnOff();

        } else if (n == 2) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOff();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOn();
            this.sixthSegment.turnOff();
            this.seventhSegment.turnOn();

        } else if (n == 3) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOff();
            this.seventhSegment.turnOn();

        } else if (n == 4) {
            this.firstSegment.turnOff();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOff();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOn();

        } else if (n == 5) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOff();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOn();

        } else if (n == 6) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOff();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOn();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOn();

        } else if (n == 7) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOff();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOff();
            this.seventhSegment.turnOff();

        } else if (n == 8) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOn();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOn();

        } else if (n == 9) {
            this.firstSegment.turnOn();
            this.secondSegment.turnOn();
            this.thirdSegment.turnOn();
            this.fourthSegment.turnOn();
            this.fifthSegment.turnOff();
            this.sixthSegment.turnOn();
            this.seventhSegment.turnOn();
        }
    }
}

