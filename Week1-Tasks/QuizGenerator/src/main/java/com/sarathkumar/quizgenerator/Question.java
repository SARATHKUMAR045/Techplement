package com.sarathkumar.quizgenerator;

import java.util.List;

public class Question {

    private final String QuestionText;
    private final List<String> options;
    private final int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.QuestionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

}
