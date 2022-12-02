public class Oak extends  Table {
    final double OAKPRICE = 5000;
    public Oak(int numberOfDrawers, double lengthInCm, double widthInCm) {
        super(numberOfDrawers, lengthInCm, widthInCm);
    }
    @Override
    double getPriceInKsh() {
        if(tableArea > STDSIZE){
            PriceInKsh = ((tableArea-STDSIZE)*825) + STDPRICE+OAKPRICE;
        }
        return PriceInKsh;
    }
}

