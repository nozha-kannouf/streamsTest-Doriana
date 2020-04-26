package be.intec;

public class ScoreInfo {
	private int score;
	private Student student;
	
	public ScoreInfo(int score, Student student) {
		this.score = score;
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("ScoreInfo [score=%s, student=%s]", score, student);
	}
	
	public int getScore() {
		return score;
	}
	
	public Student getStudent() {
		return student;
	}
	
	
}
