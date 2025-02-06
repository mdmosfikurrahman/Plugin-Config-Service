package io.ibos.pcs.enums;

import lombok.Getter;

@Getter
public enum Division {
    DHAKA("Dhaka"),
    CHITTAGONG("Chittagong"),
    RAJSHAHI("Rajshahi"),
    KHULNA("Khulna");

    private final String name;

    Division(String name) {
        this.name = name;
    }

}