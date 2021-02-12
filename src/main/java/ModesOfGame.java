import java.util.Scanner;

public class ModesOfGame {

    static int step = 0;

    public void selectorOfMode(int mode, char[][] arr) {
        if (mode == 1) {
            while (true) {
                if (humanMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 2) {
            while (true) {
                if (humanMode(arr)) {
                    break;
                }
                if (easyBotMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 3) {
            while (true) {
                if (easyBotMode(arr)) {
                    break;
                }
                if (humanMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 4) {
            while (true) {
                if (easyBotMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 5) {
            while (true) {
                if (mediumBotMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 6) {
            while (true) {
                if (humanMode(arr)) {
                    break;
                }
                if (mediumBotMode(arr)) {
                    break;
                }
            }
        }
        if (mode == 7) {
            while (true) {
                if (mediumBotMode(arr)) {
                    break;
                }
                if (humanMode(arr)) {
                    break;
                }
            }
        }
    }

    public boolean easyBotMode(char[][] arr) {
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
        Services.printField(arr);

        if (Services.checkEndGame(Services.checkResult(arr))) {
            return true;
        }
        return false;
    }

    public boolean mediumBotMode(char[][] arr) {
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
        Services.printField(arr);

        if (Services.checkEndGame(Services.checkResult(arr))) {
            return true;
        }
        return false;
    }

    public boolean humanMode(char[][] arr) {
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
        Services.printField(arr);
        if (Services.checkEndGame(Services.checkResult(arr))) {
            return true;
        }
        return false;
    }
}
