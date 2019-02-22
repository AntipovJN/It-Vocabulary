package sample.interfaces.impl;

import sample.Entity.Word;

public interface Vocabulary {
    void add(Word word);
    void change(Word word,Word newWord);
    void delete(Word word);
}
