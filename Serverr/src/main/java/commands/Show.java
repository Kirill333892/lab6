package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class Show implements Command {

    private final Receiverr receiverr;

    public Show(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.show();
    }

    @Override
    public String getHelp() {
        return "Введите show, чтобы вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}