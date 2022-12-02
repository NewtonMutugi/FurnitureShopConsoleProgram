public class Pine extends Table{
    public Pine(int numberOfDrawers, double lengthInCm, double widthInCm) {
        super(numberOfDrawers, lengthInCm, widthInCm);
    }
    @Override
    double getPriceInKsh() {
        if(tableArea > STDSIZE){
            PriceInKsh = ((tableArea-STDSIZE)*825) + STDPRICE;
        }
        return PriceInKsh;
    }

}
