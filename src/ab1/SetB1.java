package ab1;

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
	private int idx;

	/**
	 * Array zur Datenspeicherung
	 */
	private Node1<T>[] nodes;

	/**
	 * Konstruktor.
	 */
	@SuppressWarnings("unchecked")
	public SetB1() {
		nodes = (Node1<T>[]) Array.newInstance(Node1.class, 10);
		idx = 1;
		size = 0;
		nodes[0] = new Node1<T>(null);	
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
	public Pos<T> add(Element<T> element) {

		if (element == null) {
			throw new NullPointerException();
		}

		Pos<T> pos = find(element.getKey());

		if (pos.isValid()) {
			return pos; //return new Pos<T>(false, null, -1); 
		}
		int index = idx;
		
		if(index + 1 >=  nodes.length){
			enlargeArray();
		}

//		if (index >= nodes.length) {
//			enlargeArray();
//		}
		int determinePrev = idx;
		nodes[index] = new Node1<T>(element);
		nodes[index].setNext(index+1);
		do {
			determinePrev--;
		} while(nodes[determinePrev] == null);

		nodes[index].setPrevious(determinePrev); //????
		size++;
		idx++;

		return new Pos<T> (true, element,index);  //return pos;
	}

	@Override
	public void delete(Pos<T> pos) {

		if (pos.getIndex() < 0 || pos.getIndex() > nodes.length) {
			throw new IndexOutOfBoundsException();
		}
		
		if(nodes[pos.getIndex()] != null) {
			int next = nodes[pos.getIndex()].getNext();
			int prev = nodes[pos.getIndex()].getPrevious();
			if(nodes[next] != null) {
				nodes[next].setPrevious(prev);
			}	
			if(nodes[prev] != null) {
				nodes[prev].setNext(next);
			}
			nodes[pos.getIndex()] = null;
			pos.setValid(false);
			size--;
		}	

//		nodes[pos.getIndex()] = null;

//		for (int i = pos.getIndex() + 1; i < size; i++) {
//			nodes[i - 1] = nodes[i];
//		}
//		size--;

	}

	@Override
	public void delete(Key key) {

		if (key == null) {
			throw new NullPointerException();
		}

		Pos<T> pos = find(key);
		if (pos.isValid()) {
			delete(pos);
		}

	}

	@Override
	public Pos<T> find(Key key) {

		if (key == null) {
			throw new NullPointerException();
		}

		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i] != null && nodes[i].getElement().getKey().getValue().equals(key.getValue())) {
				return new Pos<T>(true, nodes[i].getElement(), i);
			}
		}
		return new Pos<T>(false, null, -1);
	}

	@Override
	public Element<T> retrieve(Pos<T> pos) {
		return pos.getReference();
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
		
		for (int i = 0; i <size(); i++) {
			set.add(nodes[i].getElement());
		}

		return set;
	}

}
