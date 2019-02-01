package sample;

public enum Colour {

    BLUE(0), GREEN(1), YELLOW(2), RED(3), BLACK(4), WHITE(5);
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
