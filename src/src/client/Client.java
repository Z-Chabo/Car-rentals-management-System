//  ------------------------------------------------------------------------------
//  Assignment 1
//  Question: (include question/part number, if applicable)
//  Written by: Emile Ghattas (id: 40282552) and Zeidan Chabo (id:)
//  ------------------------------------------------------------------------------

package src.client;
import java.util.Scanner;
import src.driver.Main;
import src.vehicle.*;

public class Client {
    private String clientName;
    private Vehicle clientVehicle;


    public Client(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientVehicle(Vehicle vehicle) {
        this.clientVehicle = vehicle;
    }

    public Vehicle getClientVehicle() {
        return this.clientVehicle;
    }



    }
