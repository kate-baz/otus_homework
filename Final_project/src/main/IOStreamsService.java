package main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOStreamsService implements IOService{

    private final PrintStream out;
    private final Scanner in;

    public IOStreamsService(PrintStream out, InputStream in) {
        this.out = out;
        this.in = new Scanner(in);
    }

    public void outputString(String message) {
        out.println(message);
    }

    public String inputString() {
        return in.nextLine();
    }
}