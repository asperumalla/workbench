package com.chapter;

class Shipment{
    int deliveryDate;
}


public class RemoveFlagArgument {
    public static void main (String[] args) {

    }


    public void caller1(Order order){
        Shipment shipment = new Shipment();
        shipment.deliveryDate =  devliveryDate(order, true);
    }

    public void caller2(Order order){
        Shipment shipment = new Shipment();
        shipment.deliveryDate =  devliveryDate(order, false);
    }

    public int devliveryDate(Order order, boolean isRush){

        if(isRush){
            System.out.println( "Express Delivery: To be delivered in 2 Days" );
            return 2;
        }else{
            System.out.println("Regular Delivery: To be delivered in 5 Days");
            return 5;
        }

    }

}

// In the above case the caller is using a literal boolean to determine whih code to run
// The whole point of using funtion is to follow callers instruction, so it is better to share the
// caller with explicit functions there by decomposing the logic into functions



class Refactor{





    public void caller1(Order order){
        Shipment shipment = new Shipment();
        shipment.deliveryDate =  rushDelivery(order);
    }

    public void caller2(Order order){
        Shipment shipment = new Shipment();
        shipment.deliveryDate =  regularDelivery(order);
    }

    public int rushDelivery(Order order){
        System.out.println( "Express Delivery: To be delivered in 2 Days" );
        return 2;
    }

    public int regularDelivery(Order order){
        System.out.println("Regular Delivery: To be delivered in 5 Days");
        return 5;
    }



    public int devliveryDate(Order order, boolean isRush){

        if(isRush){
            rushDelivery(order);
        }else{
            regularDelivery(order);
        }

    }








    public boolean determineIfRush(Order order){ return true;}






    // Consider the below case:

    public void caller1(Order order, Shipment shipment){
        var isRush = determineIfRush(order) ;
        shipment.deliveryDate = deliveryDate(order, isRush) ;
    }


}








// What if the isRush is tangled

        public int deliveryDate(anOrder, isRush) {
            int result;
            int deliveryTime;

            if (anOrder.deliveryState === "MA" || anOrder.deliveryState === "CT")
                deliveryTime = isRush? 1 : 2;

            else if (anOrder.deliveryState === "NY" || anOrder.deliveryState === "NH") {
                deliveryTime = 2;

            if (anOrder.deliveryState === "NH" && !isRush)
                deliveryTime = 3;
            }

            else if (isRush)
                deliveryTime = 3;

            else if (anOrder.deliveryState === "ME")
                deliveryTime = 3;

            else
                deliveryTime = 4;

            result = anOrder.placedOn.plusDays(2 + deliveryTime);

            if (isRush){
                result=result.minusDays(1);
            }

            return result;
        }


        ////TransformInto

    public int rushDelivery(Order order){ return deliveryDate(order, true);}

    public int regularDelivery(Order order){
        return deliveryDate(order, false);
    }
