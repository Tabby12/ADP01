package AB1;

import java.lang.reflect.Array;

/**
 * 
 * 
 * @author Helena Lajevardi
 *
 */
public class SetB1<T> implements Set<T> {

	/**
	 * Anzahl der aktuell in der Menge vorhandenen Elemente.
	 */
	private int size;

	/**
	 * Array zur Datenspeicherung
	 */
	private Node1<T>[] nodes;

	/**
	 * Konstruktor.
	 */
	@SuppressWarnings("unchecked")
	public SetB1() {
		nodes = (Node1<T>[]) Array.newInstance(Node1.class, 2);
		size = 0;
	}

	/**
	 * Verlängert das Array.
	 */
	private void enlargeArray() {
		@SuppressWarnings("unchecked")
		Node1<T>[] newData = (Node1<T>[]) Array.newInstance(Node1.class, nodes.length * 2);
		System.arraycopy(nodes, 0, newData, 0, nodes.length);
		nodes = newData;

	}

	@Override
	public int add(Element<T> element) {

		if (element == null) {
			throw new NullPointerException();
		}

		int pos = find(element.getKey());

		if (pos != -1) {
			return -1;
		}

		pos = size;

		if (pos >= nodes.length) {
			enlargeArray();
		}

		nodes[pos] = new Node1<T>(element, pos);
		size++;

		return pos;
	}

	@Override
	public void delete(int pos) {

		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}

		nodes[pos] = null;

		for (int i = pos + 1; i < size; i++) {
			nodes[i - 1] = nodes[i];
		}
		size--;

	}

	@Override
	public void delete(Key key) {

		if (key == null) {
			throw new NullPointerException();
		}

		int pos = find(key);
		if (pos > -1) {
			delete(pos);
		}

	}

	@Override
	public int find(Key key) {

		if (key == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < size; i++) {
			if (nodes[i].getElement().getKey().getValue().equals(key.getValue())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Element<T> retrieve(int pos) {

		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}

		return nodes[pos].getElement();
	}

	@Override
	public void showall() {

		for (int i = 0; i < size; i++) {
			System.out.println(nodes[i]);
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Set<T> unify(Set<T> set) {

		if (set == null) {
			throw new NullPointerException();
		}

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
