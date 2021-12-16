package util;

public class Literal {
	int version;
	int id;
	int value;

	public Literal(String bin) {
		this.version = Integer.parseInt(bin.substring(0, 3), 2);
		this.id = Integer.parseInt(bin.substring(3, 6), 2);
	}

	public void printPacket() {
		// TODO Auto-generated method stub
		System.out.println("version: " + this.version + ", id: " + this.id + ", value: " + this.value);
	}
}
