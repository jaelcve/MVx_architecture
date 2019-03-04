package com.techyourchance.mvc.screens.questionslist;

import android.view.View;

import com.techyourchance.mvc.questions.Question;

import java.util.List;

interface QuestionListViewMvc {

    interface Listener{
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unRegisterListener(Listener listener);

    View getRootView();

    void bindQuestions(List<Question> questions);

}
