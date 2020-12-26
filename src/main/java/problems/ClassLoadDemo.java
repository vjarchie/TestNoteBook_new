package problems;

public class ClassLoadDemo
{
	// non static class initlization would lead to stackOverFlowError as the intialization woudl go in infinite loop.
	private static ClassLoadDemo demo = new ClassLoadDemo("a");
	private final String name;

	ClassLoadDemo(String a)
	{
		this.name = a;

		System.out.println("I'm first" + this.name);
	}

	public static void main(String args[])
	{
		//System.out.println("no I'm first");
		ClassLoadDemo demo2 = new ClassLoadDemo("b");
	}
}
