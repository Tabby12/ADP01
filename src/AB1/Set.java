package AB1;
/**
 * Das Interface für eine Menge.
 *
 * @param <Element> Elementtyp der Menge
 * 
 * @author Helena Lajevardi
 */
public interface Set<Element> {
	
	/**
	 * Fügt der Menge ein Element hinzu.
	 * 
	 * @param element das Element, dass hinzugefügt werden soll.
	 * 
	 * @return die Position an der das Element hinzugefügt wurde.
	 */
	int add(Element element);
	
	/**
	 * Löscht an der Position ein Element aus der Menge.
	 * 
	 * @param pos die Position an der das Element gelöscht werden soll.
	 */
	void delete(int pos);
	
	/**
	 * Löscht anhand eines Schlüssels ein Element aus der Menge.
	 * 
	 * @param key der Schlüssel des zu löschenden Elements.
	 */
	void delete(Key key);
	
	/**
	 * Findet ein Element aus der Menge und gibt die Positon zurück.
	 * 
	 * @param key der Schlüssel mit dem die Position gefunden werden soll.
	 * 
	 * @return die Position des gesuchten Elements.
	 */
	int find(Key key);
	
	/**
	 * Liefert ein Element aus der Menge zurück.
	 * 
	 * @param pos die Position des Elements, dass zurück geliefert werden soll.
	 * 
	 * @return das Element, dass zurückgeliefert wird.
	 */
	Element retrieve(int pos);
	
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
	 * @param set die Menge mit der vereinigt werden soll.
	 * 
	 * return die neue Menge.
	 */
	Set<Element> unify(Set<Element> set);
	

}

