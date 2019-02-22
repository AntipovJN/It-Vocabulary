package sample.interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sample.Entity.Word;
//import sample.Entity.WordDB;
import sample.Entity.WordDB;
import sample.interfaces.impl.Vocabulary;
import sample.utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;


public abstract class WordCollection implements Vocabulary {
    private ObservableList<Word> wordList = FXCollections.observableArrayList(getAll());

    @Override
    public void add(Word word) {
        WordDB wordDB=new WordDB(word.getEngVerb(),word.getRusVerb());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction save = session.beginTransaction();
        session.save(wordDB);
        save.commit();
        session.close();
        wordList.add(word);
    }

    public void change(Word word, Word newWord) {
        WordDB wdb=new WordDB(newWord.getEngVerb(),newWord.getRusVerb());
        wdb.setId(word.getId());
        word.setRusVerb(newWord.getRusVerb());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.update(wdb);
        tr.commit();
        session.close();
    }

    public ArrayList<Word> getAll(){
        List<WordDB> list = (List<WordDB>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From sample.Entity.WordDB").list();
        ArrayList<Word> list2 = new ArrayList<>();
        for (WordDB w : list) {
           list2.add(new Word(w));
        }
        return list2; }
    @Override
    public void delete(Word word) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();
        session.delete(returnByValue(word));
        trx.commit();
        session.close();
        getWordList().remove(word);
    }

    public  WordDB returnByValue (Word word){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(WordDB.class, word.getId());

    }
    public ObservableList<Word> getWordList() {

        return wordList;
    }

    @Override
    public String toString() {
        return "WordCollection{" +
                "wordList=" + wordList +
                '}';
    }


}
