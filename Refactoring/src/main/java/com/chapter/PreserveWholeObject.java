package com.chapter;

public class PreserveWholeObject {

    private static Room getRoom () {
        DaysTempRange daysTempRange =  new DaysTempRange(56f, 78f);
        Room room = new Room(daysTempRange);
        return room;
    }

    private static HeatingPlan getPlan () {
        DaysTempRange daysTempRange =  new DaysTempRange(60f, 78f);
        HeatingPlan plan = new HeatingPlan(daysTempRange);
        return plan;
    }


    public static void main (String[] args) {
        Room room = getRoom();
        HeatingPlan plan = getPlan();

        //STEP.3 We see the below code is not required, so delete it
        final var low = room.daysTempRange.low;
        final var high = room.daysTempRange.high;

        //STEP.2 replace existing method with new method
        if (!plan.withinRange(low, high)) {
        //if (!plan.NEWwithinRange(room.daysTempRange)) {
            System.out.println("room temperature went outside range");
        }
    }

}

class Room{
    DaysTempRange daysTempRange;

    public Room (DaysTempRange daysTempRange) {
        this.daysTempRange = daysTempRange;
    }
}

class DaysTempRange{
    float low;
    float high;

    public DaysTempRange (float low, float high) {
        this.high = high;
        this.low = low;

    }
}

class HeatingPlan{

    DaysTempRange temperatureRange;

    public HeatingPlan (DaysTempRange temperatureRange) {
        this.temperatureRange = temperatureRange;
    }

    boolean withinRange(float bottom, float top) {
        return (bottom >= this.temperatureRange.low) && (top <= this.temperatureRange.high);
    }

    // STEP.1 Create a new method by calling existing method
    boolean NEWwithinRange(DaysTempRange daysTempRange){
        //STEP.4 remove the internal call and give the inline implementation
        return withinRange(daysTempRange.low, daysTempRange.high);
        //return (daysTempRange.low >= this.temperatureRange.low) && (daysTempRange.high <= this.temperatureRange.high);
    }
}
