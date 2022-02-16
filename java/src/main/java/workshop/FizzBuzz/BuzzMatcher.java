package workshop.FizzBuzz;

public class BuzzMatcher implements patternMatcher{
    @Override
    public boolean matches(int number) {
        return number%5==0;
    }

    @Override
    public String generate_response() {
        return "Buzz";
    }
}
