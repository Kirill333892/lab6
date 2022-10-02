package input;

import data.*;

import java.time.ZonedDateTime;

public class Adder {

    /**
     * testing and adding cities from array
     */
    public static City createCityByArray(String[] length, long i){

        if (length.length != 9){
            return null;
        }

        Validator validator = new Validator();

        Long id = validator.checkIdValid(length[0]);
        String name = validator.checkNameValid(length[1]);
        Coordinates coordinates = validator.checkCoordinatesValid(length[2]);
        ZonedDateTime creationDate = validator.checkDataValid(length[3]);
        Float area = validator.checkAreaValid(length[4]);
        Integer population = validator.checkPopulationValid(length[5]);
        Float masl = validator.checkMetersAboveSeaLevelValid(length[6]);
        StandardOfLiving standardOfLiving = validator.checkStandartOfLivingByNameValid(length[7]);
        Human leader = validator.checkLeadersByNameValid(length[8]);

        if (id == null || name == null || coordinates == null || creationDate == null || area == null || population == null
                || masl == null || standardOfLiving == null || leader == null) {
            return null;
        }
        return new City(id, name, coordinates, creationDate, area, population, masl, standardOfLiving,
                leader);
    }

    public static City createCity(){

        Tester tester = new Tester();

        String name = tester.nameInput();

        long id = (long) (Math.random() * 1000000 + 1);

        ZonedDateTime creationDate = ZonedDateTime.now();

        Coordinates coordinates = tester.coordinatesInput();

        float area = tester.areaInput();

        int population = tester.populationInput();

        float masl = tester.metersAboveSeaLevelInput();

        StandardOfLiving standardOfLiving = tester.standardOfLivingInput();

        Human governor = tester.leaderInput();

        return new City(id, name, coordinates, creationDate, area, population, masl, standardOfLiving,
                governor);
    }


}
