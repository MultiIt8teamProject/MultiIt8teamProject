package com.recipe.member.Session;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static final Map<String, String> sessionData = new HashMap<>();

    public static void setAttribute(String key, String value) {
        sessionData.put(key, value);
    }

    public static String getAttribute(String key) {
        return sessionData.get(key);
    }

    public static void removeAttribute(String key) {
        sessionData.remove(key);
    }

    // 데이터 저장
    //    SessionManager.setAttribute("message", "Hello, world!");

    // 데이터 불러오기
    //    String message = SessionManager.getAttribute("message");
}