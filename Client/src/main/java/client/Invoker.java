package client;

import act.Request;
import command.*;

import javax.xml.validation.Validator;
import java.util.HashMap;

public class Invoker {

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public Invoker(Receiver validator){

        commandMap.put("add", new Add(validator));
        commandMap.put("addIfMin", new AddIfMin(validator));
        commandMap.put("clear", new Clear());
        commandMap.put("execute_script", new ExecuteScript());
        commandMap.put("exit", new Exit());
        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        commandMap.put("print_descending", new PrintDescending());
        commandMap.put("remove_by_id", new RemoveById(validator));
        commandMap.put("remove_greater", new RemoveGreater(validator));
        commandMap.put("remove_lower", new RemoveLower(validator));
        commandMap.put("show", new Show());
        commandMap.put("update_id", new UpdateId(validator));
    }

    public Request check(String commandName, String argument){
        if (this.commandMap.containsKey(commandName)) {
            return this.commandMap.get(commandName).check(argument);
        }
        System.out.println("Введённой команды не существует. Повторите ввод.");
        return null;
    }
}
