package com.ll.exam;

public class Word {
    String sentence;
    String author;
    int id;

    public Word(int id, String sentence, String author) {
        this.author = author;
        this.id = id;
        this.sentence = sentence;
    }
}
