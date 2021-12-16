package util;

public class Literal extends Packet {
	
	public Literal(String bin, int start) {
		super(bin, start);
		this.endIndex = 3;
		this.type = "literal";
		getValue();
		this.versionSum = version;

	}

	private void getValue() {
		String fiveBits = "";
		String val = "";
		int i = 0;
		int end = 3 + start;
		boolean lastGroup = false;
		while (!lastGroup) {
			end += 5;
			if (!lastGroup) {
				fiveBits = bin.substring(start + 6 + 5 * i, start + 11 + 5 * i);
			}
			if (fiveBits.charAt(0) == '0') {
				lastGroup = true;
			}
			val += fiveBits.substring(1, 5);
			i++;
		}

		this.endIndex += end;
		this.value = Long.parseLong(val, 2);
	}
}
