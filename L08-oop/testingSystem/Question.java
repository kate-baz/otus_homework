package testingSystem;

public class Question {

    private Answer answer;
    private String question;

    public void getQuestion1() {
        question = "Вопрос 1. Сколько планет в солнечной системе?";
        System.out.println(question);
        Answer answer = new Answer();
        answer.getAnswersToQuestion1();
    }

    public void getQuestion2() {
        question = "Вопрос 2. В каком году началась Великая Отечественная война?";
        System.out.println(question);
        Answer answer = new Answer();
        answer.getAnswersToQuestion2();
    }

    public void getQuestion3() {
        question = "Вопрос 3. Назовите столицу Франции";
        System.out.println(question);
        Answer answer = new Answer();
        answer.getAnswersToQuestion3();
    }
}
