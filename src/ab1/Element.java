package ab1;

/**
 * Diese Klasse repräsentiert ein Element.
 * 
 * @author Helena Lajevardi
 */
public class Element<T> {

	/**
	 * Schlüssel des Elements.
	 */
	private Key key;

	/**
	 * Zu speichernder Inhalt.
	 */
	private T data;

	public Element(T data) {
		this(data, new Key());
	}

	public Element(T data, Key key) {
		this.data = data;
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public T getData() {
		return data;
	}

}
