import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(constants.nametask2));
        String line1, line2;
        String[] words1;
        int kolich1 = 0, kolich2 = 0;
        line1 = in.readLine();
        line2 = in.readLine();
        words1 = line1.split("[\\s,-;.]+");

        for (int i = 0; i < words1.length; i++) {
            if (line2.contains(words1[i]) == true)
                kolich1++;
        }

        Pattern pattern = Pattern.compile("[,-;]");
        Matcher matcher = pattern.matcher(line1);
        while (matcher.find())
            kolich2++;



        System.out.println("Amount of words - " + kolich1 + ". Punctuate amount - " + kolich2);

        in.close();

    }
}
