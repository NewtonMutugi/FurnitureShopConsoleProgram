import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        landing_page();
    }

    static void sign_up() throws IOException {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        String password, confirm_password;
        do {
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            System.out.println("Confirm your password: ");
            confirm_password = sc.nextLine();
            if (password.equals(confirm_password)) {
                Person person = new Person(username, password);
                String fileName = "G:\\Education\\Daystar Work\\Semesters\\Aug 2022\\ACS 213\\MiniProject\\files\\Users.csv";
                File file = new File(fileName);
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write(person.getUsername() + "," + person.getPassword() + "\n");
                    writer.close();
                } else {
                    System.out.println("File already exists.");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write(person.getUsername() + "," + person.getPassword());
                    writer.close();

                }
                break;
            } else {
                System.out.println("Passwords do not match");
            }
        } while (true);

        Person person = new Person(username, password);
        try {
            String fileName = "G:\\Education\\Daystar Work\\Semesters\\Aug 2022\\ACS 213\\MiniProject\\files\\Users.csv";
            File file = new File(fileName);
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

    static void login() {
        ArrayList<Person> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        Scanner myReader = null;
        try {
            String fileName = "G:\\Education\\Daystar Work\\Semesters\\Aug 2022\\ACS 213\\MiniProject\\files\\Users.csv";
            File file = new File(fileName);
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] user = data.split(",");
                Person person = new Person(user[0], user[1]);
                users.add(person);
            }
            while (true) {
                for (Person user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println("You have successfully logged in!");
                        break;
                    } else {
                        System.out.println("Invalid username or password");
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        myReader.close();
    }

    static void landing_page() {
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
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                System.out.println("Thank you for visiting us!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

    }
}
