public class Oak extends  Table {
    final double OAKPRICE = 2015;
////

    public Oak() {
    }

    @Override
    double getPriceInKsh() {
        if(area() > STDSIZE){
            PriceInKsh = (((area()-STDSIZE)*825)  + drawerPrice() + STDPRICE+OAKPRICE) * discount();
       }

        return PriceInKsh;

    }

}

