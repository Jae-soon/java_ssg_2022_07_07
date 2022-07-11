package com.ll.exam;

public class WiseSaying {
    int id;
    String sentence;
    String author;

    public WiseSaying(int id, String sentence, String author) {
        this.id = id;
        this.sentence = sentence;
        this.author = author;
    }

    @Override
    public String toString() { // 개발용
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + sentence + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
