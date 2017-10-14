package ab1;

/**
 * Repräsentation einer Mengenimplementation als Doppelt verkettete Liste.
 * 
 * @author Helena Lajevardi
 */
public class SetB2<T> implements Set<T> {

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
	public SetB2() {

		head = new Node2<T>(null);
		tail = new Node2<T>(null);

		head.setNext(tail);
		tail.setPrevious(head);

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

		Node2<T> result = null;

		if (pos <= size / 2) {
			// Suche vorwärts
			result = head;
			for (int curNode = -1; curNode < pos; curNode++) {
				result = result.getNext();
			}
		} else {
			// Suche rückwärts
			result = tail;
			for (int curNode = size; curNode > pos; curNode--) {
				result = result.getPrevious();
			}
		}

		return result;
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
		tail.getPrevious().setNext(newNode);
		newNode.setPrevious(tail.getPrevious());
		newNode.setNext(tail);
		tail.setPrevious(newNode);

		size++;

		return size - 1;
	}

	@Override
	public void delete(int pos) {

		// Preconditions
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException();
		}
		// Element aus Kette entfernen
		Node2<T> elementToDelete = getNode(pos);
		elementToDelete.getPrevious().setNext(elementToDelete.getNext());
		elementToDelete.getNext().setPrevious(elementToDelete.getPrevious());

		size--;

	}

	@Override
	public void delete(Key key) {

		// Preconditions
		if (key == null)
			throw new NullPointerException();

		// Suche Element und lösche, falls gefunden
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
		if (pos < 0 || pos > size)
			throw new IndexOutOfBoundsException();

		//Gibt Element an gewünschter Position zurück
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
