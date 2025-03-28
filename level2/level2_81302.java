package programmers;

import java.util.ArrayList;
import java.util.List;

public class level2_81302 {
    private static class ChangeChar {
        public String place;

        public ChangeChar(String place) {
            this.place = place;
        }

        public char[] stringToChar() {
            return place.toCharArray();
        }
    }

    public static void main(String[] args) {
        // String[][] places = {
        // { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
        // { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
        // { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
        // { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
        // { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" }
        // };
        String[][] places = {
                { "PXOPX",
                        "OXOXP",
                        "PXOPX",
                        "OXOXP",
                        "PXOPX" }, // 같은 행에서 'O'가 있어서 거리두기 안 됨.

                { "PXXXP",
                        "XXXXX",
                        "XXOXX",
                        "XXXXX",
                        "PXXXP" }, // 'O'가 없어서 거리두기 준수됨.

                { "POOXP",
                        "OXXOX",
                        "OXPXO",
                        "OOXOX",
                        "PXOXP" }, // 대각선에 P가 있지만, 사이에 'X'가 있어서 거리두기 준수됨.

                { "PXXOX",
                        "XOXPX",
                        "XXOXP",
                        "OXXOX",
                        "PXXXP" }, // 맨해튼 거리 2인데 'O'가 있어 거리두기 위반.

                { "PXOXP",
                        "OXOXO",
                        "XOXOX",
                        "OXOXO",
                        "PXOXP" } // 대각선에 P가 있지만, 사이에 'X'가 있어서 거리두기 준수됨.
        };
        int n = 5; // places.length, 대기실 수
        int[] result = new int[n];

        ChangeChar cc;
        for (int i = 0; i < n; i++) {

            char[][] placeToChar = new char[5][5];
            List<int[]> findP = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                cc = new ChangeChar(places[i][j]);
                placeToChar[j] = cc.stringToChar();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (placeToChar[j][k] == 'P') {
                        int[] arr = { j, k };
                        findP.add(arr);
                        System.out.println("arr[0] " + arr[0] + " : " + arr[1]);
                    }
                }
            }
            if (findP.isEmpty()) {
                result[i] = 1;
                continue;
            }
            int[][] coordinateP = findP.toArray(new int[findP.size()][]);
            // for (int[] t : coordinateP) {
            // for (int tt : t) {
            // System.out.print(tt + " ");
            // }
            // System.out.println();
            // }

            // System.out.println();
            boolean isViolation = false;
            for (int j = 0; j < coordinateP.length; j++) {
                for (int k = j + 1; k < coordinateP.length; k++) {
                    int distance;
                    if ((coordinateP[j][0] - coordinateP[k][0]) * (coordinateP[j][1] - coordinateP[k][1]) >= 0) {
                        distance = Math.abs(
                                (coordinateP[j][0] + coordinateP[j][1]) - (coordinateP[k][0] + coordinateP[k][1]));
                        System.out.println(distance + " " + coordinateP[j][0] + " " + coordinateP[j][1] + " "
                                + coordinateP[k][0] + " " + coordinateP[k][1]);

                    } else {
                        distance = Math.abs(
                                (coordinateP[j][0] + coordinateP[j][1]) - (coordinateP[k][0] + coordinateP[k][1])) +
                                2 * Math.min(Math.abs(coordinateP[j][0] - coordinateP[k][0]), Math.abs(
                                        coordinateP[j][1] - coordinateP[k][1]));
                        System.out.println(distance + " " + coordinateP[j][0] + " " + coordinateP[j][1] + " "
                                + coordinateP[k][0] + " " + coordinateP[k][1]);
                    }
                    if (distance == 2) {
                        boolean hasO = false;
                        for (int a = Math.min(coordinateP[j][0], coordinateP[k][0]); a <= Math.max(coordinateP[k][0],
                                coordinateP[j][0]); a++) {
                            for (int b = Math.min(coordinateP[j][1], coordinateP[k][1]); b <= Math
                                    .max(coordinateP[k][1], coordinateP[j][1]); b++) {
                                if (placeToChar[a][b] == 'O') {
                                    // System.out.println("placeToChar : " + a + b);
                                    hasO = true;
                                }
                            }
                        }
                        // System.out.println("hasO " + hasO);
                        if (hasO) {
                            isViolation = true;
                            break;
                        }
                    } else if (distance == 1) {
                        isViolation = true;
                        break;
                    }
                }
                if (isViolation) {
                    break;
                }
            }
            if (isViolation) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("i : " + result[i]);
        }
    }
}
