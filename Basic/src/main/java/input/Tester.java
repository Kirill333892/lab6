package input;

import data.Coordinates;
import data.Human;
import data.Leader;
import data.StandardOfLiving;

import java.util.Scanner;

public class Tester {

    private final Scanner scanner = new Scanner(System.in);
    private final   Validator validator = new Validator();

    protected String nameInput() {

        System.out.print("Введите имя города:" + "\n>");

        String name = validator.checkNameValid(scanner.nextLine());

        if (name == null){
            System.out.println("Пустая строка не может быть именем.");
            return nameInput();
        }

        return name;
    }

    protected Coordinates coordinatesInput(){

        System.out.print("Введите координаты x и y через точку с запятой:"  + "\n>");

        Coordinates coordinates = validator.checkCoordinatesValid(scanner.nextLine());

        if (coordinates == null){
            System.out.println("Координат должно быть две. Обе координаты должны быть типа Double. Координата 'x' должна превышать -193, а 'y' не превышать 563.");
            return coordinatesInput();
        }

        return coordinates;

    }

    protected Float areaInput(){

        System.out.print("Введите площадь города:" + "\n>");

        Float area = validator.checkAreaValid(scanner.nextLine());

        if (area == null){
            System.out.println("Площадь города должна быть типа Float, её значение должно быть больше, чем 0.");
            return areaInput();
        }

        return area;

    }

    protected int populationInput(){

        System.out.print("Введите население города:" + "\n>");

        Integer population = validator.checkPopulationValid(scanner.nextLine());

        if (population == null){
            System.out.println("Население города должно быть типа Integer. Значение не должно быть меньше 0.");
            return populationInput();
        }

        return population;

    }

    protected float metersAboveSeaLevelInput(){

        System.out.print("Введите высоту над уровнем моря:" + "\n>");

        Float masl = validator.checkMetersAboveSeaLevelValid(scanner.nextLine());

        if (masl == null){
            System.out.println("Высота над уровнем моря должна быть типа Float.");
            return metersAboveSeaLevelInput();
        }

        return masl;

    }

    protected StandardOfLiving standardOfLivingInput(){

        System.out.println("Выберите уровень жизни:");

        int i = 1;

        for (StandardOfLiving standard : StandardOfLiving.values()){
            System.out.println(i++ + ") " + standard.toString());
        }
        System.out.print(">");

        StandardOfLiving standardOfLiving = validator.checkStandartOfLivingByNumValid(scanner.nextLine());

        if (standardOfLiving == null){
            System.out.println("Выберите одну из предложенных цифр.");
            return standardOfLivingInput();
        }

        return standardOfLiving;

    }

    protected Human leaderInput(){

        System.out.println("Выберите правителя:");

        int i = 1;

        for (Leader king : Leader.values()){
            System.out.println(i++ + ") " + king.toString());
        }
        System.out.print(">");

        Human leader = validator.checkLeadersByNumValid(scanner.nextLine());

        if (leader == null){
            System.out.println("Выберите одну из предложенных цифр.");
            return leaderInput();
        }

        return leader;

    }

}