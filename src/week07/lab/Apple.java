package week07.lab;

public class Apple implements Fruit
{
	public Apple(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
			return name;
	}

	private String name;
}
