package AmazonDiscountList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	public static int findLowestPrice(String[] products, String[] discounts) {
		int result = 0;
		// transform discounts -> hashmap
		Map<String, String[]> discounts_hm = new HashMap<String, String[]>();
		for (String d : discounts) {
			String[] tmp_d = d.split(" ");
			String[] new_d = new String[2];
			new_d[0] = tmp_d[1];
			new_d[1] = tmp_d[2];
			discounts_hm.put(tmp_d[0], new_d);
		}
		
		for (String p : products) {
			String[] tmp_p = p.split(" ");
			int price = Integer.parseInt(tmp_p[0]);
			if (tmp_p.length == 1) {
				result += price; // TODO double check if int
				continue;
			} 
			int tmp_price = Integer.MAX_VALUE;
			for(int i=1; i<tmp_p.length; i++) {
				if (!(tmp_p[i].equals("EMPTY"))) {
					String[] p_discount = discounts_hm.get(tmp_p[i]);
					String discount_type = p_discount[0];
					int discount_amount = Integer.parseInt(p_discount[1]);
					if (discount_type.equals("0")) { // given price
						tmp_price = Math.min(discount_amount, tmp_price);
					} else if (discount_type.equals("1")) {
						float tmp_product_price = price*(1-((float)discount_amount / 100));
						tmp_price = Math.min(tmp_price, Math.round(tmp_product_price));
					} else {
						tmp_price = Math.min(tmp_price, (price - discount_amount));
					}
				}
			}
			result += Math.min(tmp_price, price);
			System.out.println("Result now: "+Integer.toString(result));
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input first line int n = size of array products
		// second line int m = num of elements
		// 接下来 n 连续行  arr of string -> product ["price", "discount", "discount"]
		// int d = discount arr size
		// int 3 -> discount col = 3
		// 接下来 d 行都是 discount
		
		// stimulate stdin?
//		String data = "2\n3\n10 sale january-sale\n200 sale EMPTY\n2\n3\nsale 0 10\njanuary-sale 1 10\n";
//		InputStream stdin = System.in;
//		try {
//		  System.setIn(new ByteArrayInputStream(data.getBytes()));
//		  Scanner scanner = new Scanner(System.in);
////		  System.out.println(scanner.nextLine());
//		} finally {
//		  System.setIn(stdin);
//		}
//		
//		// read input 
//		Scanner input = new Scanner(System.in);
//		while (input.hasNextLine()){
//            System.out.println(input.nextLine());
//        }
		
		// 
//		String s1 = "2";
//		String s2 = "3";
//		String s3 = "10 sale january-sale";
//		String s4 = "200 sale EMPTY";
//		String s5 = "2";
//		String s6 = "3";
//		String s7 = "sale 0 10";
//		String s8 = "january-sale 1 10";
		
		String[] tmp_read = new String[] {
				"2",
				"3",
				"10 sale january-sale",
				"200 sale EMPTY",
				"2",
				"3",
				"sale 0 10",
				"january-sale 1 10"
		};
		int product_count = Integer.parseInt(tmp_read[0]);
		int pc_count = Integer.parseInt(tmp_read[1]);
		String[] product_list = new String[product_count];
		for ( int i = 0; i < product_count; i++ ) {
			String tmp_s = tmp_read[i + 2];
			product_list[i] = tmp_s;
		}
		int discount_count = Integer.parseInt(tmp_read[1 + product_count + 1]);
		int dc_count = Integer.parseInt(tmp_read[1 + product_count + 2]);
		String[] discount_list = new String[discount_count];
		for (int i = 0; i < discount_count; i ++) {
			String tmp_s =  tmp_read[i + 2 + 2 + product_count];
			discount_list[i] = tmp_s;
		}
		
		for (int i = 0; i < product_count; i++) {
			System.out.println(product_list[i]);
		}
		
		for (int i = 0; i < discount_count; i++) {
			System.out.println(discount_list[i]);
		}
		
		int result = findLowestPrice(product_list, discount_list);
		System.out.println("Result = " + Integer.toString(result));
	}

}
