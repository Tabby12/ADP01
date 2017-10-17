package ab1;
public class TestSetA<T> extends SetTestNeu<T>
{

	@Override
	public Set<T> erzeugeSet()
	{
		return new SetA<T>();
	}
}
