import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        int[][] cinema = new int[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }

        int tickets = scanner.nextInt();
        int currCount = 0;
        int maxCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (cinema[i][j] == 0) {
                    currCount++;
                    if (maxCount < currCount) {
                        maxCount = currCount;
                    }
                } else {
                    currCount = 0;
                }
            }
            if (maxCount >= tickets) {
                System.out.println(i + 1);
                break;
            } else if (i == rows - 1 && maxCount < tickets) {
                System.out.println(0);
            } else {
                maxCount = 0;
                currCount = 0;
            }
        }
    }
}