package workshop;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {

    String name;
    int places = 0;
    int purses = 0;
    boolean inPenaltyBox = false;

    Map<Integer, String> category = new HashMap<Integer,String >()
    {{
        put(0,"Pop");
        put(4,"Pop");
        put(8,"Pop");
        put(1,"Science");
        put(5,"Science");
        put(9,"Science");
        put(2,"Sports");
        put(6,"Sports");
        put(10,"Sports");
    }};

    public Player(String playerName) {
        this.name = playerName;
    }

    public String getName(){
        return this.name;
    }

    public boolean inPenalty(){
        return inPenaltyBox;
    }

    public void setPurses(){
        this.purses++;
    }

    public void setPlaces(int roll){
        this.places += roll;
        if(this.places>11){
            this.places-=12;
        }
    }

    public boolean gettingOutOfPenaltyBox(int roll){
        if (roll % 2 != 0) {
            System.out.println(this.name + " is getting out of the penalty box");

            setPlaces(roll);
            newPositionCategory();
            return true;
        }
        else {
            System.out.println(this.name + " is not getting out of the penalty box");
            return false;
        }
    }

    public String currentCategory(int places){
        if(category.containsKey(places))
        {
            return category.get(places);
        }
        else
            return "Rock";
    }

    public void newPositionCategory(){
        System.out.println(this.name
                + "'s new location is "
                + places);
        System.out.println("The category is " + currentCategory(places));
    }

    public void goldCoins(){
        System.out.println("Answer was correct!!!!");
        setPurses();

        System.out.println(name
                + " now has "
                + this.purses
                + " Gold Coins.");
    }

}
