package com.huxl.enums;

/**
 * @author huxl
 * @createDate 2018/3/2 15:28
 */
public enum Week {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    public int value;
    Week(int value) {
        this.value = value;
    }
}


