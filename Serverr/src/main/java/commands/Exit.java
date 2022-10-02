package commands;

import act.Reply;
import act.Request;

public class Exit implements Command{
    @Override
    public Reply execute(Request request) {
        System.out.println("Спасибо за работу, до свидания.");
        System.exit(0);
        return null;
    }

    @Override
    public String getHelp() {
        return "Введите exit, чтобы завершить программу (без сохранения в файл).";
    }
}
