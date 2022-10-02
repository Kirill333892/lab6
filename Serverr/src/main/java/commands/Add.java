package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

public class Add implements Command {

    private final Receiverr receiverr;

    public Add(Receiverr receiverr){
        this.receiverr = receiverr;
    }


    @Override
    public Reply execute(Request request) {
        receiverr.clearReply();
        return receiverr.add(request.getCity());
    }

    @Override
    public String getHelp() {
        return "Введите add {element}, чтобы добавить новый элемент в коллекцию";
    }
}