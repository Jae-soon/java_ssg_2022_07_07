package com.ll.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        // 가장 마지막 명언글의 번호
        int wiseSayingIndexId = 0;

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    String sentence = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = wiseSayingIndexId++;
                    System.out.println(id + "번 명령이 등록되었습니다.");
                    break;

                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}