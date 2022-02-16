package workshop.FizzBuzz;

public class NullPrint {
    public String generateNull()
    {
        return "";
    }
    public String SendString(String str, int number)
    {
        if (str != null) return str;

        return String.valueOf(number);
    }
}
