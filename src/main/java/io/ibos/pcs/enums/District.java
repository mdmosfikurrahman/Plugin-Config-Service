package io.ibos.pcs.enums;

import lombok.Getter;

@Getter
public enum District {
    DHAKA("Dhaka", Division.DHAKA),
    CHITTAGONG("Chittagong", Division.CHITTAGONG),
    RAJSHAHI("Rajshahi", Division.RAJSHAHI),
    KHULNA("Khulna", Division.KHULNA);

    private final String name;
    private final Division division;

    District(String name, Division division) {
        this.name = name;
        this.division = division;
    }

}