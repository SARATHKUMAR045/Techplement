package com.sarathkumar.quizgenerator;

import java.util.ArrayList;
import java.util.List;

public class DefaultQuizData {

    //Programming quizzes
    public static List<Question> getJavaQuestion() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is JVM",
                List.of("Java Virtual Machine", "Java Version Manager", "Java Variable Manager", "Java Value Mechanism"),
                0));//correct answer (0-based)

        questions.add(new Question("Who developed Java?",
                List.of("Sun Microsystems", "Microsoft", "Google", "IBM"),
                0));
        questions.add(new Question("What is the default value of a local variable?",
                List.of("0", "null", "undefined", "No default value"),
                3));

        return questions;
    }

    //Math related quizzes
    public static List<Question> getMathQuestion() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the square root of 16?",
                List.of("2", "3", "4", "5"),
                2));

        questions.add(new Question("What is 2 + 2?",
                List.of("3", "4", "5", "6"),
                1));

        return questions;
    }

    //Science Quiz
    public static List<Question> getScienceQuestion() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the chemical symbol for water?",
                List.of("H2O", "O2", "CO2", "HO"),
                0));

        questions.add(new Question("What planet is known as the Red Planet?",
                List.of("Earth", "Venus", "Mars", "Jupiter"),
                2));

        return questions;

    }

    //History Quiz
    public static List<Question> getHistoryQuestion() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Who was the first President of the United States?",
                List.of("Thomas Jefferson", "Abraham Lincoln", "George Washington", "John Adams"),
                2));

        questions.add(new Question("In which year did World War II end?",
                List.of("1942", "1945", "1948", "1950"),
                1));

        return questions;
    }

    //Technology Quiz:
    public static List<Question> getTechnologyQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Who is known as the father of computers?",
                List.of("Alan Turing", "Charles Babbage", "Steve Jobs", "Bill Gates"),
                1));

        questions.add(new Question("What does 'HTTP' stand for?",
                List.of("HyperText Transfer Protocol", "HyperText Transmission Protocol",
                        "High Transfer Text Protocol", "HyperTerminal Transfer Protocol"),
                0));

        return questions;
    }


}
