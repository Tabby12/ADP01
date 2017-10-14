package ab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Testframe für Implemtationen des Interfaces "Set".
 * 
 * @author Helena Lajevardi
 */
public class SetTest {

	/**
	 * Instanz der zu testenden Menge.
	 */
	private Set<String> set = new SetB2<>();
	
	private Pos<String> pos0;
	private Pos<String> pos1;
	private Pos<String> pos2;
	@SuppressWarnings("unused")
	private Pos<String> pos3;
	private Pos<String> pos4;

	@Before
	public void setUp() throws Exception {
		pos0 = set.add(new Element<String>("Douglas Adams"));
		pos1 = set.add(new Element<String>("Hitchhiker"));
		pos2 = set.add(new Element<String>("Marvin"));
		pos3 = set.add(new Element<String>("BTI3-ADP"));
		pos4 = set.add(new Element<String>("HAW-Hamburg"));
	}

	/**
	 * Teste das einfügen und ausgeben
	 */
	@Test
	public void testAddRetrieve() {
		// Einfügen am Anfang
		Pos<String> pos = set.add(new Element<String>("Anfang"));
		assertEquals(set.size(), 6);
		assertEquals(set.retrieve(pos).getData(), "Anfang");
	}

	/**
	 * Testet das Entfernen von Elementen aus der Menge
	 */
	@Test
	public void testDelete() {
		// Entfernen am Anfang
		set.delete(pos0);
		assertEquals(set.size(), 4);
		assertEquals(set.retrieve(pos0).getData(), "Hitchhiker");

		// Entfernen in der Mitte
		set.delete(pos2);
		assertEquals(set.size(), 3);
		assertEquals(set.retrieve(pos2).getData(), "HAW-Hamburg");

		// Entfernen am Ende
		set.delete(pos2);
		assertEquals(set.size(), 2);
		assertEquals(set.retrieve(pos1).getData(), "Marvin");
	}

	/**
	 * Testet alle Operationen die einen {@code Key} verwenden
	 */
	@Test
	public void testKeyOperations() {
		// Finde Element anhand von Key
		assertEquals(set.find(set.retrieve(pos1).getKey()).getIndex(), 1);
		assertEquals(set.find(set.retrieve(pos0).getKey()).getIndex(), 0);
		assertEquals(set.find(new Key()).getIndex(), -1);

		// Teste Löschen anhand von Key
		set.delete(set.retrieve(pos0).getKey());
		assertEquals(set.retrieve(pos0).getData(), "Hitchhiker");
	}

	/**
	 * Testet das vereinigen von zwei Mengen
	 */
	@Test
	public void testUnify() {
		// Erzeuge neue Menge und fülle mit Inhalt
		Set<String> secondSet = new SetC<>();
		Pos<String> pos5 = secondSet.add(new Element<String>("2: A"));
		Pos<String> pos6 = secondSet.add(new Element<String>("2: B"));

		// Vereinige Mengen und überprüfe Ergebnis
		Set<String> unifiedSet = set.unify(secondSet);

		assertEquals(unifiedSet.size(), 7);
		assertEquals(set.retrieve(pos0).getData(), "Douglas Adams");
		assertEquals(set.retrieve(pos4).getData(), "HAW-Hamburg");
		assertEquals(set.retrieve(pos5).getData(), "2: A");
		assertEquals(set.retrieve(pos6).getData(), "2: B");
	}

	/**
	 * Teste Preconditions für add
	 */
	@Test(expected = NullPointerException.class)
	public void testPreconditionInsertElementNull() {
		set.add(null);
	}

	/**
	 * Teste Preconditions für delete
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreconditionDeletePosNegativ() {
		set.delete(new Pos<String>(true, null, -1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreconditionDeleteTooLarge() {
		set.delete(new Pos<String>(true, null, 9000));
	}

	@Test(expected = NullPointerException.class)
	public void testPreconditionDeleteNull() {
		Key key = null;
		set.delete(key);
	}

	/**
	 * Teste Preconditions für find
	 */
	@Test(expected = NullPointerException.class)
	public void testPreconditionFindNull() {
		set.find(null);
	}

	/**
	 * Teste Preconditions für concat
	 */
	@Test(expected = NullPointerException.class)
	public void testPreconditionConcatNull() {
		set.unify(null);
	}

}
