package controller;

public class Validation {
    public Boolean validator (String codeMeli){

        String reversedCode = new StringBuilder(codeMeli).reverse().toString();

        int firstDigit = getCurrentDigit(reversedCode,1);
        int sum = 0;

        for (int index = 2; index < 11; index++) {
            int currentDigit  = getCurrentDigit(reversedCode, index);
            sum += (currentDigit * index);
        }

        int mod = sum % 11;

        return (11 - mod) == firstDigit;
    }

    private int getCurrentDigit(String reversedCode, int index) {
        String currentChar = reversedCode.split("")[index - 1];
        return Integer.valueOf(currentChar);
    }


}
