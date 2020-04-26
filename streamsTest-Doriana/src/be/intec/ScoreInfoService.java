package be.intec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class ScoreInfoService {
	//private long numberOfStudents;
	ScoreInfo[] scoreData = {};

	public ScoreInfoService() {
	}

	public void addScoreInfo(ScoreInfo scoreInfo) {
		boolean thereIsNull = false;
		for (int i = 0; i < scoreData.length; i++) {
			if (scoreData[i] == null) {
				thereIsNull = true;
				scoreData[i] = scoreInfo;
				break;
			} else {
				thereIsNull = false;
			}

		}
		if (!thereIsNull) {
			ScoreInfo[] tmp = scoreData;
			scoreData = Arrays.copyOf(tmp, tmp.length + 1);
			scoreData[(scoreData.length) - 1] = scoreInfo;

		}
	}

	public void getNumberOfStudents() {
		System.out.println(Stream.of(scoreData).count());
	}

	public void calculateAverageScore() {
		Double doubleResult = 0.0;
		OptionalDouble resultat = Stream.of(scoreData)
								    .filter(Objects::nonNull)
									.mapToDouble(ScoreInfo::getScore)
									.average();
		if (resultat.isPresent()) {
			doubleResult = resultat.getAsDouble();
			System.out.println(doubleResult);
		}
		else {
			System.out.println("No average calculated! ");
		}

	}
	
	public long filterScore() {
		long result= Stream.of(scoreData)
			    .filter(Objects::nonNull)
				.mapToDouble(ScoreInfo::getScore)
				.filter(s -> s>=90)
				.count();
		return result;
	}
	public String[] getFailedStudents() {
		String[] failedStudents= Stream.of(scoreData)
				.filter(Objects::nonNull)
				.filter(s -> s.getScore()<60)
				.map(ScoreInfo:: getStudent)
				.map(student-> student.getName()+" "+student.getLastName())
				.toArray(String[]::new)
				;  
		
		return failedStudents;
	}
	
	public void printFailingStudents() {
		String [] students = getFailedStudents();
		Stream.of(students).forEach(System.out::println);
	}
	
	public void getDataSortedByScore() {
		String [] students=
				Stream.of(scoreData)
							.filter(Objects::nonNull)
							.sorted(Comparator.comparing(ScoreInfo :: getScore))
							.map(scoreInfo-> scoreInfo.getStudent().getName()
											+" "+ scoreInfo.getStudent().getLastName()
											+" "+ scoreInfo.getScore())
							.toArray(String[]:: new);
				
		Stream.of(students).forEach(System.out::println);
		
		
	}
	public void getDataSortedByLastName() {
		String [] students=	Stream.of(scoreData)
							.filter(Objects::nonNull)
							.sorted(Comparator.comparing(scoreInfo -> scoreInfo.getStudent().getLastName()))
							.map(scoreInfo -> scoreInfo.getStudent().getName()
												+" "+ scoreInfo.getStudent().getLastName()
												+" "+ scoreInfo.getScore()
												)
							.toArray(String[]:: new);
				
		Stream.of(students).forEach(System.out::println);
		
		
	}

	

}
