package be.intec;

public class Student extends Person {
	private int id;
	private static int incrementId = 0;// final

	public Student() {
		super();
		this.id = getIncremented();
	}

	public Student(String name, String lastName) {
		super(name, lastName);
		this.id = getIncremented();
	}

	private int getIncremented() {
		incrementId++;
		return incrementId;
	}

	@Override
	public String toString() {
		return super.toString() + " id= " + this.id;
	}

	
}
