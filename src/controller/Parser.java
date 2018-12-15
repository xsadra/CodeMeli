package controller;

import model.CityCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public List<CityCode> asList(List<String> codes) {
        return codes.stream()
                .map(code -> code.split(";"))
                .filter(strings -> !strings[0].trim().isEmpty())
                .filter(strings -> !(strings[0].trim() == "***"))
                .map(this::toObject)
                .collect(Collectors.toList());
    }

    private CityCode toObject(String[] strings) {
        String code = strings[0];
        String[] codes = code.split(",");
        List<String> codesList = Arrays.asList(codes);
        String name = strings[1];

        return new CityCode(name, codesList);
    }
}
