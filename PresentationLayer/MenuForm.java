import java.util.*;
public class MenuForm {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        boolean stop=false;
        while(!stop) {
            System.out.println("This is a basic application (Purpose is for testing only)");
            System.out.println("1. Book");
            System.out.println("2. Check booking");
            System.out.println("3. Exit");
            int choice=scn.nextInt();
            switch(choice) {
                case 1:
                    DataHandler.Book();
                    break;
                case 2:
                DataHandler.printBooking();
                    break;
                case 3:
                    stop=true;
                    break;
                default:
                    System.out.println("Please enter the number of your choice!");
            }
        }
        scn.close();
    }
}

