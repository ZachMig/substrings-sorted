import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
		String input = "banana boat";
		
		Map<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		char[] chars = input.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				if((int)chars[j] < 97 || (int)chars[j] > 122) {
					sb = new StringBuilder();
					break;
				} else {
					sb.append(chars[j]);
					String temp = sb.toString();
					if (map.containsKey(temp)) {
						map.put(temp, map.get(temp) + 1);
					} else {
						map.put(temp, 1);
					}
				}
			}
			sb = new StringBuilder();
		}
				
		List<Occurance> occs = new ArrayList<>();
		
		for (String s : map.keySet()) {
			occs.add(new Occurance(s, map.get(s)));
		}
		
		Collections.sort(occs, 
			(o1, o2) -> 
			o1.getK().equals(o2.getK()) ? o2.getV() - o1.getV() : o1.getK().compareTo(o2.getK()));
		
		occs.stream().forEach(System.out::println);
		
	}
}

class Occurance {
	private String k;
	private int v;
	
	public Occurance(String k, int v) {
		this.k = k;
		this.v = v;
	}
	
	public String getK() {
		return k;
	}
	
	public int getV() {
		return v;
	}
	
	public String toString() {
		return new String(this.k + ": " + this.v);
	}
	
	
}
