package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        int[][] test = {{1, 2}, {5, 5}, {0, 1}};
        List a = Arrays.stream(test).sorted(Comparator.comparing(o -> o[0]*o[0] + o[1]*o[1]))
                .limit(2)
                .collect(Collectors.toList());
    }
}
