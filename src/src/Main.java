import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (true){
            int choice = 0;
            System.out.println();
            System.out.println("---------------------------------------------------------------");
            System.out.println("Welcome to decrypt/encrypt program. Choose your action by entering a number of an action: ");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Brute Force");
            System.out.println("4. Exit the program");

            if (console.hasNextInt()){
                choice = console.nextInt();
                console.nextLine();
            } else {
                System.out.println("please enter a number to continue.");
            }

            if (choice == 1){
                Utils.askChoice();
                choice = console.nextInt();
                if (choice == 2) {
                    ArrayList<Character> file = FileManipulation.read("message.txt");
                    String encryptedFile = EncryptionProgram.encrypt(file, 2);
                    System.out.println("The result is: ");
                    System.out.println(encryptedFile);
                    FileManipulation.write("encryptedMessage.txt", encryptedFile);
                    System.out.println("File have been wrote to the projects root folder.");
                    continue;
                }

// if default settings aren't used, then:
                console.nextLine();
                System.out.println("MAKE SURE TO WRITE A FULL PATH WITH \\\\ INSTEAD OF \\");
                System.out.println("Please enter a path to your file: ");
                String path = console.nextLine();
                System.out.println("Enter a path where to save the result: ");
                String destination = console.nextLine();
                System.out.println("Enter a key: ");
                int key = console.nextInt();

                ArrayList<Character> file = FileManipulation.read(path);
                String encryptedFile = EncryptionProgram.encrypt(file, key);
                System.out.println("The result is: ");
                System.out.println(encryptedFile);
                FileManipulation.write(destination, encryptedFile);
                System.out.printf("File have been wrote to the destination: %s\n", destination);
            }

            if (choice == 2) {
                Utils.askChoice();
                choice = console.nextInt();
                if (choice == 2) {
                    ArrayList<Character> file = FileManipulation.read("encryptedMessage.txt");
                    String decryptedFile = EncryptionProgram.decrypt(file, 2);
                    System.out.println("The result is: ");
                    System.out.println(decryptedFile);
                    FileManipulation.write("decryptedMessage.txt", decryptedFile);
                    System.out.println("File have been wrote to the projects root folder.");
                    continue;
                }
                console.nextLine();
                System.out.println("MAKE SURE TO WRITE A FULL PATH WITH \\\\ INSTEAD OF \\");
                System.out.println("Please enter a path to your file: ");
                String path = console.nextLine();
                System.out.println("Enter a path where to save the result: ");
                String destination = console.nextLine();
                System.out.println("Enter a key: ");
                int key = console.nextInt();

                ArrayList<Character> file = FileManipulation.read(path);
                String decryptedFile = EncryptionProgram.decrypt(file, key);
                System.out.println("The result is: ");
                System.out.println(decryptedFile);
                FileManipulation.write(destination, decryptedFile);
                System.out.printf("File have been wrote to the destination: %s\n", destination);
            }

            if (choice == 3) {
                Utils.askChoice();
                choice = console.nextInt();
                if (choice == 2) {
                    ArrayList<Character> file = FileManipulation.read("encryptedMessage.txt");
                    String decryptedFile = EncryptionProgram.bruteForce(file);
                    System.out.println("The result is: ");
                    System.out.println(decryptedFile);
                    FileManipulation.write("bruteForcedMessage.txt", decryptedFile);
                    System.out.println("File have been wrote to the projects root folder.");
                    continue;
                }

                console.nextLine();
                System.out.println("MAKE SURE TO WRITE A FULL PATH WITH \\\\ INSTEAD OF \\");
                System.out.println("Please enter a path to your file: ");
                String path = console.nextLine();
                System.out.println("Enter a path where to save the result: ");
                String destination = console.nextLine();

                ArrayList<Character> file = FileManipulation.read(path);
                String decryptedFile = EncryptionProgram.bruteForce(file);
                System.out.println("The result is: ");
                System.out.println(decryptedFile);
                FileManipulation.write(destination, decryptedFile);
                System.out.printf("File have been wrote to the destination: %s\n", destination);
            }

            if (choice == 4) {
                System.out.println("Exiting.");
                break;
            }
        }
    }
}
