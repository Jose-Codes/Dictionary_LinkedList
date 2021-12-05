
public class WordMeaningNode {

    WordMeaning data;
    WordMeaningNode next;

    public WordMeaningNode (WordMeaning data){
        this.data = data;
        next = null;
    }

    public WordMeaning getData() {
        return data;
    }

}
