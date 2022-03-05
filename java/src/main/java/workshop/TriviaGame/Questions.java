package TriviaGame;

import java.util.LinkedList;
import java.util.List;

public class Questions {

    List<String> popQuestions = new LinkedList();
    List<String> scienceQuestions = new LinkedList();
    List<String> sportsQuestions = new LinkedList();
    List<String> rockQuestions = new LinkedList();

    public void Questions(){
        for (int i = 0; i < 50; i++) {
            popQuestions.add("Pop Question " + i);
            scienceQuestions.add(("Science Question " + i));
            sportsQuestions.add(("Sports Question " + i));
            rockQuestions.add("Rock Question " + i);
        }
    }
}
