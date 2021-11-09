package testingSystem;

public class Answer {

    private Question question;

    private final String[] ANSWER_TO_QUESTION1 = {"1. 8", "2. 9", "3. 10"};
    private final String[] ANSWER_TO_QUESTION2 = {"1. 1939", "2. 1945", "3. 1941"};
    private final String[] ANSWER_TO_QUESTION3 = {"1. Париж", "2. Рим", "3. Лондон"};

    public void getAnswersToQuestion1() {
        for (String answer: ANSWER_TO_QUESTION1) {
            System.out.println(answer);
        }
    }

    public void getAnswersToQuestion2() {
        for (String answer: ANSWER_TO_QUESTION2) {
            System.out.println(answer);
        }
    }

    public void getAnswersToQuestion3() {
        for (String answer: ANSWER_TO_QUESTION3) {
            System.out.println(answer);
        }
    }
}
