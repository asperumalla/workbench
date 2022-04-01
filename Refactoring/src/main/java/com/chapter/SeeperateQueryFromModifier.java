package com.chapter;

import java.util.List;


/*public class SeeperateQueryFromModifier {

    public static void main (String[] args) {

        caller( List.of("Man","Sam","Don","Ram")  );

    }


    public static void  caller(List<String> people){
        var wanted = alertForMiscreant( people );
        System.out.println("Name of the person :"+ wanted);
    }

    public static String alertForMiscreant (List<String> people) {
        for ( String person : people) {
            if (person.equalsIgnoreCase( "Don") ){
                setOffAlarms();
                return "Don";
            }
            if (person.equalsIgnoreCase(  "Ram")) {
                setOffAlarms();
                return "Ram";
            }
        }
        return "";
    }

    private static void setOffAlarms () {
        System.out.println("Perform an Action!!");
    }
}*/

public class SeeperateQueryFromModifier {

    public static void main (String[] args) {

        caller( List.of("Man","Sam","Don","Ram")  );

    }


    public static void  caller(List<String> people){
        var wantedPerson = findPerson( people);
        alertForMiscreant( people );
        System.out.println("Name of the person :"+ wantedPerson);
    }

    private static void setOffAlarms () {
        System.out.println("Perform an Action!!");
    }

    public static void alertForMiscreant (List<String> people) {
        if( findPerson(people)!="" )
            setOffAlarms();
    }

    public static String findPerson (List<String> people) {
        for ( String person : people) {
            if (person.equalsIgnoreCase( "Don") ){
                return "Don";
            }
            if (person.equalsIgnoreCase(  "Ram")) {
                return "Ram";
            }
        }
        return "";
    }

}
