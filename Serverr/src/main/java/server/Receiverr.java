package server;

import act.Reply;
import data.City;
import workfile.WorkWithFile;

import java.time.ZonedDateTime;
import java.util.TreeSet;

public class Receiverr {

    private long ID = 1L;
    private TreeSet<City> collection = new TreeSet<>();
    private Reply reply = new Reply();
    private final ZonedDateTime creationDate;
    public Receiverr(){
        creationDate = ZonedDateTime.now();
    }

    public Reply clear(){
        if (!collection.isEmpty()){
            collection.clear();
            reply.setMessage("Коллекция успешно очищена.");
        } else {
            reply.setMessage("Колллекция уже пуста.");
        }
        return reply;
    }

    public Reply add(City city){
        city.setId(this.ID++);
        city.setCreationDate(ZonedDateTime.now());
        if (!collection.add(city)) {
            reply.setMessage("Город добавить не удалось. Коллекция TreeSet не предполагает хранение одинаковых объектов.");
        } else {
            reply.setMessage("Город успешно добавлен в коллецию.");
        }
        return reply;
    }

    public Reply addIfMin(City city){
        if (collection.isEmpty()){
            reply.setMessage("Коллекция пуста. Создайте хотя бы один элемент, чтобы использовать эту команду.");
        }
        if (city.getPopulation() < collection.first().getPopulation()){
            collection.add(city);
            reply.setMessage("Город успешно добавлен в коллекцию.");
        } else {
            reply.setMessage("Город не удалось добавить. Его значение поля population превосходит наименьшее.");
        }
        return reply;
    }

    public Reply show(){
        if (collection.isEmpty()) {
            reply.setMessage("Коллекция пуста.");
            return reply;
        }
        reply.setMessage("Элементы коллекции в строковом представлении:");
        reply.setAnswer(
                collection.stream()
                        .map(City::cityToShow)
                        .toArray(String[]::new)
        );
        return reply;
    }

    public Reply printDescending(){
        if (collection.isEmpty()){
            reply.setMessage("Коллекция пуста.");
            return reply;
        }
        reply.setMessage("Элементы коллекции в обратном порядке: ");
        reply.setAnswer(( collection.stream()
                .sorted((city1, city2) -> -city1.compareTo(city2))
                .map(City::toString)
                .toArray(String[]::new)
        ));
        return reply;
    }

    public Reply removeById(String argument){
        long id = Long.parseLong(argument);
        boolean flag = false;
        for (City city : collection){
            if (city.getId().equals(id)){
                flag = true;
                collection.remove(city);
                break;
            }
        }
        if (!flag){
            reply.setMessage("Города с заданным id не существует.");
            return reply;
        }
        reply.setMessage("Город с заданным id успешно удалён.");
        return reply;
    }

    public Reply removeGreater(City city){
        if (collection.isEmpty()){
            reply.setMessage("Коллекция пуста.");
            return reply;
        }
        collection.removeIf(sity -> sity.getPopulation() > city.getPopulation());
        reply.setMessage("Элементы коллекции, превышающие заданный, удалены.");
        return reply;
    }

    public Reply removeLower(City city){
        if (collection.isEmpty()){
            reply.setMessage("Коллекция пуста.");
            return reply;
        }
        collection.removeIf(sity -> sity.getPopulation() < city.getPopulation());
        reply.setMessage("Элементы коллекции, меньшие чем заданный, удалены.");
        return reply;
    }


    public Reply info(){
        reply.setMessage("Тип коллекции: " + collection.getClass() +
                "\nДата инициализации коллекции: " + creationDate +
                "\nКоличество элементов коллекции: " + collection.size());
        return reply;
    }

    public Reply updateId(String idArgument, City city){
        long id = Long.parseLong(idArgument);
        City maybeDel = null;
        long before = collection.size();
        for (City sity : collection){
            if (sity.getId().equals(id)){
                collection.remove(sity);
                maybeDel = sity;
                break;
            }
        }
        long after = collection.size();
        if (before == after) {
            reply.setMessage("Элемента с заданным id не существует. Город не будет обновлён.");
            return reply;
        }
        city.setId(id);
        city.setCreationDate(ZonedDateTime.now());
        if (!collection.add(city)) {
            reply.setMessage("Город не удалось изменить. Коллекция TreeSet не предполагает хранение одинаковых объектов.");
            collection.add(maybeDel);
        } else {
            reply.setMessage("Город с id = " + id + " успешно изменён.");
        }
        return reply;
    }

    public Reply save(){
        WorkWithFile worker = new WorkWithFile();
        worker.writeInFile(collection);
        return reply;
    }

    public void clearReply(){
        this.reply.setMessage(null);
        this.reply.setAnswer(null);
    }

    public TreeSet<City> getCollection(){
        return this.collection;
    }

}