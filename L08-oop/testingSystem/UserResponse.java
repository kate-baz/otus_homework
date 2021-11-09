package testingSystem;

import java.util.Scanner;

public class UserResponse {
    private int[] responses;
    boolean isResponseCorrect;
    private int correctResponsesCount;

    public int readUserResponse() {
        int userResponse = 0;
        Scanner scanner = new Scanner(System.in);
        String buffer = scanner.nextLine();
        if (buffer.length() == 1 && Character.isDigit(buffer.charAt(0))) {
            userResponse = Character.getNumericValue(buffer.charAt(0));
        } else {
            System.out.println("Not a valid input. Number 1, 2 or 3 expected");
        }
        return userResponse;
    }

    public void validateResponse1(int response) {
        if (response == 1) {
            isResponseCorrect = true;
            correctResponsesCount++;
            responses[0] = response;
        } else {
            responses[0] = response;
        }
    }

    public void validateResponse2(int response) {
        if (response == 1) {
            isResponseCorrect = true;
            correctResponsesCount++;
        }
    }
}
