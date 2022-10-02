package command;

import act.Request;

public class PrintDescending implements Command {

    @Override
    public Request check(String argument) {
        if (argument != null){
            System.out.println("Команда print_descending не принимает аргументы.");
            return null;
        }
        return new Request("print_descending", null);
    }
}