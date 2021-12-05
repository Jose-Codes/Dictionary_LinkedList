import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Dictionary {


    public static void main (String [] args){
        WordList activeList = new WordList();
        WordList deletedList = new WordList();
        WordMeaning wordMeaning;
        String word;
        String definition;
        boolean done = false;
        int userChoice;

        while (!done){
            userChoice = GetData.getInt("\nPlease select one of the following choices:\n1. Add word and definition\n2. Add a definition to existing word\n" +
                    "3. Delete a word\n4. Display active words\n5. Display deleted words\n6. Quit");
            switch (userChoice){
                case 1: // add a word and definition
                    word = GetData.getString("Enter the word you would like to add.");
                    definition = GetData.getString("Enter the definition of the word.");
                    wordMeaning = new WordMeaning(word, definition);
                    activeList.insert(wordMeaning);
                break;
                case 2: // add another definition to a word
                    word = GetData.getString("Enter the word you would like to add more meaning to.");
                    definition = GetData.getString("Enter the definition of the word.");
                    if(activeList.search(word.toLowerCase(), definition))
                        JOptionPane.showMessageDialog(null, "Meaning was added successfully!", "Success" ,JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "The word is not currently in the Dictionary", "Word not found", JOptionPane.ERROR_MESSAGE);
                break;
                case 3: // delete a word
                    word = GetData.getString("Enter the word you would like to delete.");
                        activeList.removeNode(word.toLowerCase());
                        deletedList.insert(new WordMeaning(word, " "));
                break;
                case 4: // show active words
                    display(activeList.toString(), "Dictionary", JOptionPane.INFORMATION_MESSAGE);
                break;
                case 5: // show deleted words
                    display(deletedList.deletedToString(), "Deleted Words", JOptionPane.INFORMATION_MESSAGE);
                break;
                case 6:
                    done = true;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Please enter a valid choice.");
                break;

            }
        }
    }

    static void display(String s, String heading, int MESSAGE_TYPE){
        JTextArea text = new JTextArea(s,20,40);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane,heading,MESSAGE_TYPE);
    }
}
