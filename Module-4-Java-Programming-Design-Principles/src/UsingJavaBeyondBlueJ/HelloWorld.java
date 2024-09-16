package UsingJavaBeyondBlueJ;

public class HelloWorld {

	//Example 1
//	public static void main(String[] args) {
//		FileResource hello = new FileResource("hellow_unicode.txt");
//		for(String line : hello.lines())
//		{
//			if(args.length == 0)
//				System.out.println(line);
//		}
//
//	}
	
	//Example 2: can use the args array to change file the program reads without recompiling the code
//	public static void main(String[] args) {
//		FileResource hello = new FileResource(args[0]);
//		for(String line : hello.lines())
//		{
//			if(args.length == 0)
//				System.out.println(line);
//		}
//
//	}
	
	//example 3: check if person that runs program provides the right number of arguments
	public static void main(String[] args) {
		
		if(args.length ==0)
		{
			System.out.println("Please specify the filename");
			System.exit(1);
		}
		FileResource hello = new FileResource(args[0]);
		for(String line : hello.lines())
		{
			if(args.length == 0)
				System.out.println(line);
		}

	}

}
