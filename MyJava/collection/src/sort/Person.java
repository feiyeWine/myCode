package sort;

public class Person {
	private final String name;
	private final int handSome;
	public Person(String name, int handSome) {
		super();
		this.name = name;
		this.handSome = handSome;
	}
	public String getName() {
		return name;
	}
	
	public int getHandSome() {
		return handSome;
	}
	@Override
	public String toString() {
		return "Person: name=" + name + ", handSome=" + handSome+"\n";
	}
	
	
}
