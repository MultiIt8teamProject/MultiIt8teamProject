package com.recipe.member.moveButton;

import com.recipe.member.UI.TestUI1;

public class MoveButton {

    public static void move(String page) {
        // 해당 ID에 대한 동작을 수행하는 로직을 여기에 구현
        TestUI1 testUI1 = new TestUI1();
        testUI1.open(page);
    }
}
