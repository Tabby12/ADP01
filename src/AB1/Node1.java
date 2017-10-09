package AB1;

public class Node1<T> {

	/**
	 * Gespeichertes Element.
	 */
	private Element<T> element;

	/**
	 * Ggf. vorhandener Vorgängerknoten.
	 */
	private int next;

	/**
	 * Ggf. vorhandender Nachfolgerknoten.
	 */
	private int previous;

	public Node1(Element<T> element, int pos) {
		this.element = element;
		this.next = pos + 1;
		this.previous = pos - 1;

	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public Element<T> getElement() {
		return element;
	}

	public void setElement(Element<T> element) {
		this.element = element;
	}

}
