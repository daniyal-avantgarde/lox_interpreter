import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Lox {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            print("Incorrect usage");
        } else if (args.length == 1) { //filename given
            runFile(args[0]);           
        } else if (args.length == 0) {
            runPrompt();
        }
    }

    public static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print(">");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
        }
    }
    
    public static void runFile(String path) throws IOException{
        run(new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8));
    }

    public static void run(String source) {
        Scanner scanner = new Scanner(source);
        while (scanner.hasNextLine()) {
            print(scanner.nextLine());
        }

    }

    public static void print(String string) {
        System.out.println(string);
    }
}