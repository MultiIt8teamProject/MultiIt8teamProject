package com.recipe.run;

import com.recipe.menuUI.BoardUI;

public class MainController {
    public static void returnToHome() {
        BoardUI boardUI = new BoardUI(); // BoardUI 인스턴스 생성
        boardUI.open(); // 초기 화면으로 돌아가는 메서드 호출
    }
}

