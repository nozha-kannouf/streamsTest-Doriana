package be.intec;

public abstract class Person {
	private String name;
	private String lastName;
	
	public Person() {
	}

	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Name= %s, lastName= %s]", name, lastName);
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
