package utilities;

public interface IConsole {
    void write(String message);
    String read();
    Boolean confirm(String message);
}
