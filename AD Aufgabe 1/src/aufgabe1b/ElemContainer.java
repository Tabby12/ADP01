package aufgabe1b;

import aufgabe1a.Elem;

public class ElemContainer
{
	private Elem<?> _elem;
	
	private int _next;
	
	private int _previous;
	
	public ElemContainer(Elem<?> elem)
	{
		setElem(elem);
	}

	public int getPrevious()
	{
		return _previous;
	}

	public void setPrevious(int previous)
	{
		_previous = previous;
	}

	public int getNext()
	{
		return _next;
	}

	public void setNext(int next)
	{
		_next = next;
	}

	public Elem<?> getElem()
	{
		return _elem;
	}

	public void setElem(Elem<?> elem)
	{
		_elem = elem;
	}
	
	@Override
	public String toString()
	{
		return "Previous: " + _previous + ", Next: " + _next + ", " + _elem.toString();
	}
}
