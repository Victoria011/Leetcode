package AmazonEncoding;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1226#24#";
		int[] result = new int[26]; // fixed length int list
		int prev = 0;
		int curr = 0;
		int idx = 0;
		for (int i=0; i<s.length(); i++) {
			if (((int)s.charAt(i) >=48) && ( (int)s.charAt(i) <= 57 )) { // digital 0-9
				if ((i + 2 < s.length()) && (s.charAt(i + 2) == '#')) {
					prev = s.charAt(i) - 48;
					curr = s.charAt(i+1) - 48;
					idx =  prev*10 + curr - 1;
					if ( (i+5 < s.length()) && (s.charAt(i + 3) == '(') && (s.charAt(i + 5) == ')') ) {
						int count = s.charAt(i + 4) - 48;
						result[idx] += count;
						i += 5;
					} else {
						result[idx] += 1;
						i += 2;
					}
				} else if ( (i + 3 < s.length()) && (s.charAt(i + 1) == '(') && (s.charAt(i + 3) == ')')) {
					int count = s.charAt(i + 2) - 48;
					idx = s.charAt(i) - 48 - 1;
					result[idx] += count;
					i += 3;
				} else {
					idx = s.charAt(i)- 48 -1;
//					System.out.print("idx: "+idx);
					result[idx] += 1;
				}
			}
		}
		System.out.println("--- Result:");
		for (int j=0; j < result.length; j++) {
			System.out.print(result[j] + " ");
		}
//		return result;
	}

}
