package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class RemoveById implements Command {

    private final Receiverr receiverr;

    public RemoveById(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.removeById(request.getArgument());
    }

    @Override
    public String getHelp() {
        return "Введите remove_by_id id, чтобы удалить элемент из коллекции по его id";
    }
}
