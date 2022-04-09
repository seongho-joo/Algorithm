package _2018_KAKAO_BLIND_RECRUITMENT.P3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("running time = " + Solution.solution(3,
            new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
                "Seoul"}));
    }
}

class Solution {

    static final int MISS = 5;
    static final int HIT = 1;
    static List<String> cache = new ArrayList<>();

    static public int solution(int cacheSize, String[] cities) {
        int answer = 5;

        if (cacheSize == 0) {
            return cities.length * MISS;
        }
        cache.add(cities[0].toLowerCase());
        for (int i = 1; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.contains(city)) {
                answer += HIT;
                cache.remove(city);
            } else {
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                answer += MISS;
            }
            cache.add(city);
        }

        return answer;
    }
}