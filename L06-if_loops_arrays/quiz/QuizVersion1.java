package quiz;

import java.util.Scanner;

public class QuizVersion1 {

    static String[] questions;
    static String[][] answers;
    static int countOfCorrectAnswers = 0;
    static int[] responses;

    public static void main(String[] args) {
        questions = new String[3];
        questions[0] = "Вопрос 1. Сколько планет в солнечной системе?";
        questions[1] = "Вопрос 2. В каком году началась Великая Отечественная война?";
        questions[2] = "Вопрос 3. Назовите столицу Франции";
        answers = new String[][]{
                {"1. 8", "2. 9", "3. 10"},
                {"1. 1939", "2. 1945", "3. 1941"},
                {"1. Париж", "2. Рим", "3. Лондон"}
        };
        responses = new int[3];

        System.out.println("Выберите правильный вариант ответа. Введите цифру от 1 до 3");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String[] answersToCurrentQuestion = answers[i];
            for (String answer: answersToCurrentQuestion) {
                System.out.println(answer);
            }
            Scanner sc = new Scanner(System.in);
            int currentAnswer = sc.nextInt();
            if ((i == 0 && currentAnswer == 1) || (i == 1 && currentAnswer == 3) || (i == 2 && currentAnswer == 1)) {
                countOfCorrectAnswers++;
            }
            responses[i] = currentAnswer;
        }
        System.out.println("Вы ответили правильно на " + countOfCorrectAnswers + " вопросов из 3-х");

        if (responses[0] != 1) {
            System.out.println("Ответ на вопрос 1 неверный. Правильный ответ - 1.");
        }
        if (responses[1] != 3) {
            System.out.println("Ответ на вопрос 2 неверный. Правильный ответ - 3.");
        }
        if (responses[1] != 1) {
            System.out.println("Ответ на вопрос 3 неверный. Правильный ответ - 1.");
        }

        switch (countOfCorrectAnswers) {
            case (0):
                System.out.println("Очень плохо!");
                break;
            case (1) :
                System.out.println("Ну хоть что-то.");
                break;
            case (2) :
                System.out.println("Неплохо, но могло быть и лучше!");
                break;
            case (3) :
                System.out.println("Отличный результат!");
                break;
            default:
                System.out.println("Странный результат.");
        }
    }
}
