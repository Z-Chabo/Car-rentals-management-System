//v1

    package src.driver;

    import java.util.Scanner;
    import src.vehicle.*;
    import src.client.Client;

    public class Main {
        private static ElectricCar[] newCars;
        private static Vehicle[] vehicles;
        private static Scanner s = new Scanner(System.in);
        private static Client[] clients;
        private static Vehicle clientVehicle;
        private static ElectricCar[] electricCars;
        private static int count1;
        private static int maxVehicles;
        private static int maxNumClients;
        public static void main(String[] args) {
            System.out.println("Welcome user! ");
            System.out.println("let's start by making a group of electric cars");
            System.out.println("How big would you like your group to be?");
            int electricCarsNum=s.nextInt();
            electricCars=new ElectricCar[electricCarsNum];
            for(int i=0;i<electricCars.length;i++) {
                System.out.println("Enter the make: ");
                String make = s.next();
                System.out.println("Enter the model: ");
                String model = s.next();
                System.out.println("Enter the year: ");
                if(!s.hasNextInt()){
                    System.out.println("you did not enter a number! Please try again");
                    s.next();
                }
                int year = s.nextInt();
                System.out.println("Enter the max capacity (in Kg)");
                if(!s.hasNextInt()){
                    System.out.println("you did not enter a number! Please try again");
                    s.next();
                }
                int maxCapacity = s.nextInt();
                System.out.println("Enter the autonomy range (in Kilometers) :");
                if(!s.hasNextInt()){
                    System.out.println("you did not enter a number! Please try again");
                    s.next();
                }
                int maxAutonomy = s.nextInt();
                electricCars[i] = new ElectricCar(make, model, year, maxCapacity, maxAutonomy);
            }
            System.out.println("please provide the maximum number of vehicles for vehicle management:");
            maxVehicles = s.nextInt();
            vehicles = new Vehicle[maxVehicles];
            System.out.println("What is the max number of clients of client management: ");
            maxNumClients = s.nextInt();
            clients = new Client[maxNumClients];

            while(true) {
                System.out.println("what would you like to choose amongst these options?\n" +
                        "1-Vehicle management\n" +
                        "2-Client Management\n" +
                        "3-Leasing operations\n" +
                        "4-Additional Operations");
                int choice = s.nextInt();
                if (choice <0 || choice>4) {
                    System.out.println("invalid choice:");
                }
                    switch (choice) {
                        case 1 -> vehicleManagement();
                        case 2 -> clientManagement();
                        case 3 -> leasingOperations();
                        case 4 -> additionalOperations();
                        case 5 -> System.exit(0);
                    }

            }
        }


            public static void vehicleManagement () {
                System.out.println("What would you like to do ?\n" +
                        "1-Add a vehicle\n" +
                        "2-Delete a vehicle\n" +
                        "3-Update vehicle information\n" +
                        "4-List all vehicles by category (electric trucks, diesel trucks, etc.) ");
                int choice = s.nextInt();
                switch (choice) {
                    case 1 -> {
                        boolean f = true;
                        while (f) {
                            System.out.println("How many vehicles would you like to add?");
                            int vNumber = s.nextInt();
                            if (vNumber <= maxVehicles) {
                                System.out.println("How many of each type of vehicle?");
                                System.out.println("Diesel Truck");
                                int num1 = s.nextInt();
                                System.out.println("Electric Car");
                                int num2 = s.nextInt();
                                System.out.println("Gasoline Car");
                                int num3 = s.nextInt();
                                System.out.println("Electric Truck");
                                int num4 = s.nextInt();
                                if(num1+num2+num3+num4>vNumber){
                                    System.out.println("you entered more cars than what you choose");
                                    continue;
                                }

                                for (int i = 0; i < num1; i++) {
                                    System.out.println("Enter the make: ");
                                    String make = s.next();
                                    System.out.println("Enter the model: ");
                                    String model = s.next();
                                    System.out.println("Enter the year");
                                    int year = s.nextInt();
                                    System.out.println("Enter the max capacity");
                                    int maxCapacity = s.nextInt();
                                    System.out.println("Enter the fuel tank capacity: ");
                                    int fuelTankCapacity = s.nextInt();
                                    vehicles[i] = new DieselTruck(make, model, year, maxCapacity, fuelTankCapacity);
                                }
                                for (int i = 0; i < num2; i++) {
                                    System.out.println("Enter the make: ");
                                    String make = s.next();
                                    System.out.println("Enter the model: ");
                                    String model = s.next();
                                    System.out.println("Enter the year");
                                    int year = s.nextInt();
                                    System.out.println("Enter the max number of passenger");
                                    int maxNumPass = s.nextInt();
                                    System.out.println("Enter the autonomy range: ");
                                    int autonomyR = s.nextInt();
                                    vehicles[i] = new ElectricCar(make, model, year, maxNumPass, autonomyR);
                                }
                                for (int i = 0; i < num3; i++) {
                                    System.out.println("Enter the make: ");
                                    String make = s.next();
                                    System.out.println("Enter the model: ");
                                    String model = s.next();
                                    System.out.println("Enter the year");
                                    int year = s.nextInt();
                                    System.out.println("Enter the max number of passengers");
                                    int maxNumPass = s.nextInt();
                                    vehicles[i] = new GasolineCar(make, model, year, maxNumPass);
                                }
                                for (int i = 0; i < num4; i++) {
                                    System.out.println("Enter the make: ");
                                    String make = s.next();
                                    System.out.println("Enter the model: ");
                                    String model = s.next();
                                    System.out.println("Enter the year");
                                    int year = s.nextInt();
                                    System.out.println("Enter the max capacity");
                                    int maxCapacity = s.nextInt();
                                    System.out.println("Enter the autonomy range : ");
                                    int autonomyRange = s.nextInt();
                                    vehicles[i] = new ElectricTruck(make, model, year, maxCapacity, autonomyRange);
                                }

                            }
                            f=false;
                        }
                    }
                    case 2 -> {
                        System.out.println("Please enter the plate number of the vehicle you would like to delete");
                        String plateNumber = s.next();
                        if (plateNumber != null) {
                            Vehicle[] newVehicles = new Vehicle[vehicles.length - 1];
                            for (int i = 0, j = 0; i < maxVehicles; i++) {
                                if(vehicles[i]!=null){
                                    if (vehicles[i].getPlateNumber().equalsIgnoreCase(plateNumber)) {
                                    continue;
                                }
                                newVehicles[j++] = vehicles[i];

                            }
                            }
                            vehicles = newVehicles;
                            System.out.println("The vehicle has been deleted");
                        }
                        else
                            System.out.println("The plate number is not valid");
                    }
                    case 3 -> {
                        System.out.println("Enter the plate number of the vehicle to update: ");
                        String plateNumber = s.next();
                        if(plateNumber!=null) {
                            for (Vehicle vehicle : vehicles) {
                                if (vehicle != null) {
                                    if (plateNumber.equalsIgnoreCase(vehicle.getPlateNumber())) {
                                        System.out.println("What would you like to update:\n " +
                                                "\n 1-make" +
                                                "\n 2-model" +
                                                "\n 3-year" +
                                                "\n 4-fuel tank capacity" +
                                                "\n 5-max capacity" +
                                                "\n 6-max passengers number" +
                                                "7-max autonomy");
                                        int choice2 = s.nextInt();
                                        switch (choice2) {
                                            case 1 -> {
                                                System.out.println("Enter the new of make: ");
                                                String newMake = s.next();
                                                vehicle.setMake(newMake);
                                            }
                                            case 2 -> {
                                                System.out.println("Enter the new model: ");
                                                String newModel = s.next();
                                                vehicle.setModel(newModel);
                                            }
                                            case 3 -> {
                                                System.out.println("Enter the new year: ");
                                                int newYear = s.nextInt();
                                                vehicle.setYear(newYear);
                                            }
                                            case 4 -> {
                                                System.out.println("Enter the new fuel tank capacity: ");
                                                int newFCapacity = s.nextInt();
                                                if (vehicle.getClass() == DieselTruck.class) {
                                                    DieselTruck DTvehicle = (DieselTruck) vehicle;
                                                    DTvehicle.setFuelTankCapacity(newFCapacity);
                                                }
                                            }
                                            case 5 -> {
                                                System.out.println("Enter the new max capacity: ");
                                                int newMaxCapacity = s.nextInt();
                                                if (vehicle.getClass() == ElectricCar.class) {
                                                    ElectricTruck ETvehicle = (ElectricTruck) vehicle;
                                                    ETvehicle.setMaxCapacity(newMaxCapacity);
                                                } else if (vehicle.getClass() == DieselTruck.class) {
                                                    DieselTruck DTvehicle = (DieselTruck) vehicle;
                                                    DTvehicle.setMaxCapacity(newMaxCapacity);
                                                }
                                                break;
                                            }
                                            case 6 -> {
                                                System.out.println("Enter the new max passengers number: ");
                                                int newMaxPassengers = s.nextInt();
                                                if (vehicle.getClass() == ElectricCar.class) {
                                                    ElectricCar ECvehicle = (ElectricCar) vehicle;
                                                    ECvehicle.setMaxPassengers(newMaxPassengers);
                                                } else if (vehicle.getClass() == GasolineCar.class) {
                                                    GasolineCar ETvehicle = (GasolineCar) vehicle;
                                                    ETvehicle.setMaxPassengers(newMaxPassengers);
                                                }
                                            }
                                            case 7 -> {
                                                System.out.println("Enter the new max autonomy: ");
                                                int NewMaxAutonomy = s.nextInt();
                                                if (vehicle.getClass() == ElectricCar.class) {
                                                    ElectricCar ECvehicle = (ElectricCar) vehicle;
                                                    ECvehicle.setMaxAutonomy(NewMaxAutonomy);
                                                } else if (vehicle.getClass() == ElectricTruck.class) {
                                                    ElectricTruck ETvehicle = (ElectricTruck) vehicle;
                                                    ETvehicle.setMaxAutonomy(NewMaxAutonomy);
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                        else
                            System.out.println("no vehicle with such plate number");

                    }
                    case 4 -> {
                        for (Vehicle vehicle : vehicles) {
                            System.out.println(vehicle);
                        }
                    }
                }

            }

            public static void clientManagement () {
                System.out.println("What would you like to do:\n " +
                        "1-Add a client\n" +
                        "2-Edit a client\n" +
                        "3-Delete a client\n");
                int choice = s.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("How many clients would you like to add? ");
                        if(!s.hasNextInt()){
                            System.out.println("you did not enter a number! Please try again");
                            s.next();
                        }
                        int numCToAdd = s.nextInt();
                        if (numCToAdd <= maxNumClients) {
                            for (int i = 0; i < numCToAdd; i++) {
                                System.out.println("What is the client's name: ");
                                String clientName = s.next();
                                clients[i] = new Client(clientName);
                            }
                        }
                        else
                            System.out.println("you entered more clients than what what you decided the maximum" +
                                    " number of clients was");
                    }
                    case 2 -> {
                        System.out.println("Enter the client's name to modify");
                        String clientName = s.next();
                        for (Client client : clients) {
                            if(client!=null){
                                if (clientName.equalsIgnoreCase(client.getClientName())) {
                                System.out.println("What is the client's new name? ");
                                String newName = s.next();
                                client.setClientName(newName);
                            }
                                else
                                    System.out.println("no client with this name found");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter the client's name to delete");
                        String clientName1 = s.next();
                        Client[] newClients = new Client[clients.length - 1];
                        for (int i = 0, j = 0; i < maxNumClients; i++) {
                            if (clients[i] != null) {
                                if (clientName1.equalsIgnoreCase(clients[i].getClientName())) {
                                    continue;
                                }
                                newClients[j++] = clients[i];
                                newClients = clients;

                            }
                        }
                        System.out.println("Client deleted successfully.");
                    }
                }
            }

            public static void leasingOperations () {
            if ((vehicles!=null && vehicles.length!=0)&&(clients!=null&&clients.length!=0)) {
                System.out.println("What would you like to do? \n" +
                        "1-Lease a vehicle to a client \n" +
                        "2-Return a vehicle from a client\n" +
                        "3-Show all vehicles leased by a client\n" +
                        "4-show all leased vehicles");
                int choice = s.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the client's name you would like to lease the car to: ");
                        String EnteredClientName = s.next();
                        Client selectedClient = null;
                        for (Client client : clients) {
                            if (client != null && client.getClientName().equalsIgnoreCase(EnteredClientName)) {
                                selectedClient = client;
                                break;
                            }
                        }
                        if (selectedClient == null) {
                            System.out.println("No client with this name found.");
                            return;
                        }
                        System.out.println("Client found! ");
                        System.out.println("Enter the plate number of the vehicle the client would like to lease," +
                                "here are the available vehicles.");
                        boolean vehicleAvailable = false;
                            for (Vehicle vehicle : vehicles) {
                                if (vehicle != null && selectedClient.getClientVehicle() == null) {
                                    System.out.println(vehicle);
                                    vehicleAvailable = true;
                                }
                            }
                        if (!vehicleAvailable) {
                            System.out.println("No available vehicles to lease.");
                            return;
                        }
                        String plateNumber = s.next();
                        Vehicle selectedVehicle = null;
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle != null && plateNumber.equalsIgnoreCase(vehicle.getPlateNumber())) {
                                selectedVehicle = vehicle;
                                break;

                            }
                        }
                        if(selectedVehicle==null){
                            System.out.println("vehicle not found");
                        }
                        else {
                            System.out.println("Vehicle found, leasing it to client now!");
                            selectedClient.setClientVehicle(selectedVehicle);
                            selectedClient.setClientVehicle(selectedVehicle);
                        }
                    }
                    case 2 -> {
                        System.out.println("Enter the plate number of the vehicle to return among the leased vehicles: ");
                        String plateNumber = s.next();
                        boolean vehicleReturned=false;
                        for(Client client:clients){
                            System.out.println(client.getClientName()+": "+client.getClientVehicle());
                        }
                        for (Client client: clients){
                            if(client!=null&&client.getClientVehicle()!=null&&client.getClientVehicle().getPlateNumber().equalsIgnoreCase(plateNumber)){
                                client.setClientVehicle(null);
                                vehicleReturned=true;
                                System.out.println("Vehicle returned successfully.");
                                break;
                            }
                        }
                        if(!vehicleReturned){
                            System.out.println("no leased vehicle found for the given plate number");
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter the client's name:");
                        String clientName1 = s.next();
                        boolean clientFound=false;
                        for (Client client : clients) {
                            if (client!=null&&client.getClientName().equalsIgnoreCase(clientName1)) {
                                clientFound=true;
                                if(client.getClientVehicle()!=null){
                                    System.out.println("Vehicle leased by "+client.getClientName()+": "+client.getClientVehicle());
                                }else{
                                    System.out.println(client.getClientName()+" has not leased any vehicle. ");
                                }
                                break;
                                }
                            }
                            if(!clientFound){
                                System.out.println("No client with this name found. ");

                            }
                        }
                    case 4 -> {
                        for(Client client:clients){
                            if(client!=null&&client.getClientVehicle()!=null)
                                System.out.println(client.getClientVehicle()+" leased by: "+client.getClientName());
                        }


                    }
                }
            }
            else{
                System.out.println("no registered vehicles or clients");}

            }

            public static void additionalOperations () {
                System.out.println("What would you like to do?\n " +
                        "1-Display the truck with the largest capacity\n " +
                        "2-Create a copy of the electric trucks array");
                int choice = s.nextInt();
                switch (choice) {

                    case 1 -> {
                        if(vehicles!=null&& vehicles.length!=0) {
                            Truck maxTruck = null;
                            int max = 0;
                            for (Vehicle vehicle : vehicles) {
                                if (vehicle instanceof Truck) {
                                    Truck Tvehicle = (Truck) vehicle;
                                    if (Tvehicle.getMaxCapacity() >= max) {
                                        maxTruck = Tvehicle;
                                        max = Tvehicle.getMaxCapacity();
                                    }

                                }
                            }
                            if (maxTruck != null)
                                System.out.println("Truck with the largest capacity is " + maxTruck + "with capacity: " + max);
                            else
                                System.out.println("No trucks found");
                        }
                        System.out.println("no registered vehicles");
                    }
                    case 2 -> {
                        if (electricCars != null && electricCars.length != 0){
                            deepCopy(electricCars);
                            for (ElectricCar car:newCars){
                                System.out.println(car);
                            }
                    }

                    }


                }
            }

            public static  ElectricCar[] deepCopy (ElectricCar[] electricCars){
                newCars = new ElectricCar[electricCars.length];
                for (int i = 0; i < electricCars.length; i++) {
                    Car car = (Car) electricCars[i];
                    newCars[i] = new ElectricCar(electricCars[i].getMake(), electricCars[i].getModel(), electricCars[i].getYear(), electricCars[i].getMaxPassengers(), electricCars[i].getMaxAutonomy());

                }
                return newCars;
            }

    }



