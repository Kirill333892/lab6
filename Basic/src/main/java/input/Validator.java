package input;

import data.Coordinates;
import data.Human;
import data.Leader;
import data.StandardOfLiving;

import java.time.ZonedDateTime;

public class Validator {

    protected Long checkIdValid(String input){
        long id;
        try {
            id = Long.parseLong(input);
        } catch (NumberFormatException e){
            return null;
        }
        return id;
    }

    protected String checkNameValid(String name){
        if (name.isEmpty()){
            return null;
        } else {
            return name;
        }
    }

    protected Coordinates checkCoordinatesValid(String input){

        String[] coordinates = input.trim().split(";");

        if (coordinates.length != 2){
            return null;
        }

        String xstring = coordinates[0];
        String ystring = coordinates[1];
        double x, y;

        try {
            x = Double.parseDouble(xstring);
            y = Double.parseDouble(ystring);
            if (y <= -427){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }
        return new Coordinates(x, y);
    }

    protected ZonedDateTime checkDataValid(String input){
        ZonedDateTime dateTime;
        try {
            dateTime = ZonedDateTime.parse(input);
        } catch (Exception e){
            return null;
        }
        return dateTime;
    }

    protected Float checkAreaValid(String areaString){
        float area;
        try{
            area = Float.parseFloat(areaString);
            if (area <= 0){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }

        return area;
    }

    protected Integer checkPopulationValid(String input){
        int population;
        try{
            population = Integer.parseInt(input);
            if (population <= 0){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e){
            return null;
        }
        return population;
    }

    protected Float checkMetersAboveSeaLevelValid(String input){
        float masl;
        try{
            masl = Float.parseFloat(input);
        } catch (NumberFormatException e){
            return null;
        }
        return masl;
    }

    protected StandardOfLiving checkStandartOfLivingByNumValid(String input){

        StandardOfLiving standrt;

        try {
            int standrtnum = Integer.parseInt(input) - 1;
            standrt = StandardOfLiving.values()[standrtnum];
        } catch (Exception e){
            return null;
        }

        return standrt;
    }

    protected StandardOfLiving checkStandartOfLivingByNameValid(String input){

        for (StandardOfLiving standard : StandardOfLiving.values()){
            if (standard.toString().equals(input)){
                return standard;
            }
        }

        return null;

    }

    protected Human checkLeadersByNumValid(String input){

        Leader leader;

        try {
            int leadernum = Integer.parseInt(input) - 1;
            leader = Leader.values()[leadernum];
        } catch (Exception e){
            return null;
        }

        return Human.randomHuman(leader.toString());
    }

    protected Human checkLeadersByNameValid(String input){

        for (Leader leader : Leader.values()){
            if (leader.toString().equals(input)){
                return Human.randomHuman(leader.toString());
            }
        }

        return null;
    }

}