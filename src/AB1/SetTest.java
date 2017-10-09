package AB1;

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
	private Set<String> set = new SetC<>();

	@Before
	public void setUp() throws Exception {
		set.add(new Element<String>("Douglas Adams"));
		set.add(new Element<String>("Hitchhiker"));
		set.add(new Element<String>("Marvin"));
		set.add(new Element<String>("BTI3-ADP"));
		set.add(new Element<String>("HAW-Hamburg"));
	}

	/**
	 * Teste das einfügen und ausgeben
	 */
	@Test
	public void testAddRetrieve() {
		// Einfügen am Anfang
		set.add(new Element<String>("Anfang"));
		assertEquals(set.size(), 6);
		assertEquals(set.retrieve(5).getData(), "Anfang");
	}

	/**
	 * Testet das Entfernen von Elementen aus der Menge
	 */
	@Test
	public void testDelete() {
		// Entfernen am Anfang
		set.delete(0);
		assertEquals(set.size(), 4);
		assertEquals(set.retrieve(0).getData(), "Hitchhiker");

		// Entfernen in der Mitte
		set.delete(2);
		assertEquals(set.size(), 3);
		assertEquals(set.retrieve(2).getData(), "HAW-Hamburg");

		// Entfernen am Ende
		set.delete(2);
		assertEquals(set.size(), 2);
		assertEquals(set.retrieve(1).getData(), "Marvin");
	}

	/**
	 * Testet alle Operationen die einen {@code Key} verwenden
	 */
	@Test
	public void testKeyOperations() {
		// Finde Element anhand von Key
		assertEquals(set.find(set.retrieve(1).getKey()), 1);
		assertEquals(set.find(set.retrieve(0).getKey()), 0);
		assertEquals(set.find(new Key()), -1);

		// Teste Löschen anhand von Key
		set.delete(set.retrieve(0).getKey());
		assertEquals(set.retrieve(0).getData(), "Hitchhiker");
	}

	/**
	 * Testet das vereinigen von zwei Mengen
	 */
	@Test
	public void testUnify() {
		// Erzeuge neue Menge und fülle mit Inhalt
		Set<String> secondSet = new SetC<>();
		secondSet.add(new Element<String>("2: A"));
		secondSet.add(new Element<String>("2: B"));

		// Vereinige Mengen und überprüfe Ergebnis
		Set<String> unifiedSet = set.unify(secondSet);

		assertEquals(unifiedSet.size(), 7);
		assertEquals(set.retrieve(0).getData(), "Douglas Adams");
		assertEquals(set.retrieve(4).getData(), "HAW-Hamburg");
		assertEquals(set.retrieve(5).getData(), "2: A");
		assertEquals(set.retrieve(6).getData(), "2: B");
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
		set.delete(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreconditionDeleteTooLarge() {
		set.delete(9000);
	}

	@Test(expected = NullPointerException.class)
	public void testPreconditionDeleteNull() {
		set.delete(null);
	}

	/**
	 * Teste Preconditions für find
	 */
	@Test(expected = NullPointerException.class)
	public void testPreconditionFindNull() {
		set.find(null);
	}

	/**
	 * Teste Preconditions für retrieve
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreconditionRetrievePosNegativ() {
		set.retrieve(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreconditionRetrieveTooLarge() {
		set.retrieve(9000);
	}

	/**
	 * Teste Preconditions für concat
	 */
	@Test(expected = NullPointerException.class)
	public void testPreconditionConcatNull() {
		set.unify(null);
	}

}
