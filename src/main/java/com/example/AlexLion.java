package com.example;

import java.util.Arrays;
import java.util.List;

public class AlexLion extends Lion {
    public AlexLion (FelineLion felineLion) throws Exception {
        super("Самец", felineLion);
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

}
