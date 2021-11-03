package com.company;

import java.util.Scanner;

public class Main {
    static final int FILED_LENGTH = 10;                                //ограничил размер поля FILED_LENGHT
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        System.out.println("ИГРОК №1 введите своё имя ...");
        String Player1 = scanner.nextLine();                               //СКАНИРУЕТ введенноё имя
        System.out.println("Здарова заЙбал, " + Player1 + ")");

        System.out.println("ИГРОК №2 введите своё имя ...");
        String Player2 = scanner.nextLine();
        System.out.println("Салам алейкум родной " + Player2 + ", как ты брат? Как родные?");

        String OtvetNaVopr = scanner.nextLine(); //немного по петросянил
        System.out.println("да ладно не продолжай мне не интересно что у тебя всё " + OtvetNaVopr);

        char[][] playerField1 = new char[FILED_LENGTH][FILED_LENGTH];        // расположение кароблей 1 игрока
        char[][] playerField2 = new char[FILED_LENGTH][FILED_LENGTH];        // расположение кораблей 2 игрока

        fillPlayerField(playerField1);                                       // соединяю два метода
        fillPlayerField(playerField2);


        char[][] playerBattleField1 = new char[FILED_LENGTH][FILED_LENGTH];
        char[][] playerBattleField2 = new char[FILED_LENGTH][FILED_LENGTH];


    }

    private static void fillPlayerField(char[][] playerField) {
        int x;
        int y;
        int position;

        for (int i = 4; i >= 1; i--) {
            for (int k = i; k <= 5 - i; k++) {
                System.out.println("Расставляем " + i + "-палубный корабль. Осталось расставить: " + (k + 1));

                System.out.println("введите X кординату: ");
                x = scanner.nextInt();

                System.out.println("введите Y кординату: ");
                y = scanner.nextInt();

                System.out.println("1 - горизонтальная; 2 - вертикальная ?");
                position = scanner.nextInt();

                if (position == 1) {
                    for (int q = 0; q < i; q++) {
                        playerField[y][x + q] = '1';
                    }
                }
                if (position == 2) {
                    for (int m = 0; m < i; m++) {
                        playerField[y + m][x] = '1';

                    }
                }
                printField(playerField);

            }
        }
    }

    static void printField(char[][] field) {

        for (char[] cells : field) {
            for (char cell : t) {
                // если значение дефолтовое (в случае char - 0), значит в данной клетке
                // корабль не установлен - печатаем пустую клетку
                if (cell == 0) {
                    System.out.print(" |");
                } else {
                    // если клетка непустая (значение отличается от дефолтового),
                    //тогда отрисовываем сожержимое клетки (элемента массива)
                    System.out.print(cell + "|");
                }
            }
            System.out.println("");
            System.out.println("--------------------");
        }
    }

    private static void playGame(String player1Name, String player2Name, char[][] playerField1, char[][] playerField2) {
        // "карты" выстрелов - создаём двумерные массивы, которые содержат все выстрелы
        // удачные (#) и неудачные (*)
        char[][] playerBattleField1 = new char[FILED_LENGTH][FILED_LENGTH];
        char[][] playerBattleField2 = new char[FILED_LENGTH][FILED_LENGTH];

        // вспомогательные переменные, которым будут присваиваться значения текущего игрока -
        // игрока, чья очередь делать выстрел. Сначала играет первый игрок, прошу прошения
        // за тавтологию
        String currentPlayerName = player1Name;
        char[][] currentPlayerField = playerField2;
        char[][] currentPlayerBattleField = playerBattleField1;

        // внутри цикла происходит смена очередности игроков, выстрел, его обработка.
        // код внутри цикла выполняется до тех пор, пока "живы" оба игрока - пока у двух игроков
        // "частично" цел (ранен) ещё хотя бы один корабль
        while (isPlayerAlive(playerField1) && isPlayerAlive(playerField2)) {
            // принимаем от пользователя координаты выстрела
            System.out.println(currentPlayerName + ", please, input x coord of shot");
            int xShot = scanner.nextInt();
            System.out.println(currentPlayerName + ", please, input y coord of shot");
            int yShot = scanner.nextInt();

            // обрабатываем выстрел и получаем возвращаемое значение метода handleShot
            int shotResult = handleShot(currentPlayerBattleField, currentPlayerField, xShot, yShot);
            // если выстрел неудачный, и не один корабль не повреждён, то очередь переходит к следующему игроку
            if (shotResult == 0) {
                currentPlayerName = player2Name;
                currentPlayerField = playerField1;
                currentPlayerBattleField = playerBattleField2;
            }
        }
    }
    private static int handleShot(char[][] battleField, char[][] field, int x, int y) {
        if ('1'.equals(field[y][x])) {
            field[y][x] = '#';
            battleField[y][x] = '#';
            System.out.println("Good shot!");
            return 1;
        }
        battleField[y][x] = '*';
        System.out.println("Bad shot!");
        return 0;
    }

    /**
     * Метод определяет, не проиграл ли еще игрок. Если у игрока остался хотя бы
     * один "раненный" корабль, тогда пользователь продолжает игру.
     * То есть, если на карте у игрока остался хотя бы один символ '1', которым мы отмечали
     * корабли, то игра продолжается - возвращается значение true. Иначе false.
     */
    private static boolean isPlayerAlive(char[][] field) {
        for (char[] cells : field) {
            for (char cell : cells) {
                if ('1' == cell) {
                    return true;
                }
            }
        }
        return false;
    }
}