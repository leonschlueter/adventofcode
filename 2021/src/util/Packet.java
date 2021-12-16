package util;

import java.util.ArrayList;

public class Packet {
	int start;
	long version;
	int id;
	String bin;
	int endIndex;
	String type;
	public long value;
	Packet[] subpackets;
	public long versionSum;
	
	public Packet(String bin, int start) {
		this.bin = bin;
		this.start = start;
		this.version = Integer.parseInt(bin.substring(0 + start, 3 + start), 2);
		this.id = Integer.parseInt(bin.substring(3 + start, 6 + start), 2);

	}


	public void printPacket() {
		System.out.println("type: " + this.type + ", version: " + this.version + ", version Sum: " + this.versionSum
				+ ", id: " + this.id + ", endIndex: " + this.endIndex + ", value: " + this.value);
	}
}
