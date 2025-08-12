package main;

public class Console {
	public static void write(int data)      {System.out.print(data);}
	public static void write(double data)   {System.out.print(data);}
	public static void write(String data)   {System.out.print(data);}
	public static void writeln(int data)    {System.out.println(data);}
	public static void writeln(double data) {System.out.println(data);}
	public static void writeln(String data) {System.out.println(data);}
	public static void format(String format, Object ... args) {System.out.printf(format, args);}
}
