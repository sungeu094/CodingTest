package programmers;

import java.util.Scanner;

public class level2_68645 {
    private static class Pyramid {
        public int size;
        public int[][] tower;

        public Pyramid(int size) {
            this.size = size;
            this.tower = new int[size][size];
        }

        public static int sum(int size) {
            if (size <= 1) {
                return 1;
            }
            return size + sum(size - 1);
        }

        public int[][] findPyramid() {
            int x = 0, y = 0, cnt = 1;
            int pyramid_size = sum(size);
            int limit = size;
            int direction = 0;
            while (cnt <= pyramid_size) {
                tower[y][x] = cnt;
                cnt++;
                if (direction == 0) {
                    if (y + 1 < size && tower[y + 1][x] == 0) {
                        y++;
                    } else {
                        direction = 1;
                        x++;
                    }
                } else if (direction == 1) {
                    if (x + 1 < size && tower[y][x + 1] == 0) {
                        x++;
                    } else {
                        direction = 2;
                        y--;
                        x--;
                    }
                } else if (direction == 2) {
                    if (y - 1 >= 0 && x - 1 >= 0 && tower[y - 1][x - 1] == 0) {
                        y--;
                        x--;
                    } else {
                        direction = 0;
                        y++;
                    }
                }

            }

            return tower;
        }
    }

    public static void main(String[] args) {
        int n;
        try (Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
        }
        System.out.println(n);

        Pyramid pyramid = new Pyramid(n);
        int[][] sq_pyramid = pyramid.findPyramid();

        int[] result = new int[pyramid.sum(n)];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                result[cnt] = sq_pyramid[i][j];
                cnt++;
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
