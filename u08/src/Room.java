

public class Room {
	int age;
	public Room[] doorsTo;

	public Room(int age, Room[] doorsTo) {
		this.age = age;
		this.doorsTo = doorsTo;
	}

	public boolean isExit() {
		return doorsTo.length == 0;
	}

	public int getAge() {
		return age;
	}
}
