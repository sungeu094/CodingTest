package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class level2_87377 {
    // 1. 각 직선 비교
    private static class CompareLines {
        public int[][] lines;
        List<int[]> line_meet = new ArrayList<>();

        public CompareLines(int[][] lines) {
            this.lines = lines;
        }

        public int[][] compareLine() {
            for (int i = 0; i < lines.length; i++) {
                for (int j = i + 1; j < lines.length; j++) {
                    int denominator = (lines[i][0] * lines[j][1] - lines[i][1] * lines[j][0]);
                    // System.out.println(i + " : " + j + " :: " + denominator);
                    if (denominator != 0) { // 분모가 0이면 평행 또는 일치하는 직선
                        double x = (double) (lines[i][1] * lines[j][2] - lines[i][2] * lines[j][1]) / denominator;
                        double y = (double) (lines[i][2] * lines[j][0] - lines[i][0] * lines[j][2]) / denominator;
                        if (x == (int) x && y == (int) y) {
                            line_meet.add(new int[] { (int) x, (int) y });
                            // System.out.println(x + " + " + y);
                        }
                    }
                }
            }
            return line_meet.toArray(new int[line_meet.size()][]);
        }
    }

    private static class MinMax {
        public int[][] coordinate;

        public MinMax(int[][] coordinate) {
            this.coordinate = coordinate;
        }

        public int[] min_max() {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
            for (int[] coordinate1 : coordinate) {
                // System.out.println(coordinate1[0] + " : " + coordinate1[1]);
                if (coordinate1[0] < minX) {
                    minX = coordinate1[0];
                }
                if (coordinate1[0] > maxX) {
                    maxX = coordinate1[0];
                }

                if (coordinate1[1] < minY) {
                    minY = coordinate1[1];
                    // System.out.println("minY : " + minY);
                }
                if (coordinate1[1] > maxY) {
                    maxY = coordinate1[1];
                    // System.out.println("maxY : " + maxY);
                }
            }

            return new int[] { minX, minY, maxX, maxY };
        }
    }

    public static void main(String[] args) {
        String input;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("2차원 배열을 입력하세요:"); // 입력 안내 메시지 추가
            input = scan.nextLine();
        }

        int[][] matrix = parseMatrix(input);

        // System.out.println(matrix[0].length);
        CompareLines cl = new CompareLines(matrix);
        int[][] calculate_line = cl.compareLine();

        if (calculate_line.length == 0) {
            System.out.println("교점이 없습니다.");
        } else {
            // for (int[] point : calculate_line) {
            // System.out.println(point[0] + " , " + point[1]);
            // }
        }

        // x,y 좌표 최소, 최대 구하기
        MinMax minMax = new MinMax(calculate_line);
        int[] result_size = minMax.min_max();
        // for (int i : result_size) {
        // System.out.println("값 : " + i);
        // }

        String[][] result = new String[result_size[2] - result_size[0]][result_size[3] - result_size[1]];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], "."); // 먼저 모든 값을 "."으로 채움
        }

        // 2. 교점 좌표를 찾아 "*"을 배치
        for (int[] c : calculate_line) {
            int x = c[0] - result_size[0]; // 변환된 x 좌표
            int y = c[1] - result_size[1]; // 변환된 y 좌표
            result[x][y] = "*"; // 별표 삽입
        }

        for (String[] result1 : result) {
            for (String item : result1) {
                System.out.print(item);
            }
            System.out.println();
        }
    }

    public static int[][] parseMatrix(String input) {
        // 1. 입력에서 대괄호 제거 (처음과 끝 대괄호 제거)
        input = input.replaceAll("\\[\\[", "").replaceAll("\\]\\]", ""); // 바깥쪽 대괄호 제거
        // System.out.println(input);

        // 2. ", "을 기준으로 각 행을 나누기
        String[] rows = input.split("\\], \\["); // 각 행을 분리

        // 결과를 저장할 List 생성
        List<int[]> matrixList = new ArrayList<>();

        // 3. 각 행을 분리하고 숫자로 변환하여 List에 추가
        for (String row : rows) {
            // 각 행 출력 (디버깅용)
            // System.out.println(row);

            // 쉼표 기준으로 숫자 분리
            String[] numbers = row.split(", ");

            // 정수 배열로 변환
            int[] intRow = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intRow[i] = Integer.parseInt(numbers[i].trim()); // 숫자로 변환
            }

            // List에 추가
            matrixList.add(intRow);
        }

        // List를 2D 배열로 변환하여 반환
        return matrixList.toArray(new int[0][]);
    }
}
