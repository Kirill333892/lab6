package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class AddIfMin implements Command {

    private final Receiverr receiverr;

    public AddIfMin(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        this.receiverr.clearReply();
        return receiverr.addIfMin(request.getCity());
    }

    @Override
    public String getHelp() {
        return "Введите add_if_min {element}, чтобы добавить новый элемент в коллекцию, если его значение меньше, чем у" +
                " наименьшего элемента этой коллекции";
    }
}