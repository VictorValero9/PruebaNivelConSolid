package utilities;

import java.util.Scanner;

public class Console implements IConsole{
    private Scanner scanner;

    public Console(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void write(String message){
        System.out.println(message);
    }

    @Override
    public String read(){
        return scanner.nextLine();
    }

    @Override
    public Boolean confirm(String message){
        write(message);
        String response = read();
        return response.equalsIgnoreCase("s");
    }
}
