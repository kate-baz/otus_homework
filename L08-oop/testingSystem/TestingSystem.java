package testingSystem;

import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
        Question question = new Question();
        Answer answer = new Answer();
        UserResponse userResponse = new UserResponse();

        question.getQuestion1();
        userResponse.readUserResponse();

        question.getQuestion2();
        question.getQuestion3();
    }
}
