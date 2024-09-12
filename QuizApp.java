package Quiz;
	import java.util.*;
	import java.util.concurrent.*;

	public class QuizApp {

	    // Store quiz questions along with options and correct answers
	    static List<Question> quizQuestions = Arrays.asList(
	        new Question("What is the capital of France?", new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"}, 0),
	        new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 1)
	    );

	    public static void startQuiz() {
	        Scanner scanner = new Scanner(System.in);
	        int score = 0;
	        int questionIndex = 0;
	        int totalQuestions = quizQuestions.size();
	        Map<Integer, Boolean> results = new HashMap<>();

	        while (questionIndex < totalQuestions) {
	            Question question = quizQuestions.get(questionIndex);
	            System.out.println("Question " + (questionIndex + 1) + ": " + question.question);

	            // Display options
	            for (String option : question.options) {
	                System.out.println(option);
	            }

	            // Timer for each question
	            final int questionIndexFinal = questionIndex;
	            final int correctAnswerIndex = question.correctAnswerIndex;
	            Timer timer = new Timer();
	            final int[] userAnswer = { -1 };

	            TimerTask task = new TimerTask() {
	                @Override
	                public void run() {
	                    if (userAnswer[0] == -1) { 
	                        results.put(questionIndexFinal, false);
	                        System.out.println("\nTime is up! The correct answer was: " + (correctAnswerIndex + 1));
	                    }
	                }
	            };

	            timer.schedule(task, 15000); // 15 seconds for each question

	            // Read user input
	            try {
	                userAnswer[0] = scanner.nextInt() - 1; 
	                timer.cancel(); 
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.next(); 
	                continue;
	            }

	            if (userAnswer[0] == question.correctAnswerIndex) {
	                System.out.println("Correct!");
	                score++;
	                results.put(questionIndex, true);
	            } else {
	                System.out.println("Incorrect. The correct answer was: " + (question.correctAnswerIndex + 1));
	                results.put(questionIndex, false);
	            }

	            questionIndex++;
	        }

	        // Display the final score and summary
	        System.out.println("\nQuiz Complete!");
	        System.out.println("Your final score is: " + score + "/" + totalQuestions);

	        for (int i = 0; i < totalQuestions; i++) {
	            System.out.println("Question " + (i + 1) + ": " + (results.get(i) ? "Correct" : "Incorrect"));
	        }

	        scanner.close();
	    }
	}

