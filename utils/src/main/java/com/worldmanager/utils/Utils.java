package com.worldmanager.utils;

import java.time.LocalDateTime;

public class Utils {

    public static LocalDateTime now() {
        return LocalDateTime.now().withNano(0);
    }

}
