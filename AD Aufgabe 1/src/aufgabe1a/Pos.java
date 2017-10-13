package aufgabe1a;

public class Pos
{
	private boolean _isValid;
	
	private Elem<?> _elem;
	
	private Set _set;
	
	public Pos(Elem<?> elem, Set set, boolean isValid)
	{
		_elem = elem;
		setSet(set);
		_isValid = isValid;
	}
	
	public boolean isValid()
	{
		return _isValid;
	}
	
	public void setIsValid(boolean isValid)
	{
		_isValid = isValid;
	}
	
	public Elem<?> getElememt()
	{
		return _elem;
	}

	public Set getSet()
	{
		return _set;
	}

	public void setSet(Set set)
	{
		_set = set;
	}
	
}
