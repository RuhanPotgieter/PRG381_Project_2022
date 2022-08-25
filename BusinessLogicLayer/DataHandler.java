import java.util.*;
public class DataHandler{
    public static String type;
    public static String date;
    public static String address;
    public static int adults;
    public static int kids;
    public static String food;
    public static String drink;
    public static String dessert;
    public static boolean decoration;
    public static String description;//of the decorations
    static Scanner scn=new Scanner(System.in);
    public DataHandler(){
    }
    public static void Book(){
        System.out.println("Please enter what type of event this will be!\n Your Choices consist of Wedding/Birthday Party");
        type=scn.nextLine();
        System.out.println("Please enter the date of the event");
        date=scn.nextLine();
        System.out.println("Please enter the address of the event");
        address=scn.nextLine();
        System.out.println("Please enter the number of adults for the event");
        adults=scn.nextInt();
        System.out.println("Please enter the number of kids for the event");
        kids=scn.nextInt();
        scn.nextLine();
        System.out.println("Please enter the food for the event");
        food=scn.nextLine();
        System.out.println("Please enter the drink for the event");
        drink=scn.nextLine();
        System.out.println("Please enter the dessert for the event");
        dessert=scn.nextLine();
        System.out.println("Please enter the decoration for the event type either false or true");
        decoration=scn.nextBoolean();
        scn.nextLine();
        if(decoration!=false){
            System.out.println("Please enter the description of the event decorations");
            description=scn.nextLine();
        }else{
            System.out.println();
        }
    }
    public static void CostCalc(){
        double cost=adults*23+kids*15;
        double total;
        if(kids+adults>40){
            double discount=(adults*23)*(0.15);
            total=cost-discount;
        }else{
            total=cost;
        }
        System.out.println("Total costs: " + total);
    }
    public static void printBooking(){
        System.out.println("Type of event: "+type+"\n"+"The date of the event: "+date+"\n"+"Address: "+address+"\n"+"Number of Adults: "+adults+" Number of kids: "+kids
        +"\n"+"Food: "+food+"\n"+"Drink: "+drink+"\n"+"Dessert: "+dessert+"\n"+"Decoration: "+description);
        CostCalc();
    }
}