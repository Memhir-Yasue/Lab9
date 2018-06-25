import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestDriver {

	public static void main(String[] args) {
		Test test1 = new Test(); // Initializing Test
		List<Integer> numberOfQuestions = getNumberOfQuestions(); // Query user for each # of question type
		setTestQuestions(numberOfQuestions, test1); // Populating test's question list and question details
		test1.displayTest();
		test1.generateTest(test1.questions,"test.txt");
		test1.generateAnswerKey(test1.questions,"answer key.txt");
	}
	
	public static List<Integer> getNumberOfQuestions() {
		List<Integer> amountsOfQuestions = new ArrayList<>();
		int numberOfObjectiveQuestions = 
				Integer.parseInt(JOptionPane.showInputDialog(null, "Number of objective Questions?",
						"Objective Questions", JOptionPane.INFORMATION_MESSAGE));
		amountsOfQuestions.add(numberOfObjectiveQuestions);
		int numberOfFillInTheBlankQuestions = 
				Integer.parseInt(JOptionPane.showInputDialog(null, "Number of fill in the blank Questions?",
						"Fill In the Blank Questions", JOptionPane.INFORMATION_MESSAGE));
		amountsOfQuestions.add(numberOfFillInTheBlankQuestions);
		int numberOfMultipleChoiceQuestions = 
				Integer.parseInt(JOptionPane.showInputDialog(null, "Number of multiple choice Questions?",
						"Multiple Choice Questions", JOptionPane.INFORMATION_MESSAGE));
		// Make sure at least 10 questions created
		while (numberOfObjectiveQuestions + numberOfFillInTheBlankQuestions +
				numberOfMultipleChoiceQuestions < 10) {
			JOptionPane.showMessageDialog(null, "You must enter at least 10 questions.\nPlease choose again",
					"Minimum of 10 Questions Needed", JOptionPane.INFORMATION_MESSAGE);
			numberOfObjectiveQuestions = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Number of objective Questions?",
							"Objective Questions", JOptionPane.INFORMATION_MESSAGE));
			amountsOfQuestions.add(numberOfObjectiveQuestions);
			numberOfFillInTheBlankQuestions = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Number of fill in the blank Questions?",
							"Fill In the Blank Questions", JOptionPane.INFORMATION_MESSAGE));
			amountsOfQuestions.add(numberOfFillInTheBlankQuestions);
			numberOfMultipleChoiceQuestions = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Number of multiple choice Questions?",
							"Multiple Choice Questions", JOptionPane.INFORMATION_MESSAGE));
		}
		amountsOfQuestions.add(numberOfObjectiveQuestions);
		amountsOfQuestions.add(numberOfFillInTheBlankQuestions);
		amountsOfQuestions.add(numberOfMultipleChoiceQuestions);
		return amountsOfQuestions;
	}
	
	public static void setTestQuestions(List<Integer> numberOfQuestions, Test test) {
		final int OBJECTIVE_INDEX = 0, FILL_IN_THE_BLANK_INDEX = 1, MULTIPLE_CHOICE_INDEX = 2,
				MIN_DIFFICULTY = 1, MAX_DIFFICULTY = 10;
		int questionIndex;
		// Add all Objective question types to test1's question List
		for (int i = 0; i < numberOfQuestions.get(OBJECTIVE_INDEX); i++) {
			questionIndex = i + 1;
			// Get all parameters, pass to constructor, add to Test's question List
			String objectiveQuestionText = JOptionPane.showInputDialog(null, "Enter the question:",
					"Objective Question " + questionIndex + ": Text", JOptionPane.INFORMATION_MESSAGE);
			int objectiveQuestionPointsPossible = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the points possible:",
							"Objective Question " + questionIndex + ": Points Possible",
							JOptionPane.INFORMATION_MESSAGE));
			int objectiveQuestionDifficulty = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the level of difficulty:",
							"Objective Question " + questionIndex + ": Difficulty", JOptionPane.INFORMATION_MESSAGE));
			// Make sure user input is valid for objectiveQuestionDifficulty
			while (objectiveQuestionDifficulty < MIN_DIFFICULTY ||
					objectiveQuestionDifficulty > MAX_DIFFICULTY) {
				objectiveQuestionDifficulty = 
						Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a level of "
								+ "difficulty between " + MIN_DIFFICULTY + " to " + MAX_DIFFICULTY + ":",
								"Objective Question " + questionIndex + ": Difficulty",
								JOptionPane.INFORMATION_MESSAGE));
			}
			String objectiveCorrectAnswer = JOptionPane.showInputDialog(null, "Please enter the correct answer:",
					"Objective Question " + questionIndex + ": Correct Answer", JOptionPane.INFORMATION_MESSAGE);
			int objectiveAnswerSpace = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the answer space:",
							"Objective Question " + questionIndex + ": Answer Space", JOptionPane.INFORMATION_MESSAGE));
			/* 
			  Objective Constructor without pointsEarned:
			  ObjectiveQuestion(String questionText, int pointsPossible, int difficulty, 
			  		String correctAnswer, int answerSpace)
			 */ 
			ObjectiveQuestion newQuestion = 
					new ObjectiveQuestion(objectiveQuestionText,objectiveQuestionPointsPossible,
							objectiveQuestionDifficulty, objectiveCorrectAnswer, objectiveAnswerSpace);
			test.questions.add(newQuestion);
		}
		
		// Add all Fill in the Blank questions to test1's questions List
		for (int i = 0; i < numberOfQuestions.get(FILL_IN_THE_BLANK_INDEX); i++) {
			questionIndex = i + 1;
			// Get all parameters, pass to constructor, add to Test's question List
			String fillInTheBlankQuestionText = JOptionPane.showInputDialog(null, "Enter the question:",
					"Fill In The Blank Question " + questionIndex + ": Text", JOptionPane.INFORMATION_MESSAGE);
			int fillInTheBlankQuestionPointsPossible = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the points possible:",
							"Fill In The Blank Question " + questionIndex + ": Points Possible",
							JOptionPane.INFORMATION_MESSAGE));
			int fillInTheBlankQuestionDifficulty = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the level of difficulty:",
							"Fill In The Blank Question " + questionIndex + ": Difficulty", JOptionPane.INFORMATION_MESSAGE));
			// Make sure user input is valid for objectiveQuestionDifficulty
			while (fillInTheBlankQuestionDifficulty < MIN_DIFFICULTY ||
					fillInTheBlankQuestionDifficulty > MAX_DIFFICULTY) {
				fillInTheBlankQuestionDifficulty = 
						Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a level of "
								+ "difficulty between " + MIN_DIFFICULTY + " to " + MAX_DIFFICULTY + ":",
								"Fill In The Blank Question " + questionIndex + ": Difficulty", JOptionPane.INFORMATION_MESSAGE));
			}
			String fillInTheBlankCorrectAnswer = 
					JOptionPane.showInputDialog("Please enter the correct answer:");
			int fillInTheBlankAnswerSpace = 
					Integer.parseInt(JOptionPane.showInputDialog("Enter the answer space:"));
			/* 
			  Fill in the blank Constructor without pointsEarned:
			  FillInTheBlankQuestion(String questionText, int pointsPossible, int difficulty, 
			  		String correctAnswer, int answerSpace)
			 */ 
			FillInTheBlankQuestion newQuestion = 
					new FillInTheBlankQuestion(fillInTheBlankQuestionText,fillInTheBlankQuestionPointsPossible,
							fillInTheBlankQuestionDifficulty, fillInTheBlankCorrectAnswer, 
							fillInTheBlankAnswerSpace);
			test.questions.add(newQuestion); // Add question to Test's question list
		}
		// Add multiple choice questions to test's question list
		for (int i = 0; i < numberOfQuestions.get(MULTIPLE_CHOICE_INDEX); i++) {
			questionIndex = i + 1;
			// Get all parameters, pass to constructor, add to Test's question List
			String multipleChoiceQuestionText = JOptionPane.showInputDialog(null, "Enter the question:",
					"Multiple Choice Question " + questionIndex + ": Text", JOptionPane.INFORMATION_MESSAGE);
			int multipleChoiceQuestionPointsPossible = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the points possible:",
							"Multiple Choice Question " + questionIndex + ": Points Possible",
							JOptionPane.INFORMATION_MESSAGE));
			int multipleChoiceQuestionDifficulty = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the level of difficulty:",
							"Multiple Choice Question " + questionIndex + ": Difficulty", JOptionPane.INFORMATION_MESSAGE));
			// Make sure user input is valid for objectiveQuestionDifficulty
			while (multipleChoiceQuestionDifficulty < MIN_DIFFICULTY ||
					multipleChoiceQuestionDifficulty > MAX_DIFFICULTY) {
				multipleChoiceQuestionDifficulty = 
						Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a level of "
								+ "difficulty between " + MIN_DIFFICULTY + " to " + MAX_DIFFICULTY + ":",
								"Multiple Choice Question " + questionIndex + ": Difficulty", JOptionPane.INFORMATION_MESSAGE));
			}
			String multipleChoiceCorrectAnswer = 
					JOptionPane.showInputDialog(null, "Please enter the correct answer:",
							"Multiple Choice Question " + questionIndex + ": Correct Answer", JOptionPane.INFORMATION_MESSAGE);
			// Get number of possible answers for question
			int numberOfPossibleAnswers = 
					Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of possible answers:",
							"Multiple Choice Question " + questionIndex + ": Number of Possible Answers",
							JOptionPane.INFORMATION_MESSAGE));
			// Initialize list of possible answers and answer number for user input in inputDialog.
			List<String> multipleChoicePossibleAnswers = new ArrayList<String>();
			int answerChoiceNumber;
			for (int j = 0; j < numberOfPossibleAnswers; j++) {
				answerChoiceNumber = j + 1;
				String multipleChoiceAnswerChoice = 
						JOptionPane.showInputDialog(null, "Please enter answer choice " + answerChoiceNumber + ":",
								"Multiple Choice Question " + questionIndex + ": Answer Choice: " + answerChoiceNumber,
								JOptionPane.INFORMATION_MESSAGE);
				multipleChoicePossibleAnswers.add(multipleChoiceAnswerChoice);
			}
			/* 
			  Multiple Choice Constructor without pointsEarned:
			  MultipleChoiceQuestion(String questionText, int pointsPossible, int difficulty, 
			  		String correctAnswer, List<String> possibleAnswers)
			 */ 
			MultipleChoiceQuestion newQuestion = 
					new MultipleChoiceQuestion(multipleChoiceQuestionText,multipleChoiceQuestionPointsPossible,
							multipleChoiceQuestionDifficulty, multipleChoiceCorrectAnswer,multipleChoicePossibleAnswers);
			test.questions.add(newQuestion); // Add question to test's question list
		}
		
	}

}
