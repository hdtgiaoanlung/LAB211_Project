package controller;

import bo.BaseConverter;
import bo.NumberInputer;

public class BaseConverterController {

    private BaseConverter baseConverter;
    private NumberInputer numberInputer;

    private Number number;

    public BaseConverterController(){
        numberInputer = new NumberInputer();
    }

    public void convertByChoice(int baseChoice, int convertChoice) {
        if(baseChoice == convertChoice) {
            System.err.println("Please input another base type!");
        } else {
            switch (convertChoice) {
                case 1:

            }
        }
    }


}
