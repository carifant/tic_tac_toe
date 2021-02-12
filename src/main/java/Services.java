

import java.util.Scanner;

public class Services {

    static char[][] arr = new char[3][3];

    public void starter() {
        int mode = new Services().startLoopMethod();
        new Services().initializerArray();
        new ModesOfGame().selectorOfMode(mode, arr);
    }

    private void initializerArray() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
        printField(arr);
    }

    private int startLoopMethod() {
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

            // check empty spaces & X==O
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(beginEnd);
    }
}
