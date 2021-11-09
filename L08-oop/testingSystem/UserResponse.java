package testingSystem;

import java.util.Scanner;


public class UserResponse {

    private int correctResponsesCount;
    private int responseCount;

    public int readUserResponse() {
        int userResponse = 0;
        Scanner scanner = new Scanner(System.in);
        String buffer = scanner.nextLine();
        if (buffer.length() == 1 && Character.isDigit(buffer.charAt(0))) {
            userResponse = Character.getNumericValue(buffer.charAt(0));
            responseCount++;
        } else {
            responseCount++;
            System.out.println("Необходимо ввести чило от 1 до 3. Пожалуйста, попробуйте снова.");
            responseCount--;
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

    public boolean validateResponse1(int response) {
         if (response == 1) {
            correctResponsesCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean validateResponse2(int response) {
         if (response == 3) {
            correctResponsesCount++;
            return true;
        } else {
            return false;
        }
    }

    public boolean validateResponse3(int response) {
        if (response == 1) {
            correctResponsesCount++;
            return true;
        } else {
            return false;
        }
    }

    public void showResults(int a1, int a2, int a3) {
        boolean isResponseCorrect1 = validateResponse1(a1);
        boolean isResponseCorrect2 = validateResponse2(a2);
        boolean isResponseCorrect3 = validateResponse3(a3);
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
