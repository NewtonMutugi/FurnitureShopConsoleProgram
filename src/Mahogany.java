public class Mahogany extends Table {
    final double MAHPRICE = 3000;
   public Mahogany() {
        super();
    }
    @Override
    double getPriceInKsh() {
        do {
            area();
            if (tableArea < STDSIZE) {
                System.out.println("The area is less than the standard size");
            } else {
                PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE+MAHPRICE) * discount();

            }
        } while (tableArea < STDSIZE);
        return PriceInKsh;
    }
}
