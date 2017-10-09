package AB1;

public class Node2<T> {
	
	/**
	 * Gespeichertes Element.
	 */
	private Element<T> element;
	
	/**
	 * Ggf. vorhandener Vorgängerknoten.
	 */
	private Node2<T> next;
	
	/**
	 * Ggf. vorhandender Nachfolgerknoten.
	 */
	private Node2<T> previous;
	
	public Node2(Element<T> element) {
		this.element = element;
	}
	
	public Node2<T> getNext() {
		return next;
	}

	public void setNext(Node2<T> next) {
		this.next = next;
	}

	public Node2<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node2<T> previous) {
		this.previous = previous;
	}

	public Element<T> getElement() {
		return element;
	}

	public void setElement(Element<T> element) {
		this.element = element;
	}
	
	

}
