package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class Info implements Command {

    private final Receiverr receiverr;

    public Info(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.info();
    }

    @Override
    public String getHelp() {
        return "Введите info, чтобы вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации," +
                " количество элементов)";
    }
}
