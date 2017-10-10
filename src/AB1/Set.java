package AB1;

/**
 * Das Interface f�r eine Menge.
 *
 * @param <T> Elementtyp der Menge
 * 
 * @author Helena Lajevardi
 */
public interface Set<T> {

	/**
	 * F�gt der Menge ein Element hinzu.
	 * 
	 * @param element das Element, dass hinzugef�gt werden soll
	 * 
	 * @throws NullPointerException if {@code element == null}
	 * 
	 * @return die Position an der das Element hinzugef�gt wurde.
	 */
	Pos add(Element<T> element);

	/**
	 * L�scht an der Position ein Element aus der Menge.
	 * 
	 * @param pos die Position an der das Element gel�scht werden soll
	 * 
	 * @throws IndexOutOfBoundsException if {@code pos < 0}
	 * @throws IndexOutOfBoundsException if {@code pos >} Listengr��e
	 * 
	 */
	void delete(Pos pos);

	/**
	 * L�scht anhand eines Schl�ssels ein Element aus der Menge.
	 * 
	 * @param key der Schl�ssel des zu l�schenden Elements.
	 * 
	 * @throws NullPointerException if {@code key == null}
	 * 
	 */
	void delete(Key key);

	/**
	 * Findet ein Element aus der Menge und gibt die Positon zur�ck.
	 * 
	 * @param key der Schl�ssel mit dem die Position gefunden werden soll
	 * 
	 * @throws NullPointerException if {@code key == null}
	 * 
	 * @return die Position des gesuchten Elements.
	 */
	Pos find(Key key);

	/**
	 * Liefert ein Element aus der Menge zur�ck.
	 * 
	 * @param pos die Position des Elements, dass zur�ck geliefert werden soll
	 * 
	 * @throws IndexOutOfBoundsException if {@code pos < 0}
	 * @throws IndexOutOfBoundsException if {@code pos >} Listengr��e
	 * 
	 * @return das Element, dass zur�ckgeliefert wird.
	 */
	Element<T> retrieve(Pos pos);

	/**
	 * Zeigt alle Elemente der Menge an.
	 */
	void showall();

	/**
	 * Gibt die aktuelle Gr��e der Menge zur�ck.
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
