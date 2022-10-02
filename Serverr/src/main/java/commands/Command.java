package commands;

import act.Reply;
import act.Request;

public interface Command {

    Reply execute(Request request);

    String getHelp();

}
