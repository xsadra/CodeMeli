package controller;

import model.CityCode;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Controller {
    public void start() {

        String codeMeli = getCodeMeli();
        if (!new Validation().validator(codeMeli)) {
            display("wrong Number!");
            return;
        }

        FileReader fileReader = new FileReader();
        Optional<List<String>> optionalList = fileReader.asLines("source_file/city_code.txt");
        //optionalList.ifPresent(lines -> lines.forEach(System.out::println));

        if (!optionalList.isPresent()) {
            display("Cannot read Data!");
            return;
        }

        List<String> lines = optionalList.get();
        List<CityCode> cityCodes = new Parser().asList(lines);
        //cityCodes.forEach(Controller::display);

        String cityName = getCityName(codeMeli, cityCodes);
        display(cityName);

    }

    private String getCityName(String codeMeli, List<CityCode> cityCodes) {
        String code = codeMeli.substring(0, 3);
        for (CityCode cityCode : cityCodes) {
            if (cityCode.getCodes().contains(code)) {
                return cityCode.getName();
            }
        }
        return "City not found!";
    }

    private String getCodeMeli() {
        display("Enter number: ");
        return new Scanner(System.in).nextLine();
    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static void display(CityCode cityCode) {
        System.out.println(cityCode);
    }
}
