package aufgabe1a;

public class Elem<T extends Comparable<T>> 
{
	private T _element;
	
	private int _key;
	
	public Elem(T element)
	{
		_element = element;
		if(element != null)
		{
			setKey(element.hashCode());
		}
	}

	public int getKey() {
		return _key;
	}

	public void setKey(int key) {
		_key = key;
	}
	
	@Override
	public String toString() 
	{
		return "Key: " + _key + ", Element: " + _element;
	}
}
