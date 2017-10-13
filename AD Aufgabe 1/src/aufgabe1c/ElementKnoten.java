package aufgabe1c;

import aufgabe1a.Elem;

public class ElementKnoten
{
	ElementKnoten _next;
	
	private Elem<?> _elem;
	
	public ElementKnoten(Elem<?> elem)
	{
		setElem(elem);
	}
	
	public void setNext(ElementKnoten next)
	{
		_next = next;
	}
	
	public ElementKnoten getNext()
	{
		return _next;
	}

	public Elem<?> getElem()
	{
		return _elem;
	}

	public void setElem(Elem<?> elem)
	{
		_elem = elem;
	}
}
