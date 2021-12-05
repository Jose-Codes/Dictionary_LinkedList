import javax.swing.*;

public class WordList {


    WordMeaningNode list;

    WordList(){
        list = null;
    }

    public void insert(WordMeaning word){
        WordMeaningNode temp = new WordMeaningNode(word);

        if(isEmpty())
            list = temp; // if the list is empty then make temp the first node

            // traverse through the list until you find the right position to insert
        else{
            WordMeaningNode back = null;
            WordMeaningNode current = list;
            boolean found = false;

            while(current != null && !found) {
                if (temp.getData().getWord().compareToIgnoreCase(current.getData().getWord()) < 0)
                found = true;
                else{
                    back = current;
                    current = current.next;
                }
              } // end of while
            temp.next = current;
            if(back == null) // if back is null then that means the list is empty
                list = temp;
            else
                back.next = temp; // set back to point to the new node
            }
        }

    boolean isEmpty(){
        return list == null?true:false;
    }

    public String toString(){
        String result = "";
        WordMeaningNode current = list;

        while (current != null){
            result += current.data.getWord() + " " + current.data.getDefinition() + "\n";
            current = current.next;
        }

        return result;
    }


    public void removeNode(String word){

        if(isEmpty())
            return;

        try {
            WordMeaningNode back = null;
            WordMeaningNode current = list;
            boolean found = false;

            while (current != null && !found) {
                if (current.getData().getWord().toLowerCase().equals(word)) {
                    System.out.println(current.getData().getWord() + " word found");
                    found = true;
                } else {
                    back = current;
                    current = current.next;
                }
            } // end of while

            if (back == null && current.next == null) {
                list = back; // the list only has one node
            }
            else if (back == null && current.next != null) {
                list = current.next; // if the word removed is the first word of the list and the list has at least 2 nodes
            }
            else {
                back.next = current.next; // The word is either in the middle of the list or at the end of the list
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "This word is not currently active in the dictionary"
                    , "Word not found", JOptionPane.ERROR_MESSAGE);
        }
    }


    public String deletedToString(){
        String result = "";
        WordMeaningNode current = list;

        while (current != null){
            result += current.getData().getWord() + "\n";
            current = current.next;
        }

        return result;
    }

    public boolean search(String word, String meaning){
        WordMeaningNode current = list;
        boolean found = false;

        while (current != null && !found){
            if (current.getData().getWord().toLowerCase().equals(word)) {
                current.getData().addDefinition(meaning);
                found = true;
            }

            current = current.next;
        }
        return found;
    }
}
