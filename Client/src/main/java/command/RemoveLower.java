package command;

import act.Request;
import client.Receiver;

public class RemoveLower implements Command {

    private final Receiver receiver;

    public RemoveLower(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда remove_lower не принимает аргумент.");
            return null;
        }
        return receiver.removeLower();
    }
}