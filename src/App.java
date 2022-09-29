import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        str();
        for (String string : str()) {
            System.out.println(string);
        }
    }

    public static List<String> str() throws IOException {

        File inputFile = new File("string.txt");
        String[] symbolArray;
        String symbol;
        List<String> list = new ArrayList<String>();
        List<String> finalList = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            while ((symbol = br.readLine()) != null) {
                list.add(symbol);
            }
            br.close();
            symbolArray = list.toArray(new String[0]);

            for (int i = 0; i < symbolArray.length; i++) {

                Matcher matcher = Pattern.compile("\\d+").matcher(symbolArray[i]);
                while (matcher.find()) {
                    int value = Integer.valueOf(matcher.group());
                    if (value >= 10) {
                        finalList.add(symbolArray[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return finalList;
    }
}
