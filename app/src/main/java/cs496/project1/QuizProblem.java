package cs496.project1;

/**
 * Created by q on 2017-07-01.
 */

public class QuizProblem {
    private String name;
    private String rightAnswer;
    private boolean isCorrect;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private String selectedAnswer;

    public String getName() {
        return name;
    }
    public boolean getCorrect() { return isCorrect; }
    public String getRightAnswer() {
        return rightAnswer;
    }
    public String getWrongAnswer1() { return wrongAnswer1; }
    public String getWrongAnswer2() { return wrongAnswer2; }
    public String getWrongAnswer3() { return wrongAnswer3; }
    public String getSelectedAnswer() { return selectedAnswer; }

    public void setName(String name) {
        this.name = name;
    }
    public void setCorrect(boolean bool) { this.isCorrect = bool; }
    public void setRightAnswer(String answer) {
        this.rightAnswer = answer;
    }
    public void setWrongAnswer1(String answer) { this.wrongAnswer1 = answer;}
    public void setWrongAnswer2(String answer) { this.wrongAnswer2 = answer;}
    public void setWrongAnswer3(String answer) { this.wrongAnswer3 = answer;}
    public void setSelectedAnswer(String answer) { this.selectedAnswer = answer; }
}
