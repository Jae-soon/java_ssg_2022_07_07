package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.sentence, wiseSaying_.author);
        }
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingRepository.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }

    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying foundwiseSaying = wiseSayingRepository.findById(paramId);

        if (foundwiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        System.out.printf("%d번 명언을 수정합니다.\n", paramId);
        System.out.printf("기존 명언 : %s\n", foundwiseSaying.sentence);
        System.out.printf("기존 작가 : %s\n", foundwiseSaying.author);
        System.out.print("새 명언 : ");
        String sentence = sc.nextLine().trim();
        System.out.print("새 작가 : ");
        String author = sc.nextLine().trim();

        wiseSayingRepository.modify(paramId, sentence, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId;
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        wiseSayingRepository.remove(paramId);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}