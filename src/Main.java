import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
                    landing_page();
                }
                break;
            } else {
                System.out.println("Passwords do not match");
            }
        } while (true);

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
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    static void user_page() throws IOException {

        System.out.println("Welcome to the Furniture Shop!");
        System.out.println("Select wood type: ");
        System.out.println("1. Oak");
        System.out.println("2. Pine");
        System.out.println("3. Mahogany");
        System.out.println("4. Logout");
        Scanner sc = new Scanner(System.in);
        WoodChoice = sc.nextInt();
        switch (WoodChoice) {
            case 1:
                Table oak = new Oak();
                oak.getPriceInKsh();
                invoiceGeneration(oak.lengthInCm, oak.widthInCm, oak.numberOfDrawers, oak.numOfTables, oak.PriceInKsh);
                break;
            case 2:
                Table pine = new Pine();
                pine.getPriceInKsh();

                invoiceGeneration(pine.lengthInCm, pine.widthInCm, pine.numberOfDrawers, pine.numOfTables, pine.PriceInKsh);
                break;
            case 3:
                Table mahogany = new Mahogany();
                mahogany.getPriceInKsh();
                invoiceGeneration(mahogany.lengthInCm, mahogany.widthInCm, mahogany.numberOfDrawers, mahogany.numOfTables, mahogany.PriceInKsh);
                break;
            case 4:
                System.out.println("Thank you for visiting us!");
                landing_page();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }


    public static void invoiceGeneration(double length, double width, int drawers, int quantity, double price) {
        Table table = null;
        String wood = null;
        if (WoodChoice == 1) {
            table = new Oak();
            wood = "Oak";
        } else if (WoodChoice == 2) {
            table = new Mahogany();
            wood = "Mahogany";
        } else if (WoodChoice == 3) {
            table = new Pine();
            wood = "Pine";
        }
        BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        price = bd.doubleValue();
        try {
            String invoice = "\n\n" +

                    "----------------------------------------------------------------------------\n" +
                    " *********************ANTIQUE FURNITURE KENYA LIMITED***********************\n" +
                    "                             Westlands, Nairobi                             \n" +
                    "                                                                            \n" +
                    "      NAME: " + currentUser + "                                             \n" +
                    "                                                                            \n" +
                    "      TABLE DESCRIPTION                                                     \n" +
                    "    _____________________                                                   \n" +
                    "        Wood type:         " + wood + "                                             \n" +
                    "        Length of Table:   " + length + "                                     \n" +
                    "        Width of Table:    " + width + "                                       \n" +
                    "        Number of drawers: " + drawers + "                                  \n" +
                    "        Number of tables:  " + quantity + "                                  \n" +
                    "                                                                            \n" +
                    String.format("Total price is Kshs. %.2f", price) +"                    \n" +

                    "                                                                            \n" +
                    "********************WELCOME BACK TO ANTIQUE FURNITURE***********************\n";
            BufferedWriter writer = new BufferedWriter(new FileWriter("files\\invoices\\" + currentUser + ".txt"));
            writer.write(invoice);
            System.out.println("Invoice generated successfully! Invoice is in the " + currentUser + ".txt file");
            System.out.println(invoice);
            writer.close();
            landing_page();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
