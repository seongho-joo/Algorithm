package Simulation.prg49994;

import java.util.*;

public class Solution {

    private static final int MAX = 5;
    private static final int MIN = -5;

    Set<String> visited = new HashSet<>();
    Map<Character, Integer[]> map = new HashMap<>();

    public int solution(String dirs) {
        int y = 0;
        int x = 0;

        init();

        for (char dir : dirs.toCharArray()) {
            int ny = y + map.get(dir)[0];
            int nx = x + map.get(dir)[1];

            if (nx > MAX || nx < MIN) {
                continue;
            }
            if (ny > MAX || ny < MIN) {
                continue;
            }

            visited.add(
                y + String.valueOf(x) + ny + nx);
            visited.add(
                ny + String.valueOf(nx) + y + x);
            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }

    private void init() {
        map.put('U', new Integer[]{0, 1});
        map.put('D', new Integer[]{0, -1});
        map.put('L', new Integer[]{-1, 0});
        map.put('R', new Integer[]{1, 0});
    }
}