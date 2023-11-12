package de.bcxp.school.devops.troubleshooting.behavior;

public enum Behavior {
    VERY_NAUGHTY(4),
    NAUGHTY(3),
    NEUTRAL(2),
    NICE(1),
    VERY_NICE(0);

    private final int value;

    Behavior(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
