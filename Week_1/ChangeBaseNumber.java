package Week_1;

public class ChangeBaseNumber {

    private String numberConvert;
    private String result;

    public ChangeBaseNumber(String numberConvert) {
        this.numberConvert = numberConvert;
    }

    private boolean validBinary(String input) {
        return input.matches("[01]+");

    }

    private boolean validDecimal(String input) {
        return input.matches("\\d+");
    }

    private boolean validHex(String input) {
        return input.matches("[0-9A-Fa-f]+");
    }

    public void binaryToDec() {
        if (!validBinary(numberConvert)) {
            result = "Invalid";
            return;
        }
        int decimal = Integer.parseInt(numberConvert, 2);
        result = "Decimal = " + decimal;
    }

    public void binaryToHex() {
        if (!validBinary(numberConvert)) {
            result = "Invalid";
            return;
        }
        String hex = Integer.toHexString(Integer.parseInt(numberConvert, 2));
        result = "Hexadecimal = " + hex;
    }

    public void decimalToBinary() {
        if (!validDecimal(numberConvert)) {
            result = "Invalid";
            return;
        }
        String binary = Integer.toBinaryString(Integer.parseInt(numberConvert));
        result = "Binary = " + binary;
    }

    public void decimalToHex() {
        if (!validDecimal(numberConvert)) {
            result = "Invalid";
            return;
        }
        String hex = Integer.toHexString(Integer.parseInt(numberConvert));
        result = "Hexadecimal = " + hex;
    }

    public void hexToBinary() {
        if (!validHex(numberConvert)) {
            result = "Invalid";
            return;
        }
        String binary = Integer.toBinaryString(Integer.parseInt(numberConvert, 16));
        result = "Binary = " + binary;
    }

    public void hexToDec() {
        if (!validHex(numberConvert)) {
            result = "Invalid";
            return;
        }
        int decimal = Integer.parseInt(numberConvert, 16);
        result = "Decimal = " + decimal;
    }

    /**
     *
     */
    public void display() {

        System.out.println(result);
    }

}
