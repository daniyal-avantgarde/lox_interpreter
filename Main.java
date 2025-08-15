import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
//import java.util.Scanner;

public class Main {
    static boolean hadError = false;
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            print("Incorrect usage");
        } else if (args.length == 1) { // if filename execute file
            runFile(args[0]);           
        } else if (args.length == 0) {
            runPrompt(); // if no filename start REPL
        }
    }

    public static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
            hadError = false;
        }
    }
    public static void runFile(String path) throws IOException{
        run(new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8));
        if (hadError) System.exit(65);
    }
    public static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens) {
            print(token.lexeme);
            // print(String.valueOf(token.literal));
            print(String.valueOf(token.type));
        }
    }

    static void error(int line, String message) {
        report(line, "", message);
    }
    static void report(int line, String where, String message) {
        System.err.println("[Line " + line + "] Error" + where + ": " + message);
    }

    public static void print(String string) {
        System.out.println(string);
    }
}