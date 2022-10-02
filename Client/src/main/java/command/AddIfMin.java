package command;

import act.Request;
import client.Receiver;

public class AddIfMin implements Command{

    private final Receiver receiver;

    public AddIfMin(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда add_if_min не принимает аргументы.");
            return null;
        }
        return receiver.addIfMin();
    }
}