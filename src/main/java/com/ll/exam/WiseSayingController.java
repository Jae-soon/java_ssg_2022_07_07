package com.ll.exam;

import java.util.ArrayList;
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
        for (int i = wiseSayingRepository.wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayingRepository.wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.sentence, wiseSaying_.author);
        }
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingRepository.wiseSayingLastId; // 명언 글 번호 증가

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingRepository.wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void modify(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }
        WiseSaying foundwiseSaying = wiseSayingRepository.findById(paramId);
        int id = foundwiseSaying.id;
        String sentence = foundwiseSaying.sentence;

        if (foundwiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        System.out.printf("%d번 명언을 수정합니다.\n", id);
        System.out.printf("기존 명언 : %s\n", foundwiseSaying.sentence);
        System.out.printf("기존 작가 : %s\n", foundwiseSaying.author);
        System.out.print("새 명언 : ");
        foundwiseSaying.sentence = sc.nextLine().trim();
        System.out.print("새 작가 : ");
        foundwiseSaying.author = sc.nextLine().trim();

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    public void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingRepository.wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }
}