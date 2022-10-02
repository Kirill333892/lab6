package command;

import act.Request;

public interface Command {

    Request check(String argument);

}
