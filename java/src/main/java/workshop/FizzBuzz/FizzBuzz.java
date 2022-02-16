package workshop.FizzBuzz;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {

    private List<patternMatcher> PtrnMatcher;
    private NullPrint nullObj;

    public FizzBuzz(List<patternMatcher> PtrnMatcher,NullPrint nullObj)
    {
        this.PtrnMatcher = PtrnMatcher;
        this.nullObj = nullObj;
    }

    public String say(int number) {
        String strReturn = nullObj.generateNull();
        for(patternMatcher ptnmtch: PtrnMatcher)
        {
            if(ptnmtch.matches(number))
            {
                strReturn = ptnmtch.generate_response();
            }
        }

         return nullObj.SendString(strReturn,number);
    }
}
