package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class Save implements Command{

    private final Receiverr receiverr;

    public Save(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.save();
    }

    @Override
    public String getHelp() {
        return "Команда save: недоступна.";
    }
}
