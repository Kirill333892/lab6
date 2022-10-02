package command;

import act.Request;
import client.Receiver;

public class UpdateId implements Command {

    private final Receiver receiver;

    public UpdateId(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда update_id требует аргумент id.");
            return null;
        }
        return receiver.updateId(argument);
    }
}

