package com.techyourchance.mvc.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuestionListItemViewMvcImp implements QuestionListItemViewMvc {

    private View mRootView;
    private List<Listener> mListeners = new ArrayList<>(1);

    private Question mQuestion;
    private TextView mtxtTitle;

    public QuestionListItemViewMvcImp(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_question_list_item, parent, false);
        mtxtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Listener listener: mListeners) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    private <T extends View> T findViewById(int id) {
       return mRootView.findViewById(id);
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mtxtTitle.setText(question.getTitle());
    }
}
