package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Operator extends Packet {
	Packet[] subpackets;
	int lenID;

	public Operator(String bin, int start) {
		super(bin, start);
		this.lenID = Integer.parseInt("" + bin.charAt(6 + start));
		this.endIndex = 8 + start;
		this.type = "operator";

		if (lenID == 0) {
			endIndex += 14;
			int lenOfSubPackets = Integer.parseInt(bin.substring(7 + start, 22 + start), 2);
			createSubpackets(lenOfSubPackets);
		} else if (lenID == 1) {
			endIndex += 10;
			createSubpacketsNum(Integer.parseInt(bin.substring(7 + start, 18 + start), 2));
		}
		getVersionSum();
		this.value = evaluatePacket();
	}

	private long evaluatePacket() {
		long val = 0;
		switch (this.id) {
		case 0:
			val = sum();
			break;
		case 1:
			val = prod();
			break;
		case 2:
			val = min();
			break;
		case 3:
			val = max();
			break;
		case 5:
			val = great();
			break;
		case 6:
			val = less();
			break;
		case 7:
			val = eq();
			break;
		}
		return val;
	}

	private long eq() {
		if (this.subpackets[0].value == this.subpackets[1].value) {
			return 1;
		}
		return 0;
	}

	private long less() {
		if (this.subpackets[0].value < this.subpackets[1].value) {
			return 1;
		}
		return 0;
	}

	private long great() {
		if (this.subpackets[0].value > this.subpackets[1].value) {
			return 1;
		}
		return 0;
	}

	private long max() {
		long[] values = new long[subpackets.length];
		int i = 0;
		for (Packet p : subpackets) {
			values[i] = p.value;
			i++;
		}
		Arrays.sort(values);

		return values[values.length - 1];
	}

	private long min() {
		long[] values = new long[subpackets.length];
		int i = 0;
		for (Packet p : subpackets) {
			values[i] = p.value;
			i++;
		}
		Arrays.sort(values);

		return values[0];
	}

	private long prod() {
		long v = subpackets[0].value;
		for (int i = 1; i < subpackets.length; i++) {
			v *= subpackets[i].value;
		}
		return v;
	}

	private long sum() {
		long v = subpackets[0].value;
		for (int i = 1; i < subpackets.length; i++) {
			v += subpackets[i].value;
		}
		return v;
	}

	private void getVersionSum() {

		long s = version;
		for (Packet p : subpackets) {
			if (p.type.equals("literal")) {
				s += p.version;
			} else {
				Operator o = (Operator) p;
				s += o.versionSum;
			}
		}
		this.versionSum = s;

	}

	private void createSubpackets(int lenOfSubPackets) {
		int start = this.endIndex;
		ArrayList<Packet> pa = new ArrayList<Packet>();
		while (endIndex - start < lenOfSubPackets) {
			Packet p;
			if (Integer.parseInt(bin.substring(3 + endIndex, 6 + endIndex), 2) == 4) {
				p = new Literal(bin, endIndex);
			} else {
				p = new Operator(bin, endIndex);
			}
			this.endIndex = p.endIndex;
			pa.add(p);

		}
		this.subpackets = new Packet[pa.size()];
		for (int i = 0; i < subpackets.length; i++) {
			subpackets[i] = pa.get(i);
		}
	}

	private void createSubpacketsNum(int num) {
		ArrayList<Packet> pa = new ArrayList<Packet>();
		for (int i = 0; i < num; i++) {
			Packet p;
			if (Integer.parseInt(bin.substring(3 + endIndex, 6 + endIndex), 2) == 4) {
				p = new Literal(bin, endIndex);
			} else {
				p = new Operator(bin, endIndex);
			}
			this.endIndex = p.endIndex;
			pa.add(p);

		}
		this.subpackets = new Packet[pa.size()];
		for (int i = 0; i < subpackets.length; i++) {
			subpackets[i] = pa.get(i);
		}
	}

	public void printSubpackets() {
		for (Packet p : subpackets) {
			p.printPacket();
		}
	}
}
