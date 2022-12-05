public class Pine extends Table {
    public Pine() {
        super();
    }

    @Override
    double getPriceInKsh() {
        do {
            area();
            if (tableArea < STDSIZE) {
                System.out.println("The area is less than the standard size");
            } else {
                PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE) * discount();

            }
        } while (tableArea < STDSIZE);
        return PriceInKsh = (((tableArea - STDSIZE) * 825) + drawerPrice() + STDPRICE) * discount();
    }

}
