package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class PrintDescending implements Command {

    private final Receiverr receiverr;

    public PrintDescending(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.printDescending();
    }

    @Override
    public String getHelp() {
        return "Введите print_descending, чтобы вывести элементы коллекции в порядке убывания";
    }
}
