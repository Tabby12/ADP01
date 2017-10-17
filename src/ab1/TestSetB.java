package ab1;

public class TestSetB<T> extends SetTestNeu<T>
{

	@Override
	public Set<T> erzeugeSet()
	{
		return new SetC<>();
	}
	
}
