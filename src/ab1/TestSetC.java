package ab1;

public class TestSetC<T> extends SetTestNeu<T>
{

	@Override
	public Set<T> erzeugeSet()
	{
		return new SetC<>();
	}

}
