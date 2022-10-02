package command;

import act.Request;
import client.Receiver;

public class Add implements Command{

    private final Receiver receiver;

    public Add(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public Request check(String argument) {
        if (argument != null) {
            System.out.println("Команда add не принимает аргументы.");
            return null;
        }
        return receiver.add();
    }
}
