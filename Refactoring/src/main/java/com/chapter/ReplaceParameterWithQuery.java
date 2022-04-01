package  com.chapter;

import java.util.function.Supplier;

public class ReplaceParameterWithQuery {

    public static void main (String[] args) {
        Order order = new Order(2,25.99f);
        System.out.println( order.finalPrice() );
    }
}

class Order{

    private int quantity;
    private float itemPrice;

    public Order(int quantity, float itemPrice){
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public  float finalPrice () {
        final var basePrice = this.quantity * this.itemPrice;
        int  discountLevel = 0 ;

        if (this.quantity > 100){
            discountLevel = 2 ;
        }
        else discountLevel = 1 ;

        return this.discountedPrice(basePrice, discountLevel) ;
    }

    private float discountedPrice(float basePrice, int discountLevel) {
        switch (discountLevel) {
            case 1: return basePrice * 0.95f;
            case 2: return basePrice * 0.9f;
            default: return basePrice;
        }
    }
}

















// Refactoring in progress

class Order{

    private int quantity;
    private float itemPrice;

    public Order(int quantity, float itemPrice){
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public  float finalPrice () {
        final var basePrice = this.quantity * this.itemPrice;

        //STEP.2 rename the parameter with the function/method
        return this.discountedPrice(basePrice, this.discountLevel ) ;
    }

   // final private Supplier<Integer> discountLevel = () -> this.quantity > 100 ? 1 : 2;

    //STEP.2 rename the parameter with the function/method
    private float discountedPrice(float basePrice, int discountLevel ) {

        //STEP.2 Pass/Call the function/method
        switch (  this.discountLevel() ) {
            case 1: return basePrice * 0.95f;
            case 2: return basePrice * 0.9f;
            default: return basePrice;
        }
    }

    //STEP.1 Extract the discount code
    private int discountLevel(){
        return this.quantity>100 ? 2:1;
    }
}



















// Final Output
class Order{

    private int quantity;
    private float itemPrice;

    public Order(int quantity, float itemPrice){
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public  float finalPrice () {
        final var basePrice = this.quantity * this.itemPrice ;
        //STEP.1 remove the parameter
        //return this.discountedPrice(basePrice, this.discountLevel ) ;
        return this.discountedPrice(basePrice) ;
    }

   // final private Supplier<Integer> discountLevel = () -> this.quantity > 100 ? 1 : 2;

    //STEP.1 remove the paramter
    //private float discountedPrice(float basePrice, int discountLevel ) {
    private float discountedPrice(float basePrice) {

        //STEP.2 Let the discountedPrice call the discount method itself
        switch (  this.discountLevel() ) {
            case 1: return basePrice * 0.95f;
            case 2: return basePrice * 0.9f;
            default: return basePrice;
        }
    }

    private int discountLevel(){
        return this.quantity>100 ? 2:1;
    }
}
