package next.hsn.topquiz.models;

import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex = 0;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }



    public Question getNextQuestion() {
        Question question = this.getCurrentQuestion();
        this.setNextQuestionIndex(this.getNextQuestionIndex()+1);
        return question;
    }

    public Question getCurrentQuestion() {
        return this.getQuestionList().get(this.getNextQuestionIndex());
    }

}
