package aufgabe1a;

public interface Set {

	Pos add(Elem<?> elem);

	void delete(Pos pos);

	void deleteKey(int key);

	Pos find(int key);

	Elem<?> retrieve(Pos pos);

	void showall();

	int size();
	
	boolean contains(Elem<?> elem);

	Set unify(Set s);
}
