package be.intec;



public class Main {

	public static void main(String[] args) {

		ScoreInfoService scoreInfoService= new ScoreInfoService();
		scoreInfoService.addScoreInfo(new ScoreInfo(80, new Student("nozha", "kannouf")));
		scoreInfoService.addScoreInfo(new ScoreInfo(20, new Student("amine", "lahri")));
		scoreInfoService.addScoreInfo(new ScoreInfo(90, new Student("mona", "zeriouh")));
		scoreInfoService.addScoreInfo(new ScoreInfo(30, new Student("hassana", "boukhou")));
		scoreInfoService.addScoreInfo(null);
		scoreInfoService.getNumberOfStudents();
		scoreInfoService.calculateAverageScore();
		System.out.println(scoreInfoService.filterScore());
		//System.out.println(Arrays.toString(scoreInfoService.getFailedStudents()));
		scoreInfoService.printFailingStudents();
		scoreInfoService.getDataSortedByLastName();
	}

}
