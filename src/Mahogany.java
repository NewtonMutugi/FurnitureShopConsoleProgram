public class Mahogany extends Table {
    final double MAHPRICE = 3000;
   public Mahogany() {
        super();
    }
    @Override
    double getPriceInKsh() {
        if(area() > STDSIZE){
            PriceInKsh = (((area()-STDSIZE)*825)  + drawerPrice() + STDPRICE+MAHPRICE) * discount();
            
        }
        return PriceInKsh;
    }
}
