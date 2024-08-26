import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner();

        menu(scan);
    }

    public static void menu(Scanner scan) {
        System.out.println("What would u like to do?");
        System.out.println("1. Create a trip.");
        System.out.println("2. Show a list of trips.");
        System.out.println("3. Shut down the program.");
        int choice = scan.nextInt();

        switch(choice){
            case 1:
                createTrip();
                break;
            case 2:
                listTrip();
                break;
            case 3:
                System.out.println("Shutting down...");
                System.exit(0);
            default:
                System.out.println("Back to the menu...");
                menu(scan);
        }
    }

    public static void createTrip() {

    }

    public static void listTrip() {

    }
}
