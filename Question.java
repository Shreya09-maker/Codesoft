package Quiz;

public class Question {
	
	    String question;
	    String[] options;
	    int correctAnswerIndex;

	    public Question(String question, String[] options, int correctAnswerIndex) {
	        this.question = question;
	        this.options = options;
	        this.correctAnswerIndex = correctAnswerIndex;
	    }
	}

