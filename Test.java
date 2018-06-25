import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
	
	protected List<Question> questions = new ArrayList<Question>();
	protected int totalPossiblePoints;
	protected int totalPointsEarned;
	
	public Test() {/*Default*/}
	
	public Test(List<Question> questions) {
		this.questions = questions;
	}
	
	public void setTotalPossiblePoints() {
		// Add each question's possible points to totalPossiblePoints via loop
		for (int i=0; i < this.questions.size(); i++) {
			this.totalPossiblePoints += this.questions.get(i).getPointsPossible();
		}
	}

	public int getTotalPossiblePoints() {
		return this.totalPossiblePoints;
	}
	
	public void gradeTest() {
		// Add each question's points earned to totalPointsEarned via loop
		for (int i=0; i < this.questions.size(); i++) {
			this.totalPointsEarned += this.questions.get(i).getPointsEarned();
		}
	}
	
	public void displayTest() {
		// Create output string with test header
		String output = "Name:___________________________\nDate:__________\n"
				+ "Subject:___________________________\n\n";
		int questionIndex;
		// Loop through all questions
		for (int i=0; i < this.questions.size(); i++) {
			questionIndex = i + 1; // For output string
			// Append each question to end of string
			output += "Question " + questionIndex + ". " + this.questions.get(i).toString();
		}
		// Creating scrollable area for test to be displayed
		JTextArea textArea = new JTextArea(output);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 750, 750 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Test", JOptionPane.OK_OPTION);
	}
	
	public void generateTest(List<Question> questions, String outputFileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			writer.write("Name:\nDate:\nSubject:\n\n\n");
			for (int i = 0; i < questions.size(); i++) {
			    writer.write(questions.toString());
			}
		    writer.close();
		} catch (IOException e) {
		    System.err.println("Error writing test file.");
		}
	}
	
	public void generateAnswerKey(List<Question> questions, String outputFileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			writer.write("Test Answer Key\n\n");
			int answerIndex;
			for (int i = 0; i < questions.size(); i++) {
				answerIndex = i +1;
			    writer.write("Question " + answerIndex + " Answer:\n" + questions.get(i).getCorrectAnswer() + "\n");
			    writer.newLine();
			}
		    writer.close();
		} catch (IOException e) {
		    System.err.println("Error writing answer key file.");
		}
	}
	
	
}