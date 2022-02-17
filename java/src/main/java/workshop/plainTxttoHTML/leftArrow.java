package plainTxttoHTML;

public class leftArrow implements CharacterConvert {
    @Override
    public boolean checknConvert(char c) {
        char match = '<';
        return (c==match);
    }

    @Override
    public String addconverted() {
        return "&lt;";
    }
}
