package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

import java.util.ArrayList;

public class ExecuteScript implements Command {

    private final ArrayList<String> paths = new ArrayList<>();

    private final Receiverr receiverr;

    public ExecuteScript(Receiverr receiverr) {
        this.receiverr = receiverr;

    }

    @Override
    public Reply execute(Request request) {
        Reply reply = new Reply();
        reply.setMessage("Данное приложение не поддерживает вызов команды execute_script из самой себя.");
        return reply;
    }

    @Override
    public String getHelp() {
        return "Введите execute_script file_name, чтобы считать и исполнить скрипт из указанного файла.";
    }
}