
public class Offer {
	int price, age, id;
	String genus, association;
	
	public Offer(int price, String genus, int age, int id, String association) {
		this.price = price;
		this.genus = genus;
		this.age = age;
		this.id = id;
		this.association = association;
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
