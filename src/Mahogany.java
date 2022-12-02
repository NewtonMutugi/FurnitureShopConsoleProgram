public class Mahogany extends Table {
    final double MAHPRICE = 3000;
    public Mahogany(int numberOfDrawers, double lengthInCm, double widthInCm) {
        super(numberOfDrawers, lengthInCm, widthInCm);
    }
    @Override
    double getPriceInKsh() {
        if(tableArea > STDSIZE){
            PriceInKsh = ((tableArea-STDSIZE)*825) + STDPRICE+MAHPRICE;
        }
        return PriceInKsh;
    }
}
