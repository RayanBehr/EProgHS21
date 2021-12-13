
public class Offer {
	int price, age, id;
	String genus, association;
	
	public Offer(int price, String genus, int age, int id, String association) {
		this.price = price; // non negative
		this.genus = genus; // string
		this.age = age; // positive integer
		this.id = id; // positive and unique
		this.association = association; // string
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getGenus() {
		return genus;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getID() {
		return id;
	}
	
	public String getAssociation() {
		return association;
	}
	
	@Override
	public String toString() {
		return "(" + "Price: " + price + ", Genus: " + genus + ", Age: " + age + ", ID: " + id + ", Association: " + association + ")";
	}
	
}
