package io.ibos.pcs.enums;

import lombok.Getter;

@Getter
public enum Thana {
    THANA1("Thana 1", District.DHAKA),
    THANA2("Thana 2", District.DHAKA),
    THANA3("Thana 3", District.CHITTAGONG),
    THANA4("Thana 4", District.CHITTAGONG);

    private final String name;
    private final District district;

    Thana(String name, District district) {
        this.name = name;
        this.district = district;
    }

}