package client;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args){
        try {
            Client client = new Client();
            Receiver receiver = new Receiver();
            Invoker invoker = new Invoker(receiver);
            Terminal terminal = new Terminal(invoker, client);
            terminal.startKeyboard();
        } catch (NoSuchElementException ex){
            System.exit(0);
        }
    }

}