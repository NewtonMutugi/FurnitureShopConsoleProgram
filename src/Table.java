import java.util.Scanner;

abstract class Table {

    double STDSIZE =  9600;
    double STDPRICE = 42500;
    int numberOfDrawers;
    double PriceInKsh = 42500;
    double lengthInCm;
    double widthInCm;
    int numOfTables;

    double tableArea;

    public int getNumOfTables() {
        return numOfTables;
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

    Scanner inputs = new Scanner(System.in);


    public Table(int numberOfDrawers, double lengthInCm, double widthInCm) {

        this.numberOfDrawers = numberOfDrawers;
        this.lengthInCm = lengthInCm;
        this.widthInCm = widthInCm;
    }

    public Table() {

        int numberOfDrawers1 = this.numberOfDrawers;
        double lengthInCm1 = this.lengthInCm;
        double widthInCm1 = this.widthInCm;
    }
    public double area() {
        System.out.println("Enter the width of your table:");
        widthInCm = inputs.nextDouble();
        System.out.println("Enter the length of your table:");
        lengthInCm = inputs.nextDouble();
        tableArea = lengthInCm * widthInCm;
        return tableArea;
    }
    public double drawerPrice(){

        System.out.println("Enter number of Drawers:");
        numberOfDrawers = inputs.nextInt();
        if (numberOfDrawers < 0 || numberOfDrawers > 6) {
            System.out.println("Invalid number of drawers! Must be between 0 and 6");
            System.out.println("Enter number of Drawers:");
            numberOfDrawers = inputs.nextInt();

        } else if (numberOfDrawers == 1) {
            return 2500;


        }else{
            return 2500 + ((numberOfDrawers-1)*2000);
        }
        return ((numberOfDrawers-1)*2000)+2500;
    }
    public double discount(){

        double discount = 0.0;
        System.out.println("Enter number of Tables:");
        numOfTables = inputs.nextInt();
        if(numOfTables == 0 || numOfTables < 0){
            System.out.println("Enter at least one table");
        }
        if(numOfTables > 1){
            discount = 0.95;
        }
        return discount;
    }

    //abstract public double woodPrice();


    }
