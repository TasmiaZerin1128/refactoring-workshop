package workshop.FizzBuzz;

public class FizzMatcher implements patternMatcher{
    @Override
    public boolean matches(int number) {
        return number%3==0;
    }

    @Override
    public String generate_response() {
        return "Fizz";
    }
}
