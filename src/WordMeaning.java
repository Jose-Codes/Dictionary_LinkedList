public class WordMeaning {

    String word;
    String definition;

    public WordMeaning (String word, String definition){
        this.word = word;
        this.definition = "- " + definition;
    }

    public String getWord(){
        return word;
    }

    public String getDefinition (){
        return definition;
    }

    public void addDefinition(String newDefinition){
        definition += "\n\t- " + newDefinition;
    }
}
