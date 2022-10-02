package command;

import act.Request;
import client.Receiver;

public class RemoveById implements Command {

    private final Receiver receiver;

    public RemoveById(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public Request check(String argument) {
        if (argument == null){
            System.out.println("Команда remove_by_id требует аргумент id.");
            return null;
        }
        return receiver.removeById(argument);
    }
}