package server;

import act.Reply;
import act.Request;
import commands.*;

import java.util.HashMap;

public class Invoker {

    private static Invoker invoker;

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    public Invoker(Receiverr receiverr){

        commandMap.put("save", new Save(receiverr));
        commandMap.put("add", new Add(receiverr));
        commandMap.put("addIfMin", new AddIfMin(receiverr));
        commandMap.put("clear", new Clear(receiverr));
        commandMap.put("execute_script", new ExecuteScript(receiverr));
        commandMap.put("help", new Help(receiverr, commandMap));
        commandMap.put("info", new Info(receiverr));
        commandMap.put("print_descending", new PrintDescending(receiverr));
        commandMap.put("remove_by_id", new RemoveById(receiverr));
        commandMap.put("remove_greater", new RemoveGreater(receiverr));
        commandMap.put("remove_lower", new RemoveLower(receiverr));
        commandMap.put("show", new Show(receiverr));
        commandMap.put("update_id", new UpdateId(receiverr));
        commandMap.put("exit", new Exit());

    }

    public Reply execute(Request request){
        String commandName = request.getCommandName();
        return this.commandMap.get(commandName).execute(request);
    }

    public HashMap<String, Command> getCommandMap(){
        return this.commandMap;
    }

    public static Invoker getInstance(Receiverr receiverr){
        if (invoker == null){
            invoker = new Invoker(receiverr);
        }
        return invoker;
    }

}
