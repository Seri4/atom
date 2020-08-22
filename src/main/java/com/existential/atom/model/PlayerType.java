package com.existential.atom.model;

import java.util.Arrays;

public enum PlayerType {

    GOALKEEPER("GOALKEEPER"),
    WINGER("WINGER"),
    CENTRE_FORWARD("CENTRE_FORWARD"),
    CENTRE_MIDFIELD("CENTRE_MIDFIELD"),
    FULL_BACK("FULL_BACK"),
    CENTER_BACK("CENTER_BACK"),
    KEEPER("KEEPER");

    private final String value;

    PlayerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PlayerType fromText(String text) {
        return Arrays.stream(values())
                .filter(b1 -> b1.value.equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }
}
