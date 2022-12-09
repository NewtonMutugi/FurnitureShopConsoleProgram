public class Pine extends Table {
    public Pine() {
        super();
    }

    @Override
    double getPriceInKsh() {
        do {
            area();
//            drawerPrice();
//            discount();
            if (tableArea < STDSIZE) {
                System.out.println("The area is less than the standard size.  Width must be greater than 80cm and length must be greater than 120cm");
            } else {
                PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE) * discount();

            }
        } while (tableArea < STDSIZE);
        return PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE) * discount();
    }

}
