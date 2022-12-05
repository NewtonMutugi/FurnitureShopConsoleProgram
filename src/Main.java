import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        landing_page();

    }

    static String currentUser;
    static int WoodChoice;

    static void sign_up() throws IOException {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        String password, confirm_password;
        String currentPath = System.getProperty("user.dir");
        currentPath.trim();
        String fileName = currentPath + "\\files\\Users.csv";
        File file = new File(fileName);
        do {
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            System.out.println("Confirm your password: ");
            confirm_password = sc.nextLine();
            if (password.equals(confirm_password)) {
                Person person = new Person(username, password);
                System.out.println(fileName);

                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write(person.getUsername() + "," + person.getPassword() + "\n");
                    writer.close();
                } else {
                    System.out.println("File already exists.");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write(person.getUsername() + "," + person.getPassword() + "\n");
                    writer.close();

                }
                break;
            } else {
                System.out.println("Passwords do not match");
            }
        } while (true);

        Person person = new Person(username, password);
        try {


            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("You have successfully signed up!");

            landing_page();
        } catch (IOException e) {

        }
    }


    static void login() throws IOException {
        ArrayList<Person> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader("files\\Users.csv"));
            {
                String data = br.readLine();
                while (data != null) {

                    String[] creds = data.split(",");
                    Person person = new Person(creds[0], creds[1]);
                    users.add(person);
                    data = br.readLine();
                }

            }

            for (Person user : users) {

                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("You have successfully logged in!");
                    System.out.println("Welcome " + username);
                    currentUser = username;
                    user_page();
                    break;

                }

            }

            System.out.println("Invalid username or password");
            landing_page();


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        br.close();
    }

    static void landing_page() throws IOException {
        System.out.println("Welcome to the Furniture Shop!");
        System.out.println("1. Sign up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                try {
                    sign_up();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Thank you for visiting us!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    static void user_page() {

        System.out.println("Welcome to the Furniture Shop!");
        System.out.println("Select wood type: ");
        System.out.println("1. Oak");
        System.out.println("2. Pine");
        System.out.println("3. Mahogany");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        WoodChoice = sc.nextInt();
        switch (WoodChoice) {
            case 1:
                Oak oak = new Oak();
                oak.getPriceInKsh();
                System.out.println("Your total price is: " + oak.PriceInKsh);
                break;
            case 2:
                Pine pine = new Pine();
                pine.getPriceInKsh();
                System.out.println("Your total price is: " + pine.PriceInKsh);

                break;
            case 3:
                Mahogany mahogany = new Mahogany();
                mahogany.getPriceInKsh();
                System.out.println("Your total price is: " + mahogany.PriceInKsh);

                break;
            case 4:
                System.out.println("Thank you for visiting us!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }

    public void invoiceGeneration() throws IOException {
        Table table = null;
        if(WoodChoice == 1){
            table = new Oak();
        }else if(WoodChoice == 2){
            table = new Mahogany();
        }else if(WoodChoice == 3){
            table = new Pine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("files\\Users.csv"));
        writer.write("\n\n" +

                "----------------------------------------------------------------------------\n" +
                " *********************ANTIQUE FURNITURE KENYA LIMITED***********************\n" +
                "                             Westlands, Nairobi                             \n" +
                "                                                                            \n" +
                "      NAME: " + currentUser + "                                                 \n" +
                "                                                                            \n" +
                "      TABLE DESCRIPTION                                                     \n" +
                "    _____________________                                                   \n" +
                "        Wood type:                                                          \n" +
                "        Length of Table: " + table.getLengthInCm() + "                       \n" +
                "        Width of Table: " + table.getWidthInCm() + "                         \n" +
                "        Number of drawers: " + table.getNumDrawers() + "                     \n" +
                "        Number of tables: " + table.getNumTables() + "                       \n" +
                "                                                                            \n" +
                "Your Total Price is:                                                    \n" +
                "                                                                            \n" +
                "********************WELCOME BACK TO ANTIQUE FURNITURE***********************\n");
        writer.close();


    }
}
