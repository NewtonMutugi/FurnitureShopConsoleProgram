import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        String password, confirm_password;
        do {
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            System.out.println("Confirm your password: ");
            confirm_password = sc.nextLine();
            if (password.equals(confirm_password)) {
                String fileNme = 
                FileOutputStream fos=new FileOutputStream(u, true);
                fos.write(username.getBytes());
                fos.close();
                FileOutputStream fos1=new FileOutputStream(password, true);
                fos1.write(password.getBytes());
                fos1.close();
                FileOutputStream fos2=new FileOutputStream(email, true);
                fos2.write(email.getBytes());
                fos2.close();
                System.out.println("Your account has been created successfully");
                break;
            } else {
                System.out.println("Passwords do not match");
            }
        } while (true);

        Person person = new Person(username, password, email);
        try {
            File file = new File("users.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("You have successfully signed up!");

            login();
        } catch (IOException e) {

        }
    }

        static void login () {
        ArrayList<Person> users = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your username: ");
            String username = sc.nextLine();
            System.out.println("Enter your password: ");
            String password = sc.nextLine();
            try {
                File file = new File("users.txt");
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] user = data.split(",");
                    users.add(new Person(user[0], user[1], user[2]));
                }
                myReader.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("You have successfully logged in!");
        }

        static void landing_page () {
            System.out.println("Welcome to the Furniture Shop!");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sign_up();
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

        static void user_page () {
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
                    pine();
                    break;
                case 3:
                    mahogany();
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
