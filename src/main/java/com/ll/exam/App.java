package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    List<WiseSaying> wiseSayings;
    int wiseSayingLastId;

    public App() {
        sc = new Scanner(System.in);

        // 가장 마지막 명언글의 번호
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "목록":
                    wiseSayingController.list(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
