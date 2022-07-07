package com.ll.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() {
        int id;
        String sentence;
        String author;
        ArrayList<Word> wordList = new ArrayList<>();
        Word word1;

        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    id = wordList.size() + 1;
                    System.out.print("명언 : ");
                    sentence = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    author = sc.nextLine().trim();
                    word1 = new Word(id, sentence, author);
                    wordList.add(word1);
                    System.out.println(wordList.size() + "번 명령이 등록되었습니다.");
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}