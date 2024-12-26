package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private FelineLion felineLion;

    public Lion (String sex, FelineLion felineLion) throws Exception {
        this.felineLion = felineLion;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else { throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }


    public int getKittens() {
        return felineLion.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return felineLion.getFood("Хищник");
    }
}
