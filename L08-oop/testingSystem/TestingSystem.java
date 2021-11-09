package testingSystem;


public class TestingSystem {
    public static void main(String[] args) {
        Question q = new Question();
        Answer answer = new Answer();
        UserResponse ur = new UserResponse();

        q.getQuestion1();
        int response1 = ur.readUserResponse();

        q.getQuestion2();
        int response2 = ur.readUserResponse();

        q.getQuestion3();
        int response3 = ur.readUserResponse();

        ur.showResults(response1, response2, response3);
    }
}
