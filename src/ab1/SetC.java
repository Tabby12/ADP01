package ab1;

/**
 * Repräsentation einer Mengenimplementation als einfach verkettete Liste.
 * 
 * @author Helena Lajevardi
 */
public class SetC<T> implements Set<T> {

	/**
	 * Linker Wächterknoten.
	 */
	private Node2<T> head;

	/**
	 * Rechter Wächterknoten.
	 */
	private Node2<T> tail;

	/**
	 * Anzahl der aktuell in der Menge vorhandenen Elemente.
	 */
	private int size;

	/**
	 * Konstruktor.
	 */
	public SetC() {
		head = new Node2<T>(null);
		tail = new Node2<T>(null);

		head.setNext(tail);
		tail.setNext(head);

		size = 0;
	}

	/**
	 * Liefert den Knoten, der gegebenen Position.
	 * 
	 * @param pos die Position des gewünschten Knotens
	 * 
	 * @return den Knoten an gewünschter Position.
	 */
	private Node2<T> getNode(int pos) {

		Node2<T> node = head;

		for (int curPos = -1; curPos < pos; curPos++) {
			node = node.getNext();
		}
		return node;
	}

	@Override
	public int add(Element<T> element) {

		// Precondition
		if (element == null) {
			throw new NullPointerException();
		}

		//Prüfen, ob Element bereits in der Menge
		int pos = find(element.getKey());

		if (pos != -1) {
			return -1;
		}

		// Neues Element einhängen
		Node2<T> newNode = new Node2<T>(element);
		Node2<T> curNode = head;
		pos = 0;
		while (curNode.getNext() != tail) {
			curNode = curNode.getNext();
			pos++;

		}
		curNode.setNext(newNode);
		newNode.setNext(tail);

		size++;
		return pos;
	}

	@Override
	public void delete(int pos) {

		// Preconditions
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException();
		}

		// Hole Element vor dem Gesuchten und ändere Referenzen
		Node2<T> preElementToDelete = getNode(pos - 1);
		preElementToDelete.setNext(preElementToDelete.getNext().getNext());

		size--;
	}

	@Override
	public void delete(Key key) {

		// Preconditions
		if (key == null) {
			throw new NullPointerException();
		}

		// Try to find and delete Element
		int pos = find(key);
		if (pos > -1) {
			delete(pos);
		}
	}

	@Override
	public int find(Key key) {

		// Preconditions
		if (key == null)
			throw new NullPointerException();

		// Laufe von links durch die Liste bis Element gefunden wurde
		Node2<T> curNode = head.getNext();
		int curPos = 0;

		// Setze stopper
		Element<T> dummyElement = new Element<T>(null, key);
		tail.setElement(dummyElement);

		// Suche stopper
		while (!curNode.getElement().getKey().equals(key)) {
			curPos++;
			curNode = curNode.getNext();
		}

		if (curNode == tail) {
			return -1;
		}

		return curPos;
	}

	@Override
	public Element<T> retrieve(int pos) {

		// Preconditions
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException();

		return getNode(pos).getElement();
	}

	@Override
	public void showall() {

		// Ausgabe der Elemente auf der Konsole
		Node2<T> curNode = head.getNext();
		while (curNode != tail) {
			curNode = curNode.getNext();
			System.out.println(curNode.getElement());
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Set<T> unify(Set<T> set) {

		//Precondition
		if (set == null) {
			throw new NullPointerException();
		}

		//Mengen vereinigen
		for (int i = 0; i < set.size(); i++) {
			Element<T> element = set.retrieve(i);
			int pos = find(element.getKey());
			if (pos == -1) {
				add(element);
			}
		}

		return this;
	}

}
