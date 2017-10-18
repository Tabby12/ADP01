package ab1;

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
	public Pos<T> add(Element<T> element) {

		//Precondition
		if (element == null) {
			throw new NullPointerException();
		}
		//Prüfen, ob Element bereits in der Menge
		Pos<T> pos = find(element.getKey());

		if (pos.isValid()) {
			return find(element.getKey());
		}

		// Verlängere Array falls nötig
		if (size >= elements.length) {
			enlargeArray();
		}

		// Füge neues Element ein
		int i = size;
		elements[i] = element;
		size++;

		return new Pos<T>(true, element, size);
	}

	@Override
	public void delete(Pos<T> pos) {

		if (pos.isValid()) {

			// Überschreibe Element
			elements[pos.getIndex()] = null;
			pos.setValid(false);

			// Kopiere alte Elemente vor
			for (int i = pos.getIndex() + 1; i < size; i++) {
				elements[i - 1] = elements[i];
			}
			size--;
			elements[size] = null;

		}
	}

	@Override
	public void delete(Key key) {

		//Precondition
		if (key == null) {
			throw new NullPointerException();
		}
		//Löschen des Elements, wenn gefunden
		Pos<T> pos = find(key);
		if (pos.isValid()) {
			delete(pos);
		}

	}

	@Override
	public Pos<T> find(Key key) {

		//Precondition
		if (key == null) {
			throw new NullPointerException();
		}
		// Suche Element und gebe Position zurück falls gefunden
		for (int i = 0; i < size; i++) {
			if (elements[i].getKey().getValue().equals(key.getValue())) {
				return new Pos<T>(true, elements[i], i);
			}
		}
		return new Pos<T>(false,null,-1);
	}

	@Override
	public Element<T> retrieve(Pos<T> pos) {

		//Gibt Element an gewünschter Position zurück
		return pos.getReference();

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
		for (int i = 0; i < size(); i++) {
			set.add(elements[i]);
		}

		return set;
	}

}
