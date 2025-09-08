package section.b;

import java.util.Random;
import java.util.Scanner;


        public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        MathQuizGame game = new MathQuizGame(name);
        game.start();
        game.play();
    }
}

// Base class (for inheritance)
class Game {
    protected String playerName;

    public Game(String playerName) {
        this.playerName = playerName;
    }

    public void start() {
        System.out.println("Welcome to the Math Quiz, " + playerName + "!");
    }



    Object getPlayerName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

// Child class: MathQuizGame
class MathQuizGame extends Game {
    private String[] questions;
    private int[] answers;
    private int score;
    private final int TOTAL_QUESTIONS = 5;

    public MathQuizGame(String playerName) {
        super(playerName);
        questions = new String[TOTAL_QUESTIONS];
        answers = new int[TOTAL_QUESTIONS];
        score = 0;
        generateQuestions();
    }

    // Generate random math questions (addition, subtraction)
    private void generateQuestions() {
        Random rand = new Random();
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            int a = rand.nextInt(50) + 1;
            int b = rand.nextInt(50) + 1;
            int type = rand.nextInt(2); // 0 = addition, 1 = subtraction

            if (type == 0) {
                questions[i] = a + " + " + b + " = ?";
                answers[i] = a + b;
            } else {
                questions[i] = a + " - " + b + " = ?";
                answers[i] = a - b;
            }
        }
    }

    // Run the quiz
    public void play() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect. Correct answer was: " + answers[i]);
            }
            System.out.println();
        }

        printReport();
    }

    // Print score and result
    private void printReport() {
        System.out.println("\n--- Quiz Report ---");
        System.out.println("Player: " + playerName);
        System.out.println("Total Questions: " + TOTAL_QUESTIONS);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (TOTAL_QUESTIONS - score));
        System.out.println("Final Score: " + (score * 100 / TOTAL_QUESTIONS) + "%");
        System.out.println(score >= 3 ? "🎉 Well done!" : "📚 Keep practicing!");
        System.out.println("-------------------");
    }
}
