package ab1;

public class Pos<T> {

	private boolean isValid;

	private Element<T> reference;

	private int index;

	//private Set<T> set;

	public Pos(boolean isValid, Element<T> reference, int index) {

		this.isValid = isValid;
		this.reference = reference;

	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Element<T> getReference() {
		return reference;
	}

	public void setReference(Element<T> reference) {
		this.reference = reference;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
