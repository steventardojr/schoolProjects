public class PowerSetGeneration {
	public static void main(String[] args) {
		String input = ""; 
		
		if (args.length == 0) {
			System.out.println("Rerun program with the correct command-line argument.");
			System.exit(0);
		}
		
		for (String s: args)
			input += s;
		input = input.replaceAll("\\s+","");
		
		int length = input.length();
		
		System.out.print("{}, ");
		for (int i = 0; i < length; i ++)
			System.out.print("{" + input.charAt(i) + "}, ");
		
		for (int i = 0; i < length-1; i++) {
			int j = i + 1;
			while (j < length) {
				System.out.print("{" + input.charAt(i) + ","  + input.charAt(j) + "},");
				System.out.print(" ");
				j++;
			}
			j++;
		}
		
		System.out.print("{");
		for (int i = 0; i < length - 1; i++) {
			System.out.print(input.charAt(i) + ",");
		}
		System.out.print(input.charAt(length -1) + "}");
		System.out.println();
	}
}