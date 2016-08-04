/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevenmatches;

import java.util.Scanner;

/**
 *
 * @author Valery Zakharov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        /**
         * игра подленькая - выигрывает тот, кто при правильной стратегии ходит
         * первым. Поскольку заданием было научить компьютер выигрывать - отдаём
         * компьютеру первый ход
         */
        
        int N = 11; // количество спичек всего
        int M = 3;  // максимальное количество спичек, которое можно взять за
                    // один ход
        int matchesLeft = N; // здесь будет содержаться оставшееся количество
                    // спичек
        int mc;     // максимальное количество спичек, которое можнo взять за
                    // один ход в данный проход цикла
        String input;   // строковая переменная для чтения ввода пользователя
        int m = 0;  // переменная для записи количества взятых за ход спичек
        boolean isComputersTurn = true; // признак того, что первый ход делает
                    // компьютер :)

        while (matchesLeft > 0) {
            
            for (int i = 0; i < matchesLeft; i++) {
                System.out.print("| ");
            }
            System.out.printf("(%d)\n", matchesLeft);

            mc = matchesLeft < M ? matchesLeft : M;
            
            if (isComputersTurn) {
                m = (matchesLeft - 1) % (M + 1);
                if (m == 0) {
                    m = 1 + (int) (Math.random() * mc);
                    System.out.println("При текущих вводных игры этот блок не отработает"
                            + "Компьютер будет испытывать удачу:)");
                }

                System.out.println("Компьютер делает ход: " + m);
            } else {
                if (matchesLeft == 1) {
                    System.out.println("Забирайте Вашу последнюю спичку - Вы програли:)");
                } else {
                    System.out.print("Ваш ход: ");
                    m = 0;
                    while (m < 1 || m > mc) {
                        input = reader.nextLine();
                        try {
                            m = (input == null || input.isEmpty()) ? 0 : Integer.parseInt(input);
                        } catch (Exception e) {
                            m = 0;
                        }
                        if ((m < 1 || m > mc)) {
                            System.out.printf("Ошибка ввода (требуется ввести число от 1 до %d)\n", mc);
                            System.out.print("Попробуйте повторить ввод: ");
                        }
                    }
                }
            }
            matchesLeft -= m;   // уменьшаем количество спичек, на число
                                // спичек, взятое игроком за текущий ход
            isComputersTurn = !isComputersTurn;   // следующий игрок
        }
    }
}
