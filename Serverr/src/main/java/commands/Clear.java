package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class Clear implements Command {
    private final Receiverr receiverr;

    public Clear(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.clear();
    }

    @Override
    public String getHelp() {
        return "Введите clear, чтобы очистить коллекцию";
    }
}
