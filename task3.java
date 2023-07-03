import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task3 {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase())
                    || contact.getPhoneNumber().contains(searchTerm.toLowerCase())
                    || contact.getEmailAddress().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class AddressBookSystem {
    private AddressBook addressBook;
    private Scanner scanner;

    public AddressBookSystem() {
        addressBook = new AddressBook();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Address Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contacts");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    displayAllContacts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, emailAddress);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private void removeContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        List<Contact> searchResults = addressBook.searchContacts(name);
        if (searchResults.isEmpty()) {
            System.out.println("Contact not found.");
        } else if (searchResults.size() == 1) {
            Contact contact = searchResults.get(0);
            addressBook.removeContact(contact);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Multiple contacts found. Please provide more specific details.");
            displayContacts(searchResults);
        }
    }

    private void searchContacts() {
        System.out.print("Enter search term: ");
        String searchTerm =scanner;
    }