package com.sarathkumar.quizgenerator;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private final String topic;
    private List<Question> questions = new ArrayList<>();

    public Quiz(String topic) {
        this.topic = topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getTopic() {
        return topic;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


}
