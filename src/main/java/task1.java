import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(constants.nametask1));
        String line1, line2;
        String[] words1;
        line1 = in.readLine();
        line2 = in.readLine();
        words1 = line1.split("[\\s,-;.]+");

        for (int i = 0; i < words1.length; i++) {
            if (line2.contains(words1[i])!=true)
                System.out.println(words1[i]);
        }

        in.close();

    }
}
