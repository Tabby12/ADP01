package AB1;

import java.lang.reflect.Array;

/**
 * Repräsentation einer Mengenimplementation als Arrayliste.
 * 
 * @author Helena Lajevardi
 *
 */
public class SetA<T> implements Set<T> {

	/**
	 * Anzahl der aktuell in der Menge vorhandenen Elemente.
	 */
	private int size;

	/**
	 * Array zur Speicherung der Elemente in der Menge.
	 */
	private Element<T>[] elements;

	/**
	 * Konstruktor.
	 */
	@SuppressWarnings("unchecked")
	public SetA() {
		elements = (Element<T>[]) Array.newInstance(Element.class, 2);
		size = 0;
	}

	/**
	 * Verlängert das Array.
	 */
	private void enlargeArray() {
		@SuppressWarnings("unchecked")
		Element<T>[] newData = (Element<T>[]) Array.newInstance(Element.class, elements.length * 2);
		System.arraycopy(elements, 0, newData, 0, elements.length);
		elements = newData;

	}

	@Override
	public int add(Element<T> element) {

		//Precondition
		if (element == null) {
			throw new NullPointerException();
		}
		//Prüfen, ob Element bereits in der Menge
		int pos = find(element.getKey());

		if (pos != -1) {
			return -1;
		}

		// Verlängere Array falls nötig
		if (size >= elements.length) {
			enlargeArray();
		}

		// Füge neues Element ein
		pos = size;
		elements[pos] = element;
		size++;

		return pos;
	}

	@Override
	public void delete(int pos) {

		//Precondition
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}

		// Überschreibe Element
		elements[pos] = null;

		// Kopiere alte Elemente vor
		for (int i = pos + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}

		size--;

	}

	@Override
	public void delete(Key key) {

		//Precondition
		if (key == null) {
			throw new NullPointerException();
		}
		//Löschen des Elements, wenn gefunden
		int pos = find(key);
		if (pos > -1) {
			delete(pos);
		}

	}

	@Override
	public int find(Key key) {

		//Precondition
		if (key == null) {
			throw new NullPointerException();
		}
		// Suche Element und gebe Position zurück falls gefunden
		for (int i = 0; i < size; i++) {
			if (elements[i].getKey().getValue().equals(key.getValue())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Element<T> retrieve(int pos) {

		//Precondition
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		//Gibt Element an gewünschter Position zurück
		return elements[pos];

	}

	@Override
	public void showall() {

		// Ausgabe der Elemente auf der Konsole
		for (int i = 0; i < size; i++) {
			System.out.println(elements[i]);
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
