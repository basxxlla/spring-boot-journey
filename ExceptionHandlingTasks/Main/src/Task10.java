import java.io.*;

public class Task10 {

    static void readFile() throws IOException {
        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.readLine());

        br.close();
    }

}