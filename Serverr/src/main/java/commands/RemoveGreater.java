package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class RemoveGreater implements Command {

    private final Receiverr receiverr;

    public RemoveGreater(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.removeGreater(request.getCity());
    }

    @Override
    public String getHelp() {
        return "Введите remove_greater {element}, чтобы удалить из коллекции все элементы, превышающие заданный";
    }
}