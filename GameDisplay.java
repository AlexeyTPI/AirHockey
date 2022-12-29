public class GameDisplay {
    private int upperLimit;
    private int value;

    public GameDisplay() {
        this.upperLimit = upperLimit;
        this.value = 0;
    }

    public void setValue(int value) {
        if (value >= 0) {
            if (value < this.upperLimit) {
                this.value = value;
            }
        }
        return;
    }
}