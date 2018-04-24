package ro.ubbcluj.model;

public class Member {
	private String name;
	private String id;

	public Member(String id, String name) {
		this.name = name;
		this.id = id;


	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String toString() {
		return this.name + ";" + this.id;
	}
}
