abstract class Table {

    double STDSIZE =  9600;
    double STDPRICE = 42500;
    int numberOfDrawers = 0;
    double PriceInKsh = 42500;
    double lengthInCm = 80;
    double widthInCm = 120;

    double tableArea;

    public Table() {

    }

    public int getNumberOfDrawers() {
        return numberOfDrawers;
    }

    abstract double getPriceInKsh();

    public double getLengthInCm() {
        return lengthInCm;
    }

    public double getWidthInCm() {
        return widthInCm;
    }

    public double getTableArea() {
        return tableArea;
    }

    public Table(int numberOfDrawers, double lengthInCm, double widthInCm) {
        if (numberOfDrawers < 0 || numberOfDrawers > 6) {
            System.out.println("Invalid number of drawers! Must be between 0 and 6");
        } else {
            this.numberOfDrawers = numberOfDrawers;
        }
        this.lengthInCm = lengthInCm;
        this.widthInCm = widthInCm;
    }

    public void Area() {
        tableArea = lengthInCm * widthInCm;
    }
}
