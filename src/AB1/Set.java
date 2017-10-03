package AB1;
/**
 * Das Interface f�r eine Menge.
 *
 * @param <Element> Elementtyp der Menge
 * 
 * @author Helena Lajevardi
 */
public interface Set<Element> {
	
	/**
	 * F�gt der Menge ein Element hinzu.
	 * 
	 * @param element das Element, dass hinzugef�gt werden soll.
	 * 
	 * @return die Position an der das Element hinzugef�gt wurde.
	 */
	int add(Element element);
	
	/**
	 * L�scht an der Position ein Element aus der Menge.
	 * 
	 * @param pos die Position an der das Element gel�scht werden soll.
	 */
	void delete(int pos);
	
	/**
	 * L�scht anhand eines Schl�ssels ein Element aus der Menge.
	 * 
	 * @param key der Schl�ssel des zu l�schenden Elements.
	 */
	void delete(Key key);
	
	/**
	 * Findet ein Element aus der Menge und gibt die Positon zur�ck.
	 * 
	 * @param key der Schl�ssel mit dem die Position gefunden werden soll.
	 * 
	 * @return die Position des gesuchten Elements.
	 */
	int find(Key key);
	
	/**
	 * Liefert ein Element aus der Menge zur�ck.
	 * 
	 * @param pos die Position des Elements, dass zur�ck geliefert werden soll.
	 * 
	 * @return das Element, dass zur�ckgeliefert wird.
	 */
	Element retrieve(int pos);
	
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
	 * @param set die Menge mit der vereinigt werden soll.
	 * 
	 * return die neue Menge.
	 */
	Set<Element> unify(Set<Element> set);
	

}

