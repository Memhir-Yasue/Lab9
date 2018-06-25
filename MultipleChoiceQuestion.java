import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
	protected List<String> possibleAnswers = new ArrayList<String>();
	
	public MultipleChoiceQuestion() {/*Default*/};
	
	public MultipleChoiceQuestion(String questionText, int pointsPossible, int difficulty,
			String correctAnswer, List<String> possibleAnswers) {
		this.questionText = questionText;
		this.pointsPossible = pointsPossible;
		this.pointsEarned = pointsEarned;
		this.difficulty = difficulty;
		this.correctAnswer = correctAnswer;
		this.possibleAnswers = possibleAnswers;
	}
	
	public String toString() {
		String answerChoices = "";
		for (int i=0; i < this.getPossibleAnswers().size(); i++) {
			answerChoices += " - " + this.getPossibleAnswers().get(i) + "\n";
		}
		return this.getQuestionText() + "\n" + answerChoices;
	}
	
	public void addAnswer(String userAnswer) {
		this.getPossibleAnswers().add(userAnswer);
	}
	
	public void removeAnswer(String userAnswer) {
		this.getPossibleAnswers().remove(userAnswer);
	}

	public void setPossibleAnswers(List<String> userAnswer) {
		this.possibleAnswers = userAnswer;
	}

	public List<String> getPossibleAnswers() {
		return this.possibleAnswers;
	}
	
}