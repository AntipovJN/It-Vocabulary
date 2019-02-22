package sample.DAO;

import sample.Entity.Word;
import sample.Entity.WordDB;
import sample.interfaces.WordCollection;
import sample.utils.HibernateSessionFactoryUtil;

public class WordDAO {
    private static WordCollection wordCollection = new WordCollection() {
    };

    public static void addWord(String engVerb, String rusVerb) {
        System.out.println(engVerb+"  "+rusVerb);
        wordCollection.add(new Word(new WordDB(engVerb, rusVerb)));
    }

    public static void editWord(Word word, String engVerb, String rusVerb) {
        getWordCollection().change(word, new Word(new WordDB(engVerb,rusVerb)));
    }
    public static void remove(Word word){
        wordCollection.delete(word);
    }

    public static WordCollection getWordCollection() {
        return wordCollection;
    }
}
