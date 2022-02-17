package plainTxttoHTML;

public class ampersand implements CharacterConvert{
    @Override
    public boolean checknConvert(char c) {
        char match = '&';
        return (c==match);
    }

    @Override
    public String addconverted() {
        return "&amp;";
    }
}
