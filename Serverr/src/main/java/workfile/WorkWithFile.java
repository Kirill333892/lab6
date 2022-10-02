package workfile;

import data.City;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import input.Adder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

import static java.lang.System.getenv;

public class WorkWithFile {

    public static void fillTheCollection(TreeSet<City> collection) throws IOException, CsvValidationException {

        try (CSVReader reader = new CSVReader(new FileReader(getenv("path")))) {
            String[] components;
            long b = 1;
            while ((components = reader.readNext()) != null) {
                City city = Adder.createCityByArray(components, b++);
                if (city == null || !collection.add(city)) {
                    System.out.println("Ошибка добавления города " + b + ": Город уже существует " +
                            "или неверно заданы поля.");
                }
                collection.add(city);
            }
        } catch (NullPointerException ex) {
            System.out.println("Для начала работы необходимо инициализировать переменную окружения path со входной коллекцией");
            System.exit(-1);
        }

    }

    public String writeInFile(TreeSet<City> collection) {

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(System.getenv("path")))) {
            for (City city : collection) {
                byte[] s = city.cityToString().getBytes(StandardCharsets.UTF_8);
                out.write(s);
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            return "коллекция записана в файл.";
        } catch (IOException e) {
            return "коллекция не записалась. Недостаточно прав.";
        }

    }
}