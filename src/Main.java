import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        boolean done = true;
        Scanner in = new Scanner(System.in);

        while (done) {
            System.out.println("\nMenu: ");
            System.out.println("A - Add item to the list");
            System.out.println("D - Delete item from the list");
            System.out.println("I - Insert an item in the list");
            System.out.println("P - Print all items in the list");
            System.out.println("Q - Quit the program");

            String choice = SafeInput.getRegExString(in, "Enter your choice: ", "[AaDdIiPpQq]").toUpperCase();
            switch (choice) {
                case "A":
                    addItem(list, in);
                    break;
                case "D":
                    deleteItem(list, in);
                    break;
                case "I":
                    insertItem(list, in);
                    break;
                case "P":
                    printList(list);
                    break;
                case "Q":
                    done = false;
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
        in.close();
    }

    private static void addItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item you want to add: ");
        list.add(item);
        System.out.println("Item " + item + " added to the list");
    }

    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        printList(list);
        int index = SafeInput.getRangedInt(in, "Enter the item number to delete: ", 1, list.size());
        list.remove(index - 1);
        System.out.println("Item " + list.remove(index - 1) + " deleted from list");
    }

    private static void insertItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty add the first items");
            addItem(list, in);
            return;
        }
        printList(list);
        int index = SafeInput.getRangedInt(in, "Enter the position to insert the item (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert: ");
        list.add(index - 1, item);
        System.out.println("Item " + list.remove(index - 1) + " inserted from list");
    }

    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("\n Current List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static boolean quitProgram(Scanner in) {
        boolean quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N): ");
        if (quit) {
            System.out.println("Goodbye");
        }
        return quit;
    }
}

