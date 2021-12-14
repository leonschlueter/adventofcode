package days;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import util.InputReader;

public class DayFourteen {

	public static void main(String[] args) {
		// Read input and return array
		InputReader ir = new InputReader("dayFourteen.txt");
		long beginTime = System.currentTimeMillis();
		HashMap<String, String> map = ir.getFourTeen();
		LinkedList<Character> list = ir.res;
		InputReader irB = new InputReader("dayFourteen.txt");
		HashMap<String, String> mapB = irB.getFourTeen();
		LinkedList<Character> listB = irB.res;
		// Task A:
		for (int i = 0; i < 10; i++) {
			String[] insertion = getInsertion(list, map);
			list = insert(insertion, list);
		}
		HashMap<Character, Long> charCountMap = countLetter(list);
		long max = Collections.max(charCountMap.values());
		long min = Collections.min(charCountMap.values());

		long taskAtime = (System.currentTimeMillis() - beginTime);
		System.out.println("====[RESULT]====");
		System.out.println("Task A: " + (max - min));
		beginTime = System.currentTimeMillis();
		// Task B:

		/*
		 * for (int i = 0; i < 40; i++) {
		 * System.out.println("[PROGRESS] Step "+i+" started"); String[] insertion =
		 * getInsertion(listB, map);
		 * System.out.println("[PROGRESS] Step "+i+" getInsertion done."); listB =
		 * insert(insertion, listB);
		 * System.out.println("[PROGRESS] Step "+i+" Insertion done."); }
		 * System.out.println("[PROGRESS] Count Started."); HashMap<Character, Long>
		 * charCountMapB = countLetter(listB); long maxB =
		 * Collections.max(charCountMapB.values()); long minB =
		 * Collections.min(charCountMapB.values()); System.out.println("Task B: " +
		 * (maxB - minB));
		 */

		HashMap<String, Long> numOfPairs = addPairs(listB);
		for (int i = 0; i < 40; i++) {
			numOfPairs = addRules(numOfPairs, mapB);
		}

		HashMap<String, Long> counter = countPairs(numOfPairs, "" + listB.get(0), "" + listB.get(listB.size() - 1));
		long maxB = Collections.max(counter.values());
		long minB = Collections.min(counter.values());
		System.out.println("Task B: " + (maxB - minB));
		long taskBtime = (System.currentTimeMillis() - beginTime);
		System.out.println("=====[TIME]=====");
		System.out.println("Time Task A: " + taskAtime + "ms");
		System.out.println("Time Task B: " + taskBtime + "ms");
		System.out.println("Total time: " + (ir.lastTime + taskAtime + taskBtime) + "ms");
	}

	private static HashMap<String, Long> countPairs(HashMap<String, Long> numOfPairs, String start, String end) {
		// TODO Auto-generated method stub
		HashMap<String, Long> c = new HashMap<String, Long>();
		Iterator it = numOfPairs.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			String[] letters = ("" + entry.getKey()).split("");
			long num = (Long) entry.getValue();

			if (c.containsKey(letters[0])) {
				c.put(letters[0], c.get(letters[0]) + num);
			} else {

				c.put(letters[0], (long) num);
			}
			if (c.containsKey(letters[1])) {
				c.put(letters[1], c.get(letters[1]) + num);
			} else {
				c.put(letters[1], (long) num);
			}
		}
		HashMap<String, Long> fHm = new HashMap<String, Long>();
		Iterator i = c.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry entry = (Entry) i.next();
			long toAdd = (Long) entry.getValue();
			String str = "" + entry.getKey();
			if (str.equals(start) && str.equals(end)) {
				toAdd = 2 + ((toAdd - 2) / 2);
			} else if (str.equals(start) || str.equals(end)) {
				toAdd = 1 + ((toAdd - 1) / 2);
			} else {
				toAdd = toAdd / 2;
			}
			fHm.put(str, toAdd);

		}

		return fHm;
	}

	private static HashMap<String, Long> addPairs(LinkedList<Character> list) {

		HashMap<String, Long> charCountMap = new HashMap<String, Long>();
		for (int i = 1; i < list.size(); i++) {
			String pair = "" + list.get(i - 1) + list.get(i);
			if (charCountMap.containsKey(pair)) {

				// If char is present in charCountMap,
				// incrementing it's count by 1
				charCountMap.put(pair, charCountMap.get(pair) + 1);
			} else {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				charCountMap.put(pair, (long) 1);
			}
		}
		return charCountMap;
	}

	private static HashMap<String, Long> addRules(HashMap<String, Long> pairs, HashMap<String, String> map) {
		Iterator it = pairs.entrySet().iterator();
		HashMap<String, Long> nHM = new HashMap<String, Long>();
		while (it.hasNext()) {
			Map.Entry entry = (Entry) it.next();

			String p = "" + entry.getKey();
			String l = map.get(p);

			String pairA = p.charAt(0) + l;
			String pairB = l + p.charAt(1);

			if (nHM.containsKey(pairA)) {
				nHM.put(pairA, nHM.get(pairA) + pairs.get(p));
			} else {

				nHM.put(pairA, (long) pairs.get(p));
			}
			if (nHM.containsKey(pairB)) {
				nHM.put(pairB, nHM.get(pairB) + +pairs.get(p));
			} else {
				nHM.put(pairB, (long) pairs.get(p));
			}
		}

		return nHM;
	}

	private static HashMap<Character, Long> countLetter(LinkedList<Character> list) {

		// TODO Auto-generated method stub
		HashMap<Character, Long> charCountMap = new HashMap<Character, Long>();
		for (char c : list) {
			if (charCountMap.containsKey(c)) {

				// If char is present in charCountMap,
				// incrementing it's count by 1
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				charCountMap.put(c, (long) 1);
			}
		}
		return charCountMap;
	}

	public static void printList(LinkedList<Character> l) {
		String s = "";
		for (char c : l) {
			s += c;
		}
		System.out.print(s);
	}

	public static String[] getInsertion(LinkedList<Character> list, HashMap<String, String> map) {
		String[] insertedTo = new String[list.size()];
		for (int i = 1; i < list.size(); i++) {
			String pair = "" + list.get(i - 1) + list.get(i);

			if (map.containsKey(pair)) {
				insertedTo[i - 1] = map.get(pair);
			}
		}
		return insertedTo;
	}

	public static LinkedList<Character> insert(String[] insertedTo, LinkedList<Character> list) {
		int inserted = 0;
		for (int i = 0; i < insertedTo.length; i++) {
			if (insertedTo[i] != null) {
				char toInsert = insertedTo[i].charAt(0);
				list.add(i + 1 + inserted, toInsert);
				inserted++;
			}
		}
		return list;
	}

}
