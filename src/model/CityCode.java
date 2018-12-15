package model;

import java.util.List;

public class CityCode {
    private String name;
    private List<String> codes;

    public CityCode(String name, List<String> codes) {
        this.name = name;
        this.codes = codes;
    }

    public String getName() {
        return name;
    }

    public List<String> getCodes() {
        return codes;
    }

    @Override
    public String toString() {
        return "[name: " + name +", codes: " + codes +']';
    }
}
