public class Oak extends  Table {
    final double OAKPRICE = 2015;


    public Oak() {
        super();
    }

    @Override
    double getPriceInKsh() {
        do {
            area();
//            drawerPrice();
//            discount();
            if (tableArea < STDSIZE) {
                System.out.println("The area is less than the standard size");
            } else {
                PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE+OAKPRICE) * discount();

            }
        } while (tableArea < STDSIZE);

        return PriceInKsh;

    }

}

