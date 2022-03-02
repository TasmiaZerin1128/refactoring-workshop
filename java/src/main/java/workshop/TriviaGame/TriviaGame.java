package workshop;

import java.util.ArrayList;
import java.util.LinkedList;


public class TriviaGame {
    ArrayList<Player> players = new ArrayList();

    Questions ques = new Questions();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
    }


    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {


        players.add(new Player(playerName));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + howManyPlayers());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public Player getCurrentPlayer(int currentPlayer)
    {
        return players.get(currentPlayer);
    }

    public void roll(int roll) {

        System.out.println(getCurrentPlayer(currentPlayer).getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (getCurrentPlayer(currentPlayer).inPenalty()) {

            isGettingOutOfPenaltyBox = getCurrentPlayer(currentPlayer).gettingOutOfPenaltyBox(roll);

        } else {

            getCurrentPlayer(currentPlayer).setPlaces(roll);
            getCurrentPlayer(currentPlayer).newPositionCategory();
        }

    }


    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer(currentPlayer).inPenaltyBox) {
            if (isGettingOutOfPenaltyBox) {
                getCurrentPlayer(currentPlayer).goldCoins();
                boolean winner = didPlayerWin();
                updatePlayer();

                return winner;

            } else {
                updatePlayer();
                return true;
            }

        } else {

            getCurrentPlayer(currentPlayer).goldCoins();

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public void updatePlayer(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }


    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer(currentPlayer).getName() + " was sent to the penalty box");
        getCurrentPlayer(currentPlayer).inPenaltyBox = true;

        updatePlayer();
        return true;
    }

    private boolean didPlayerWin() {
        return !(getCurrentPlayer(currentPlayer).purses == 6);
    }

}