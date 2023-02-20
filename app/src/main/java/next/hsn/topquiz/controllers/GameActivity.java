package next.hsn.topquiz.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import next.hsn.topquiz.R;
import next.hsn.topquiz.models.Question;
import next.hsn.topquiz.models.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextViewQuestion;
    private Button mButtonResponse1;
    private Button mButtonResponse2;
    private Button mButtonResponse3;
    private Button mButtonResponse4;
    private final QuestionBank mQuestionBank = generateQuestionBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.mTextViewQuestion = findViewById(R.id.game_activity_textview_question);
        this.mButtonResponse1 = findViewById(R.id.game_activity_btn_question1);
        this.mButtonResponse2 = findViewById(R.id.game_activity_btn_question2);
        this.mButtonResponse3 = findViewById(R.id.game_activity_btn_question3);
        this.mButtonResponse4 = findViewById(R.id.game_activity_btn_question4);

        mButtonResponse1.setOnClickListener(this);
        mButtonResponse2.setOnClickListener(this);
        mButtonResponse3.setOnClickListener(this);
        mButtonResponse4.setOnClickListener(this);

        displayQuestion(mQuestionBank.getCurrentQuestion());
    }

    @Override
    public void onClick(View v) {
        int index;
        if (v == mButtonResponse1) {
            index = 0;
        } else if (v == mButtonResponse2) {
            index = 1;
        } else if (v == mButtonResponse3) {
            index = 2;
        } else if (v == mButtonResponse4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex())
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        this.displayQuestion(mQuestionBank.getNextQuestion());
    }

    public void displayQuestion(Question question) {
        this.mTextViewQuestion.setText(question.getQuestion());
        this.mButtonResponse1.setText(question.getChoiceList().get(0));
        this.mButtonResponse2.setText(question.getChoiceList().get(1));
        this.mButtonResponse3.setText(question.getChoiceList().get(2));
        this.mButtonResponse4.setText(question.getChoiceList().get(3));
    }

    public QuestionBank generateQuestionBank() {
        Question question1 = new Question("Who is the creator of Android?", Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"), 0);

        Question question2 = new Question("When did the first man land on the moon?", Arrays.asList("1958", "1962", "1967", "1969"), 3);

        Question question3 = new Question("What is the house number of The Simpsons?", Arrays.asList("42", "101", "666", "742"), 3);

        Question question4 = new Question("Who did the Mona Lisa paint?", Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"), 1);

        Question question5 = new Question("What is the country top-level domain of Belgium?", Arrays.asList(".bg", ".bm", ".bl", ".be"), 3);
        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5));
    }

}