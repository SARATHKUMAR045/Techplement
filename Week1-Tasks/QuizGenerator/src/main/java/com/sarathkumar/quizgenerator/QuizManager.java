package com.sarathkumar.quizgenerator;

import java.util.*;

public class QuizManager {

    private final Map<String, Quiz> quizzes = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public void start() {

        // Main menu loop
        while (true) {
            System.out.println("\n===== Quiz Generator Menu =====");
            System.out.println("1. Take a Quiz by Topic");
            System.out.println("2. Add a New Quiz");
            System.out.println("3. Take a Random Quiz.");
            System.out.println("4. Exit");
            System.out.println("Please select an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> takeQuizByTopic();
                case 2 -> addNewQuiz();
                case 3 -> takeRandomQuiz();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice please try again");

            }
        }
    }

    //Creating a new quiz
    public void addNewQuiz() {

        System.out.println("Enter your quiz topic");
        String topic = scanner.nextLine();

        quizzes.put(topic, new Quiz(topic));
        System.out.println("Topic " + topic + " added successfully");

        Quiz quiz = quizzes.get(topic);

        System.out.println("Enter the question");
        String questionText = scanner.nextLine();

        List<String> options = new ArrayList<>();
        while (true) {
            System.out.println("Enter an a option (or type 'done' to finish): ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("done")) {
                break;
            }
            options.add(option);
        }
        //get input from user for correct answer of this quiz.
        System.out.println("Enter the correct option (1-" + options.size() + "): ");
        int correctAnswer = scanner.nextInt() - 1;
        scanner.nextLine();

        Question question = new Question(questionText, options, correctAnswer);
        if (quiz != null) {
            quiz.addQuestion(question);
        }

        System.out.println("Question added successfully '" + topic + "'!");
    }

    //Take Quiz by default topics
    public void takeQuizByTopic() {

        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available. please add a quiz first");
            return;
        }

        //Show the available quiz topic
        while (true) {
            System.out.println("\nAvailable quiz topics: ");
            quizzes.keySet().forEach(topic -> System.out.println("- " + topic));
            System.out.println("- Return to main menu");


            System.out.println("Please choose any topic from the list above or type 'main' to return.");
            String topic = scanner.nextLine().trim();

            //Give the user the choice to return to the main menu.
            if (topic.equalsIgnoreCase("main")) {
                System.out.println("Returning to main menu....");
                return;
            }

            Quiz quiz = quizzes.get(topic.toLowerCase());
            if (quiz == null) {
                System.out.println("topic not found please provide a valid topic");
                continue; // Go back to the start of the loop to prompt the user again
            }

            List<Question> questions = quiz.getQuestions();
            if (questions.isEmpty()) {
                System.out.println("No question available in the topic");
                return;
            }

            // Use the common method to ask questions and calculate the score
            int score = askQuestions(questions);
            int totalQuestion = questions.size();

            //Displaying the score and feedback
            displayScoreAndFeedback(score, totalQuestion);
            break;
        }
    }

    //Display the score and feedback
    private void displayScoreAndFeedback(int score, int totalQuestion) {
        double winningRatio = (double) score / totalQuestion * 100;

        System.out.println("\n===== Quiz finished =====");

        System.out.println("you got " + score + " out of " + totalQuestion + ".");
        System.out.printf("Your winning Ratio is %.2f%%.%n", winningRatio);


        if (winningRatio == 100) {
            System.out.println("Excellent work! You aced the quiz!");
        } else if (winningRatio >= 75) {
            System.out.println("Great job! You're almost there!");
        } else if (score >= 50) {
            System.out.println("Good effort! Keep practicing to improve.");
        } else {
            System.out.println("Don't worry! Review the material and try again.");
        }

        // Small greeting after the quiz
        System.out.println("\nThanks for taking quiz!");
        scanner.nextLine();

    }

    //Take random generate topic quiz
    public void takeRandomQuiz() {
        List<Question> allQuestions = new ArrayList<>();

        for (Quiz quiz : quizzes.values()) {
            allQuestions.addAll(quiz.getQuestions());
        }
        if (allQuestions.isEmpty()) {
            System.out.println("No questions are available in random quiz");
        }

        // Shuffle the list of questions
        Collections.shuffle(allQuestions);

        int score = askQuestions(allQuestions);
        int totalQuestions = allQuestions.size();

        //Displaying the score and feedback
        displayScoreAndFeedback(score, totalQuestions);

    }

    //Show the question and options to user and get inputs
    private int askQuestions(List<Question> questions) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestions " + (i + 1) + ": " + question.getQuestionText());

            //Display Options
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ": " + options.get(j));
            }

            //get user input
            int userAnswer;
            while (true) {
                System.out.println("your answer (1-" + options.size() + "): ");

                try {
                    userAnswer = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (userAnswer >= 0 && userAnswer < options.size()) break;
                } catch (Exception e) {
                    scanner.nextLine();
                }
                System.out.println("Invalid choice. please enter a valid option");
            }

            //Check correct Answer
            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct! the answer is \"" + options.get(question.getCorrectAnswer()) + "\"");
                score++;

            } else {
                System.out.println("Wrong! the correct answer is \"" + options.get(question.getCorrectAnswer()) + "\"");
            }
        }
        return score;
    }


    //Existing Quizzes
    public QuizManager() {
        Quiz progammingQuiz = new Quiz("Programming Quiz");
        progammingQuiz.setQuestions(DefaultQuizData.getJavaQuestion());
        quizzes.put("Programming".toLowerCase(), progammingQuiz);

        Quiz mathQuiz = new Quiz("math");
        mathQuiz.setQuestions(DefaultQuizData.getMathQuestion());
        quizzes.put("Math".toLowerCase(), mathQuiz);

        Quiz scienceQuiz = new Quiz("science");
        scienceQuiz.setQuestions(DefaultQuizData.getScienceQuestion());
        quizzes.put("Science".toLowerCase(), scienceQuiz);

        Quiz history = new Quiz("history");
        history.setQuestions(DefaultQuizData.getHistoryQuestion());
        quizzes.put("History".toLowerCase(), history);

        Quiz technical = new Quiz("technology");
        technical.setQuestions(DefaultQuizData.getTechnologyQuestions());
        quizzes.put("Technology".toLowerCase(), technical);
    }

}


