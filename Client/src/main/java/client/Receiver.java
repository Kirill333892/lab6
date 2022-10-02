package client;

import act.Request;
import data.City;
import input.Adder;

public class Receiver {

    public Request add(){
        City city = Adder.createCity();
        return new Request("add", null, city);
    }

    public Request addIfMin(){
        City city = Adder.createCity();
        return new Request("add_if_min", null, city);
    }

    public Request removeGreater(){
        City city = Adder.createCity();
        return new Request("remove_greater", null, city);
    }

    public Request removeLower(){
        City city = Adder.createCity();
        return new Request("remove_lower", null, city);
    }

    public Request removeById(String argument){
        try{
            long id = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("Аргумент id должен быть типа long.");
            return null;
        }
        return new Request("remove_by_id", argument);
    }


    public Request updateId(String argument){
        try{
            long id = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("Аргумент id должен быть типа long");
            return null;
        }
        System.out.println("Создайте город, который заменит город с выбранным вами значением поля id:");
        City city = Adder.createCity();
        return new Request("update_id", argument, city);
    }

}
