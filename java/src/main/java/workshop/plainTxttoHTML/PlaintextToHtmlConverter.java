package plainTxttoHTML;

import refac.NullPrint;
import refac.patternMatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {

    List<CharacterConvert> charconvert;

    public PlaintextToHtmlConverter(List<CharacterConvert> chrcon)
    {
        this.charconvert = chrcon;
    }

        public String toHtml() throws Exception {
            String text = read();
            String htmlLines = basicHtmlEncode(text);
            return htmlLines;
        }

        protected String read() throws IOException {
            return new String(Files.readAllBytes(Paths.get("sample.txt")));
        }

        private String basicHtmlEncode(String source) {
            int i = 0;
            List<String> result = new ArrayList<>();
            List<String> convertedLine = new ArrayList<>();

            for(char characterToConvert : source.toCharArray())
            {
                for(CharacterConvert charcon: charconvert)
                {
                    if(charcon.checknConvert(characterToConvert))
                    {
                        convertedLine.add(charcon.addconverted());
                    }
                    else if(characterToConvert=='\n')
                    {
                        addANewLine(convertedLine, result);
                    }
                    else
                    {
                        pushACharacterToTheOutput(convertedLine, String.valueOf(characterToConvert));
                    }
                }
                if (i >= source.length()) break;
            }
            addANewLine(convertedLine, result);
            String finalResult = String.join("<br />", result);
            return finalResult;
        }


        //stringfy convertedLine array and push into result
        //reset convertedLine
        private void addANewLine(List<String> convertedLine, List<String> result) {
            String line = String.join("", convertedLine);
            result.add(line);
            convertedLine = new ArrayList<>();
        }

        private void pushACharacterToTheOutput(List<String> convertedLine, String s) {
            convertedLine.add(s);
        }
    }

