package sample;

public enum Colour {

    BLUE(0), GREEN(1), YELLOW(2), RED(3), ORANGE(4), PURPLE(5);
    private int value;

    Colour(int value) { this.value = value; }

    public Colour value2Colour(int inputValue) {

        for (Colour colour : Colour.values()) {
            if (colour.value == inputValue) {
                return colour;
            }
        }
        return null;
    }
}
