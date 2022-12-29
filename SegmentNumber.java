public class SegmentNumber {
    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;

    public SegmentNumber(int x, int y) {
        this.segmentA = new Segment(30, 5, x + 5, y);
        this.segmentB = new Segment(5, 30, x + 35, y + 5);
        this.segmentC = new Segment(5, 30, x + 35, y + 40);
        this.segmentD = new Segment(30, 5, x + 5, y + 70);
        this.segmentE = new Segment(5, 30, x, y + 40);
        this.segmentF = new Segment(5, 30, x, y + 5);
        this.segmentG = new Segment(30, 5, x + 5, y + 35);
    }

    public void setValue(int n) {
        switch (n) {
            case 0 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOn();
                this.segmentF.turnOn();
                this.segmentG.turnOff();
            }
            case 1 -> {
                this.segmentA.turnOff();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOff();
                this.segmentE.turnOff();
                this.segmentF.turnOff();
                this.segmentG.turnOff();
            }
            case 2 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOff();
                this.segmentD.turnOn();
                this.segmentE.turnOn();
                this.segmentF.turnOff();
                this.segmentG.turnOn();
            }
            case 3 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOff();
                this.segmentF.turnOff();
                this.segmentG.turnOn();
            }
            case 4 -> {
                this.segmentA.turnOff();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOff();
                this.segmentE.turnOff();
                this.segmentF.turnOn();
                this.segmentG.turnOn();
            }
            case 5 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOff();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOff();
                this.segmentF.turnOn();
                this.segmentG.turnOn();
            }
            case 6 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOff();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOn();
                this.segmentF.turnOn();
                this.segmentG.turnOn();
            }
            case 7 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOff();
                this.segmentE.turnOff();
                this.segmentF.turnOff();
                this.segmentG.turnOff();
            }
            case 8 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOn();
                this.segmentF.turnOn();
                this.segmentG.turnOn();
            }
            case 9 -> {
                this.segmentA.turnOn();
                this.segmentB.turnOn();
                this.segmentC.turnOn();
                this.segmentD.turnOn();
                this.segmentE.turnOff();
                this.segmentF.turnOn();
                this.segmentG.turnOn();
            }
        }
    }
}
