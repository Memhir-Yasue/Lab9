public class ObjectiveQuestion extends Question {
	
	public ObjectiveQuestion() {/*Default*/}
	
	public ObjectiveQuestion(String questionText, int pointsPossible, int difficulty,
			String correctAnswer, int answerSpace) {
		this.questionText = questionText;
		this.pointsPossible = pointsPossible;
		this.difficulty = difficulty;
		this.correctAnswer = correctAnswer;
		this.answerSpace = answerSpace;
	}
	
	public String toString() {
		String space = "\n";
		for (int i = 0; i < this.answerSpace; i++) {
			space += "\n";
		}
		return this.questionText + space;
	}
}