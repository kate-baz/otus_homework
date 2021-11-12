package testingSystem;

import java.util.Scanner;


public class UserResponse {

    private int correctResponsesCount;
    private int responseCount;
    private static final int CORRECT_ANSWER_TO_QUESTION1 = 1;
    private static final int CORRECT_ANSWER_TO_QUESTION2 = 3;
    private static final int CORRECT_ANSWER_TO_QUESTION3 = 1;

    public int readUserResponse() {
        int userResponse = 0;
        if (responseCount > 2) {
            return userResponse;
        }
        Scanner scanner = new Scanner(System.in);
        String buffer = scanner.nextLine();
        if (buffer.length() == 1 && Character.isDigit(buffer.charAt(0))) {
            userResponse = Character.getNumericValue(buffer.charAt(0));
            responseCount++;
        } else {
            System.out.println("Необходимо ввести чило от 1 до 3. Пожалуйста, попробуйте снова.");

            switch (responseCount) {
                case (0): {
                    new Question().getQuestion1();
                    userResponse = readUserResponse();
                }
                case (1): {
                    new Question().getQuestion2();
                    userResponse = readUserResponse();
                }
                case (2): {
                    new Question().getQuestion3();
                    userResponse = readUserResponse();
                }
            }
        }
        return userResponse;
    }

    public boolean validateResponse(int correctResponse, int  response) {
         if (response == correctResponse) {
            correctResponsesCount++;
            return true;
        } else {
            return false;
        }
    }

    public void showResults(int a1, int a2, int a3) {
        boolean isResponseCorrect1 = validateResponse(CORRECT_ANSWER_TO_QUESTION1, a1);
        boolean isResponseCorrect2 = validateResponse(CORRECT_ANSWER_TO_QUESTION2, a2);
        boolean isResponseCorrect3 = validateResponse(CORRECT_ANSWER_TO_QUESTION3, a3);
        switch (correctResponsesCount) {
            case (0) -> System.out.println("Вы не ответили верно ни на один вопрос.");
            case (1) -> System.out.println("Вы ответили верно на один вопрос из трех.");
            case (2) -> System.out.println("Вы ответили верно на два вопроса из трех.");
            case (3) -> {
                System.out.println("Вы ответили верно на все вопросы.");
                System.exit(0);
            }
            default -> System.out.println("Странный результат.");
        }
        if (isResponseCorrect1) {
            System.out.println("Вопрос 1: Ответ верный.");
        } else {
            System.out.println("Вопрос 1: Ответ неверный. Правильный ответ - 1");
        }
        if (isResponseCorrect2) {
            System.out.println("Вопрос 2: Ответ верный.");
        } else {
            System.out.println("Вопрос 2: Ответ неверный. Правильный ответ - 3");
        }
        if (isResponseCorrect3) {
            System.out.println("Вопрос 3: Ответ верный.");
        } else {
            System.out.println("Вопрос 3: Ответ неверный. Правильный ответ - 1");
        }
    }
}
