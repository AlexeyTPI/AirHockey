import java.util.LinkedList;
import java.util.List;

public class SegmentNumber {

    private final List<Segment> segmentArray = new LinkedList<>();

    public SegmentNumber(int x, int y) {
        Segment aSegment = new Segment(30, 5, x + 5, y);
        segmentArray.add(aSegment);
        Segment bSegment = new Segment(5, 30, x + 35, y + 5);
        segmentArray.add(bSegment);
        Segment cSegment = new Segment(5, 30, x + 35, y + 40);
        segmentArray.add(cSegment);
        Segment dSegment = new Segment(30, 5, x + 5, y + 70);
        segmentArray.add(dSegment);
        Segment eSegment = new Segment(5, 30, x, y + 40);
        segmentArray.add(eSegment);
        Segment fSegment = new Segment(5, 30, x, y + 5);
        segmentArray.add(fSegment);
        Segment gSegment = new Segment(30, 5, x + 5, y + 35);
        segmentArray.add(gSegment);
    }

    public void setValue(int n) {
        switch (n) {
            case 0: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i != 7) {
                        segmentArray.get(i).turnOn();
                    }
                    segmentArray.get(i).turnOff();
                }
            }
            case 1: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 0 || i > 2) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 2: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 2 || i == 5) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 3: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 4 || i == 5) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 4: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 0 || i == 3 || i == 4) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 5: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 1 || i == 4) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 6: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i == 1) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 7: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i > 2) {
                        segmentArray.get(i).turnOff();
                    } else {
                        segmentArray.get(i).turnOn();
                    }
                }
            }
            case 8: {
                for (Segment segment : segmentArray) {
                    segment.turnOn();
                }
            }
            case 9: {
                for (int i = 0; i < segmentArray.size(); i++) {
                    if (i != 4) {
                        segmentArray.get(i).turnOn();
                    } else {
                        segmentArray.get(i).turnOff();
                    }
                }
            }
        }
    }
}
