package AB1;

/**
 * Das Interface für eine Menge.
 *
 * @param <T> Elementtyp der Menge
 * 
 * @author Helena Lajevardi
 */
public interface Set<T> {

	/**
	 * Fügt der Menge ein Element hinzu.
	 * 
	 * @param element das Element, dass hinzugefügt werden soll
	 * 
	 * @throws NullPointerException if {@code element == null}
	 * 
	 * @return die Position an der das Element hinzugefügt wurde.
	 */
	Pos add(Element<T> element);

	/**
	 * Löscht an der Position ein Element aus der Menge.
	 * 
	 * @param pos die Position an der das Element gelöscht werden soll
	 * 
	 * @throws IndexOutOfBoundsException if {@code pos < 0}
	 * @throws IndexOutOfBoundsException if {@code pos >} Listengröße
	 * 
	 */
	void delete(Pos pos);

	/**
	 * Löscht anhand eines Schlüssels ein Element aus der Menge.
	 * 
	 * @param key der Schlüssel des zu löschenden Elements.
	 * 
	 * @throws NullPointerException if {@code key == null}
	 * 
	 */
	void delete(Key key);

	/**
	 * Findet ein Element aus der Menge und gibt die Positon zurück.
	 * 
	 * @param key der Schlüssel mit dem die Position gefunden werden soll
	 * 
	 * @throws NullPointerException if {@code key == null}
	 * 
	 * @return die Position des gesuchten Elements.
	 */
	Pos find(Key key);

	/**
	 * Liefert ein Element aus der Menge zurück.
	 * 
	 * @param pos die Position des Elements, dass zurück geliefert werden soll
	 * 
	 * @throws IndexOutOfBoundsException if {@code pos < 0}
	 * @throws IndexOutOfBoundsException if {@code pos >} Listengröße
	 * 
	 * @return das Element, dass zurückgeliefert wird.
	 */
	Element<T> retrieve(Pos pos);

	/**
	 * Zeigt alle Elemente der Menge an.
	 */
	void showall();

	/**
	 * Gibt die aktuelle Größe der Menge zurück.
	 * 
	 * @return Anzahl der Elemente in der Menge
	 */
	int size();

	/**
	 * Verbindet zwei Mengen miteinander.
	 * 
	 * @param set die Menge mit der vereinigt werden soll
	 * 
	 * @throws NullPointerException if {@code set == null}
	 * 
	 * @return die neue Menge.
	 */
	Set<T> unify(Set<T> set);

}
