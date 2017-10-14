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
	private Node2<T> getNode(Pos<T> pos) {

		Node2<T> result = null;

		if (pos.getIndex() <= size / 2) {
			// Suche vorwärts
			result = head;
			for (int curNode = -1; curNode < pos.getIndex(); curNode++) {
				result = result.getNext();
			}
		} else {
			// Suche rückwärts
			result = tail;
			for (int curNode = size; curNode > pos.getIndex(); curNode--) {
				result = result.getPrevious();
			}
		}

		return result;
	}

	@Override
	public Pos<T> add(Element<T> element) {

		// Precondition
		if (element == null) {
			throw new NullPointerException();
		}

		//Prüfen, ob Element bereits in der Menge
		Pos<T> pos = find(element.getKey());

		if (pos.isValid()) {
			return new Pos<T>(false, null, -1);
		}

		// Neues Element einhängen
		Node2<T> newNode = new Node2<T>(element);
		tail.getPrevious().setNext(newNode);
		newNode.setPrevious(tail.getPrevious());
		newNode.setNext(tail);
		tail.setPrevious(newNode);

		size++;

		return new Pos<T>(true, element, size);
	}

	@Override
	public void delete(Pos<T> pos) {

		// Preconditions
		if (pos.getIndex() < 0 || pos.getIndex() > size) {
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
		Pos<T> pos = find(key);
		if (pos.isValid()) {
			delete(pos);
		}

	}

	@Override
	public Pos<T> find(Key key) {

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
			return new Pos<T>(false, null, -1);
		}

		return new Pos<T>(true, curNode.getElement(), curPos);
	}

	@Override
	public Element<T> retrieve(Pos<T> pos) {
		return pos.getReference();
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

		Node2<T> curNode = head.getNext();

		while (curNode != tail) {
			set.add(curNode.getElement());
			curNode = curNode.getNext();
		}

		return set;
	}

}
