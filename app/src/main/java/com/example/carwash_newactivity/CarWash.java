package com.example.carwash_newactivity;

public class CarWash {

    static final int TYPE1 = 5;
    static final int TYPE2 = 10;

    private int washes;
    private int type;
    private double total;


    public CarWash(){

        washes=0;
        type = TYPE1;
        total = 0;
    }

    public void setWashes(int washes) {
        this.washes = washes;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal(){

        total = washes * type;


        if(washes >= 12){

            total -= total * .25;
        }


        return total;
    }

}