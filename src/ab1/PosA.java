package ab1;

public class PosA<T> extends Pos<T> {

	public int index;

	public PosA(int index, Set<T> set) {
		this.index = index;
		this.set = set;
		this.isValid = index >= 0 && index < set.size();
	}
}
