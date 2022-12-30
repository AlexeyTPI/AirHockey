
/**
 * Trieda reprezentujuca jeden ciselny displej v digitalnych hodinach.
 * Stara sa o zmenu hodnoty v zadanych hraniciach a o formatovanie
 * cisla do tvaru dvojcifernej hodnoty.
 */
public class GameDisplay {
    private int upperLimit;
    private int value;

    private SegmentNumber tenth;
    private SegmentNumber one;
    private SegmentNumber hundreds;


    /**
     * Inicializuje ciselny displej na hodnotu 0. Horna hranica sa pouzije
     * ta, co zada pouzivatel v parametri.
     *
     * @param upperLimit Predstavuje cislo, ktore hodnota ciselneho
     *                   displeja nemoze dosiahnut.
     */
    public GameDisplay(int upperLimit, int x, int y) {
        this.upperLimit = upperLimit;
        this.value = 0;
        this.tenth = new SegmentNumber(x, y);
        this.one = new SegmentNumber(x + 45, y);
        this.hundreds = new SegmentNumber(x - 45, y);
    }


    /**
     * Vrati aktualnu hodnotu ciselneho displeja vo forme celeho cisla typu
     * int.
     */
    public int getValue() {
        return this.value;
    }


    /**
     * Nastavi novu hodnotu ciselneho displeja vo forme celeho cisla typu int.
     * Kontroluje platnost zadavaneho cisla. V pripade, ze je mimo rozsah,
     * nechava povodnu hodnotu.
     *
     * @param value hodnota, ktora sa ma nastavit.
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

    /**
     * Vrati hodnotu ciselneho displeja vo forme retazca, pricom hodnota je
     * vzdy vo forme dvojciferneho cisla s pripadnou uvodnou nulou.
     */
    public String getValueSeverally() {
        if (this.value < 10) {
            return "0" + this.value;
        } else {
            return "" + this.value;
        }
    }

    /**
     * Zvacsi hodnotu na ciselnom displeji o hodnotu jedna. Ak dosiahne hornu
     * hranicu, pokracuje znovu od nuly.
     */
    public void step() {
        this.value = (this.value + 1)
                % this.upperLimit;
        this.hundreds.setValue(this.value / 10);
        this.tenth.setValue(this.value % 10);
        this.one.setValue(this.value % 10);

    }

    public int changeMaximum(int max) {
        this.upperLimit = max;
        return this.upperLimit;
    }

}
