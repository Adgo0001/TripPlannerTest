import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList trips = new ArrayList<>();
        menu(scan, trips);
    }

    public static void menu(Scanner scan, ArrayList<Trip> trips) {
        System.out.println("\nWhat would u like to do?");
        System.out.println("1. Create a trip.");
        System.out.println("2. Show a list of trips.");
        System.out.println("3. Edit a trip.");
        System.out.println("4. Shut down the program.");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                createTrip(scan, trips);
                break;
            case 2:
                listTrip(scan, trips);
                break;
            case 3:
                editTrip(scan, trips);
                break;
            case 4:
                System.out.println("Shutting down...");
                System.exit(0);
            default:
                System.out.println("Back to the menu...");
                menu(scan, trips);
        }
    }

    public static void createTrip(Scanner scan, ArrayList<Trip> trips) {
        System.out.println("Enter the country:");
        String country = scan.next();
        System.out.println("Enter the duration (in days):");
        int duration = scan.nextInt();
        System.out.println("Enter the price:");
        int price = scan.nextInt();
        System.out.println("Enter the kilometers:");
        int kilometers = scan.nextInt();

        Trip newTrip = new Trip(country, duration, price, kilometers);


        System.out.println("Please confirm if the following is correct: \nCountry: " + country + "\nDuration: " + duration + "\nPrice: " + price + ",-" + "\nKilometers: " + kilometers + "\n\n(Y/N) - (Yes/No)");
        scan.nextLine();
        String svar = scan.nextLine();

        if (svar.equalsIgnoreCase("yes") || (svar.equalsIgnoreCase("y"))) {
            System.out.println("Trip added succesfully!");
            trips.add(newTrip);
        } else if (svar.equalsIgnoreCase("no") || (svar.equalsIgnoreCase("n"))) {
            System.out.println("Trip deleted, try again.");
        } else {
            System.out.println("Invalid input. Try again.");
        }
        menu(scan, trips);
    }

    public static void listTrip(Scanner scan, ArrayList<Trip> trips) {
        if (trips.isEmpty()) {
            System.out.println("No trips available.");
        } else {
            System.out.println("\nList of trips:");
            for (Trip trip : trips) {
                System.out.println(trip);
            }
        }
        menu(scan, trips);
    }

    public static void editTrip(Scanner scan, ArrayList<Trip> trips) {
        if (trips.isEmpty()) {
            System.out.println("No trips available to edit.");
            menu(scan, trips);
            return;
        }
        while (true) {
            System.out.println("Select a trip to edit (type the Trip ID):");
            for (Trip trip : trips) {
                System.out.println(trip);
            }

            System.out.println("Enter the Trip ID:");
            int id = scan.nextInt();
            scan.nextLine(); // Consume newline

            Trip tripToEdit = null;
            for (Trip trip : trips) {
                if (trip.getId() == id) {
                    tripToEdit = trip;
                    break;
                }
            }

            if (tripToEdit == null) {
                System.out.println("No trip found with ID: " + id);
                menu(scan, trips);
                return;
            }

            System.out.println("Editing trip:\n " + tripToEdit);
            System.out.println("Enter the new country (or press ENTER to keep \"" + tripToEdit.getCountry() + "\"):");
            String newCountry = scan.nextLine();
            if (!newCountry.isEmpty()) {
                tripToEdit.setCountry(newCountry);
            }

            System.out.println("Enter the new duration (or press ENTER to keep \"" + tripToEdit.getDuration() + "\"):");
            String durationInput = scan.nextLine();
            if (!durationInput.isEmpty()) {
                int newDuration = Integer.parseInt(durationInput);
                tripToEdit.setDuration(newDuration);
            }

            System.out.println("Enter the new price (or press ENTER to keep \"" + tripToEdit.getPrice() + "\"):");
            String priceInput = scan.nextLine();
            if (!priceInput.isEmpty()) {
                int newPrice = Integer.parseInt(priceInput);
                tripToEdit.setPrice(newPrice);
            }

            System.out.println("Enter the new kilometers (or press ENTER to keep \"" + tripToEdit.getKilometers() + "\"):");
            String kilometersInput = scan.nextLine();
            if (!kilometersInput.isEmpty()) {
                int newKilometers = Integer.parseInt(kilometersInput);
                tripToEdit.setKilometers(newKilometers);
            }

            System.out.println("Trip updated succesfully!");
            System.out.println(tripToEdit);

            menu(scan, trips);
            return;
        }
    }
}
