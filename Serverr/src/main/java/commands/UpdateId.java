package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class UpdateId implements Command {

    private final Receiverr receiverr;

    public UpdateId(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.updateId(request.getArgument(), request.getCity());
    }

    @Override
    public String getHelp() {
        return "Введите update_id {element}, чтобы обновить значение элемента коллекции, id которого равен заданному";
    }
}
