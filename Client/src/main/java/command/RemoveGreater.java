package command;

import act.Request;
import client.Receiver;

public class RemoveGreater implements Command {

    private final Receiver receiver;

    public RemoveGreater(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public Request check(String argument) {

        if (argument != null){
            System.out.println("Команда remove_greater не принимает аргумент.");
            return null;
        }
        return receiver.removeGreater();
    }
}
