package commands;

import act.Reply;
import act.Request;
import server.Receiverr;

import java.util.HashMap;

public class Help implements Command {

    private final Receiverr receiverr;
    HashMap<String, Command> commandMap = new HashMap<>();

    public Help(Receiverr receiverr, HashMap<String, Command> commandMap) {
        this.receiverr = receiverr;
        this.commandMap = commandMap;
    }

    @Override
    public Reply execute(Request request) {
        String[] commandshelp = commandMap.values().stream()
                .map(Command::getHelp)
                .toArray(String[]::new);
        Reply reaction = new Reply();
        reaction.setAnswer(commandshelp);
        return reaction;
    }

    @Override
    public String getHelp() {
        return "Введите help, если хотитите вывести справку по доступным командам";
    }
}