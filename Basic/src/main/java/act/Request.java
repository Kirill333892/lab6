package act;

import data.City;

import java.io.Serializable;
import java.net.SocketAddress;

public class Request implements Serializable {

    private static final long serialVersionUID = 666777666L;
    private String commandName;
    private String  argument;
    private City city;
    private SocketAddress clientAdress = null;

    public Request(String commandName, String argument, City city){
        this(commandName, argument);
        this.city = city;
    }

    public Request(String commandName, String argument){
        this.commandName = commandName;
        this.argument = argument;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public SocketAddress getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(SocketAddress clientAdress) {
        this.clientAdress = clientAdress;
    }
}