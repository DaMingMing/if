package com.kira.domain;

import java.io.Serializable;

/**
 * Created by rensh on 2016/7/9.
 */
public enum SexEnum implements Serializable{

    MALE(1, "男"), FEMALE(2, "女"), SECRET(3, "保密");
    public int key;
    public String value;

    private SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static int getKeyByValue(String value) {
        int key = 0;
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.value.equals(value)) {
                key = sexEnum.key;
                break;
            }
        }
        return key;
    }

    public static String getValueByKey(int key) {
        String value = null;
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.key == key) {
                value = sexEnum.value;
                break;
            }
        }
        return value;
    }

    public static SexEnum getEnumByKey(int key) {
        SexEnum sexEnum = null;
        for (SexEnum accountType : SexEnum.values()) {
            if (accountType.key == key) {
                sexEnum = accountType;
                break;
            }
        }
        return sexEnum;
    }


}
