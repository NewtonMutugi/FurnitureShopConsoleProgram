public class Pine extends Table{
   public  Pine(){
       super();
    }
    @Override
   double getPriceInKsh() {
       if(area() > STDSIZE){
            PriceInKsh = (((area()-STDSIZE)*825)  + drawerPrice() + STDPRICE) * discount();

        }
        return PriceInKsh;
    }

}
