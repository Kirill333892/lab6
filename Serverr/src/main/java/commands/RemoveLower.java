package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class RemoveLower implements Command {

    private final Receiverr receiverr;

    public RemoveLower(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.removeLower(request.getCity());
    }

    @Override
    public String getHelp() {
        return "Введите remove_lower {element}, чтобы удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
