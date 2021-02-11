

import java.util.Scanner;

public class Main {
    static int step = 0;
    static char[][] arr = new char[3][3];

    public static void main(String[] args) throws InterruptedException {
        int mode = new Main().startLoopMethod();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
        printField(arr);

        if (mode == 1) {
            while (true) {
                if (new Main().humanMode()) {
                    break;
                }
            }
        }
        if (mode == 2) {
            while (true) {
                if (new Main().humanMode()) {
                    break;
                }
                if (new Main().easyBotMode()) {
                    break;
                }
            }
        }
        if (mode == 3) {
            while (true) {
                if (new Main().easyBotMode()) {
                    break;
                }
                if (new Main().humanMode()) {
                    break;
                }
            }
        }
        if (mode == 4) {
            while (true) {
                if (new Main().easyBotMode()) {
                    break;
                }
            }
        }
        if (mode == 5) {
            while (true) {
                Thread.sleep(2000);
                if (new Main().mediumBotMode()) {
                    break;
                }
            }
        }
        if (mode == 6) {
            while (true) {
                if (new Main().humanMode()) {
                    break;
                }
                if (new Main().mediumBotMode()) {
                    break;
                }
            }
        }
        if (mode == 7) {
            while (true) {
                if (new Main().mediumBotMode()) {
                    break;
                }
                if (new Main().humanMode()) {
                    break;
                }
            }
        }
    }




    public boolean humanMode() {
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        int newFirst = 0;
        int newSecond = 0;
        while (b) {
            System.out.print("Enter the coordinates: ");
            String temp2 = scanner.nextLine();
            String[] list = temp2.split(" ");
            if (!(list[0].matches("[0-9]")) || !(list[1].matches("[0-9]"))) {
                System.out.println("You should enter numbers!");
                continue;
            }
            int first = Integer.parseInt(list[0]);
            int second = Integer.parseInt(list[1]);
            if (first > 3 || first < 1 || second > 3 || second < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            newFirst = first - 1;
            newSecond = second - 1;
            if (arr[newFirst][newSecond] == 'O' || arr[newFirst][newSecond] == 'X') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }

        if (step % 2 == 0) {
            arr[newFirst][newSecond] = 'X';
            step++;
        } else {
            arr[newFirst][newSecond] = 'O';
            step++;
        }
        printField(arr);
        if (checkEndGame(checkResult(arr))) {
            return true;
        }
        return false;
    }

    public boolean easyBotMode() {
        while (true) {
            int botStepFirst = (int) (Math.random() * 3);
            int botStepSecond = (int) (Math.random() * 3);
            if (arr[botStepFirst][botStepSecond] == ' ') {
                if (step % 2 == 0) {
                    arr[botStepFirst][botStepSecond] = 'X';
                    step++;
                } else {
                    arr[botStepFirst][botStepSecond] = 'O';
                    step++;
                }
                System.out.println("Making move level \"easy\"");
                break;
            }
        }
        printField(arr);

        if (checkEndGame(checkResult(arr))) {
            return true;
        }
        return false;
    }

    public boolean mediumBotMode() {
        boolean flag = false;
        if (step % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == 'X' && arr[i][1] == arr[i][0] && arr[i][2] == ' ') {
                    arr[i][2] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[i][1] == 'X' && arr[i][2] == arr[i][1] && arr[i][0] == ' ') {
                    arr[i][0] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[0][i] == 'X' && arr[0][i] == arr[1][i] && arr[2][i] == ' ') {
                    arr[2][i] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[2][i] == 'X' && arr[2][i] == arr[1][i] && arr[0][i] == ' ') {
                    arr[0][i] = 'X';
                    step++;
                    flag = true;
                    break;
                }
            }
            if (arr[0][0] == 'X' && arr[0][0] == arr[1][1] && arr[2][2] == ' ' && !flag) {
                arr[2][2] = 'X';
                step++;
                flag = true;
            } else if (arr[1][1] == 'X' && arr[1][1] == arr[2][2] && arr[0][0] == ' ' && !flag) {
                arr[0][0] = 'X';
                step++;
                flag = true;
            } else if (arr[2][0] == 'X' && arr[2][0] == arr[1][1] && arr[0][2] == ' ' && !flag) {
                arr[0][2] = 'X';
                step++;
                flag = true;
            } else if (arr[1][1] == 'X' && arr[1][1] == arr[0][2] && arr[2][0] == ' ' && !flag) {
                arr[2][0] = 'X';
                step++;
                flag = true;
            }
            for (int i = 0; i < arr.length && !flag; i++) {
                if (arr[i][0] == 'O' && arr[i][1] == arr[i][0] && arr[i][2] == ' ') {
                    arr[i][2] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[i][1] == 'O' && arr[i][2] == arr[i][1] && arr[i][0] == ' ') {
                    arr[i][0] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[0][i] == 'O' && arr[0][i] == arr[1][i] && arr[2][i] == ' ') {
                    arr[2][i] = 'X';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[2][i] == 'O' && arr[2][i] == arr[1][i] && arr[0][i] == ' ') {
                    arr[0][i] = 'X';
                    step++;
                    flag = true;
                    break;
                }
            }
            if (arr[0][0] == 'O' && arr[0][0] == arr[1][1] && arr[2][2] == ' ' && !flag) {
                arr[2][2] = 'X';
                step++;
                flag = true;
            } else if (arr[1][1] == 'O' && arr[1][1] == arr[2][2] && arr[0][0] == ' ' && !flag) {
                arr[0][0] = 'X';
                step++;
                flag = true;
            } else if (arr[2][0] == 'O' && arr[2][0] == arr[1][1] && arr[0][2] == ' ' && !flag) {
                arr[0][2] = 'X';
                step++;
                flag = true;
            } else if (arr[1][1] == 'O' && arr[1][1] == arr[0][2] && arr[2][0] == ' ' && !flag) {
                arr[2][0] = 'X';
                step++;
                flag = true;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == 'O' && arr[i][1] == arr[i][0] && arr[i][2] == ' ') {
                    arr[i][2] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[i][1] == 'O' && arr[i][2] == arr[i][1] && arr[i][0] == ' ') {
                    arr[i][0] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[0][i] == 'O' && arr[0][i] == arr[1][i] && arr[2][i] == ' ') {
                    arr[2][i] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[2][i] == 'O' && arr[2][i] == arr[1][i] && arr[0][i] == ' ') {
                    arr[0][i] = 'O';
                    step++;
                    flag = true;
                    break;
                }
            }
            if (arr[0][0] == 'O' && arr[0][0] == arr[1][1] && arr[2][2] == ' ' && !flag) {
                arr[2][2] = 'O';
                step++;
                flag = true;
            } else if (arr[1][1] == 'O' && arr[1][1] == arr[2][2] && arr[0][0] == ' ' && !flag) {
                arr[0][0] = 'O';
                step++;
                flag = true;
            } else if (arr[2][0] == 'O' && arr[2][0] == arr[1][1] && arr[0][2] == ' ' && !flag) {
                arr[0][2] = 'O';
                step++;
                flag = true;
            } else if (arr[1][1] == 'O' && arr[1][1] == arr[0][2] && arr[2][0] == ' ' && !flag) {
                arr[2][0] = 'O';
                step++;
                flag = true;
            }
            for (int i = 0; i < arr.length && !flag; i++) {
                if (arr[i][0] == 'X' && arr[i][1] == arr[i][0] && arr[i][2] == ' ') {
                    arr[i][2] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[i][1] == 'X' && arr[i][2] == arr[i][1] && arr[i][0] == ' ') {
                    arr[i][0] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[0][i] == 'X' && arr[0][i] == arr[1][i] && arr[2][i] == ' ') {
                    arr[2][i] = 'O';
                    step++;
                    flag = true;
                    break;
                }
                if (arr[2][i] == 'X' && arr[2][i] == arr[1][i] && arr[0][i] == ' ') {
                    arr[0][i] = 'O';
                    step++;
                    flag = true;
                    break;
                }
            }
            if (arr[0][0] == 'X' && arr[0][0] == arr[1][1] && arr[2][2] == ' ' && !flag) {
                arr[2][2] = 'O';
                step++;
                flag = true;
            } else if (arr[1][1] == 'X' && arr[1][1] == arr[2][2] && arr[0][0] == ' ' && !flag) {
                arr[0][0] = 'O';
                step++;
                flag = true;
            } else if (arr[2][0] == 'X' && arr[2][0] == arr[1][1] && arr[0][2] == ' ' && !flag) {
                arr[0][2] = 'O';
                step++;
                flag = true;
            } else if (arr[1][1] == 'X' && arr[1][1] == arr[0][2] && arr[2][0] == ' ' && !flag) {
                arr[2][0] = 'O';
                step++;
                flag = true;
            }
        }

        if (!flag) {
            while (true) {
                int botStepFirst = (int) (Math.random() * 3);
                int botStepSecond = (int) (Math.random() * 3);
                if (arr[botStepFirst][botStepSecond] == ' ') {
                    if (step % 2 == 0) {
                        arr[botStepFirst][botStepSecond] = 'X';
                        step++;
                    } else {
                        arr[botStepFirst][botStepSecond] = 'O';
                        step++;
                    }
                    break;
                }
            }
        }
        System.out.println("Making move level \"medium\"");
        printField(arr);

        if (checkEndGame(checkResult(arr))) {
            return true;
        }
        return false;
    }

    public int startLoopMethod() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input command: ");
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                System.exit(0);
            }
            String[] arguments = line.split(" ");
            if (arguments.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }
            if (!(arguments[0].equals("start")) && !(arguments[0].equals("exit"))) {
                System.out
                      .println("Bad parameters! The first parameter must be only start or exit.");
                continue;
            }
            if (!arguments[1].equals("user") && !arguments[1].equals("easy") &&
                  !arguments[1].equals("medium")) {
                System.out
                      .println(
                            "Bad parameters! The second parameter must be only user or easy or medium.");
                continue;
            }
            if (!arguments[2].equals("user") && !arguments[2].equals("easy") &&
                  !arguments[2].equals("medium")) {
                System.out
                      .println(
                            "Bad parameters! The third parameter must be only user or easy or medium.");
                continue;
            }
            if (arguments[0].equals("exit")) {
                System.exit(0);
            }
            if (arguments[1].equals("user") && arguments[2].equals("user")) {
                return 1;
            }
            if (arguments[1].equals("user") & arguments[2].equals("easy")) {
                return 2;
            }
            if (arguments[1].equals("easy") && arguments[2].equals("user")) {
                return 3;
            }
            if (arguments[1].equals("easy") && arguments[2].equals("easy")) {
                return 4;
            }
            if (arguments[1].equals("medium") && arguments[2].equals("medium")) {
                return 5;
            }
            if (arguments[1].equals("user") && arguments[2].equals("medium")) {
                return 6;
            }
            if (arguments[1].equals("medium") && arguments[2].equals("user")) {
                return 7;
            }
        }
    }

    public static boolean checkEndGame(String str) {
        if (str.equals("X wins") || str.equals("O wins") || str.equals("Draw") ||
              str.equals("Impossible")) {
            System.out.println(str);
            return true;
        }
        return false;
    }

    public static String checkResult(char[][] array) {
        int winX = 0;
        int winO = 0;
        int empty = 0;
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 3; i++) {

            // check rows
            if (array[i][0] == array[i][1] && array[i][0] == array[i][2]
                  && array[i][0] != '_') {
                if (array[i][0] == 'X') {
                    winX++;
                } else if (array[i][0] == 'O') {
                    winO++;
                }
            }

            //check columns
            if (array[0][i] == array[1][i] && array[0][i] == array[2][i]
                  && array[0][i] != '_') {
                if (array[0][i] == 'X') {
                    winX++;
                } else if (array[0][i] == 'O') {
                    winO++;
                }
            }

            // check empty spases & X==O
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == ' ') {
                    empty++;
                } else if (array[i][j] == 'X') {
                    countX++;
                } else if (array[i][j] == 'O') {
                    countO++;
                }

            }
        }
        boolean difXOnum = countX - countO > 1 || countX - countO < -1;

        //check main diagonal
        if (array[0][0] == array[1][1] && array[1][1] == array[2][2]
              && array[0][0] != '_') {
            if (array[1][1] == 'X') {
                winX++;
            } else if (array[1][1] == 'O') {
                winO++;
            }
        }
        //check secondary diagonal
        if (array[0][2] == array[1][1] && array[1][1] == array[2][0]
              && array[0][0] != '_') {
            if (array[1][1] == 'X') {
                winX++;
            } else if (array[1][1] == 'O') {
                winO++;
            }
        }

        return (winX > 0 && winO > 0 || difXOnum ? "Impossible" :
              winX > 0 ? "X wins" :
                    winO > 0 ? "O wins" : empty == 0 ? "Draw" : "Game not finished");

    }

    public static void printField(char[][] array) {
        String beginEnd = "---------";
        System.out.println(beginEnd);
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(beginEnd);
    }
}
