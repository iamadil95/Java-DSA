import java.util.ArrayList;
import java.util.Scanner;

public class NoteTakingApp {
    private ArrayList<String> notes;

    public NoteTakingApp(){
        notes = new ArrayList<>();
    }

    public void addNote(String note){
        notes.add(note);
    }

    public void displayNotes() 
    {
        for (int i = 0; i < notes.size(); i++) 
        {
            System.out.println((i+1)+"."+notes.get(i));
        } // added closing brace
    }

    public static void main(String[] args) 
    {
        NoteTakingApp app = new NoteTakingApp();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) 
        {
            System.out.println("1. Add note");
            System.out.println("2. Display notes");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            userInput = scanner.nextLine();

            if (userInput.equals("1")) 
            {
                System.out.println("Enter your note:");
                String note = scanner.nextLine();
                app.addNote(note);
            } 
            else if (userInput.equals("2")) 
            {
                app.displayNotes();
            } 
            else if (userInput.equals("3")) 
            {
                break;
            } 
            else 
            {
                System.out.println("Invalid choice. Please try again,");
            }
        }
        scanner.close(); // removed extra semicolon
    }
}