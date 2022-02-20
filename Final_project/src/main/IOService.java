package main;

public interface IOService extends AutoCloseable{
    void outputString(String message);
    String inputString();

    void close();
}
