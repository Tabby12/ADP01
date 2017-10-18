package ab1;


class CounterTest<T> {

	
	private Key[] keys;
	private Pos[] pos;

	
 	
	public CounterTest() {
		keys = new Key[100000];
		pos = new Pos[100000];
	}
	
	public static void main(String[] args) {
		//testSetA();
		testSetB();
		
	}
	
	public static void testSetA() {
		CounterTest ct = new CounterTest();
		SetA<Integer> setA = new SetA<Integer>();
		SetB1<Integer> setB1 = new SetB1<Integer>();
		SetC<Integer> setC = new SetC<Integer>();
 		
		ct.add(10, setA);
		ct.deleteKey(10, setA);
		System.out.println("deleteKey 10      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(10, setA);
		ct.deletePos(10, setA);
		System.out.println("deletePos 10      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(100, setA);
		ct.deleteKey(100, setA);
		System.out.println("deleteKey 100      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(100, setA);
		ct.deletePos(100, setA);
		System.out.println("deletePos 100      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(1000, setA);
		ct.deleteKey(1000, setA);
		System.out.println("deleteKey 1000      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(1000, setA);
		ct.deletePos(1000, setA);
		System.out.println("deletePos 1000      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(10000, setA);
		ct.deleteKey(10000, setA);
		System.out.println("deleteKey 10000      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(10000, setA);
		ct.deletePos(10000, setA);
		System.out.println("deletePos 10000      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(100000, setA);
		ct.deleteKey(100000, setA);
		System.out.println("deleteKey 100000      " + setA.getCounter().getCount());
		
		setA = new SetA<Integer>();
		ct.add(100000, setA);
		ct.deletePos(100000, setA);
		System.out.println("deletePos 100000      " + setA.getCounter().getCount());
		
		
		
		
		
		
		
		
		
		
		
		setC = new SetC<Integer>();
		ct.add(10, setC);
		ct.deletePos(10, setC);
		System.out.println("deletePos 10      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(100, setC);
		ct.deleteKey(100, setC);
		System.out.println("deleteKey 100      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(100, setC);
		ct.deletePos(100, setC);
		System.out.println("deletePos 100      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(1000, setC);
		ct.deleteKey(1000, setC);
		System.out.println("deleteKey 1000      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(1000, setC);
		ct.deletePos(1000, setC);
		System.out.println("deletePos 1000      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(10000, setC);
		ct.deleteKey(10000, setC);
		System.out.println("deleteKey 10000      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(10000, setC);
		ct.deletePos(10000, setC);
		System.out.println("deletePos 10000      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(100000, setC);
		ct.deleteKey(100000, setC);
		System.out.println("deleteKey 100000      " + setC.getCounter().getCount());
		
		setC = new SetC<Integer>();
		ct.add(100000, setC);
		ct.deletePos(1000, setC);
		System.out.println("deletePos 100000      " + setC.getCounter().getCount());
		
	}
	
	public static void testSetB() {
		CounterTest ct = new CounterTest();
		SetB1<Integer> setB1 = new SetB1<Integer>();
		
		setB1 = new SetB1<Integer>();
		ct.add(10, setB1);
		ct.deletePos(10, setB1);
		System.out.println("deletePos 10      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(100, setB1);
		ct.deleteKey(100, setB1);
		System.out.println("deleteKey 100      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(100, setB1);
		ct.deletePos(100, setB1);
		System.out.println("deletePos 100      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(1000, setB1);
		ct.deleteKey(1000, setB1);
		System.out.println("deleteKey 1000      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(1000, setB1);
		ct.deletePos(1000, setB1);
		System.out.println("deletePos 1000      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(10000, setB1);
		ct.deleteKey(10000, setB1);
		System.out.println("deleteKey 10000      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(10000, setB1);
		ct.deletePos(10000, setB1);
		System.out.println("deletePos 10000      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(100000, setB1);
		ct.deleteKey(100000, setB1);
		System.out.println("deleteKey 100000      " + setB1.getCounter().getCount());
		
		setB1 = new SetB1<Integer>();
		ct.add(100000, setB1);
		ct.deletePos(1000, setB1);
		System.out.println("deletePos 100000      " + setB1.getCounter().getCount());
	}
	


	public void add(int amount, Set<T> set) {
		Element elem = null;
		
		for(int i = 0; i<amount;i++) {
			elem = new Element<Integer>(new Integer(i));
			pos[i] = set.add((Element<T>)elem);
			keys[i] = elem.getKey();
		}
	}
	
	public void deleteKey(int amount, Set<T> set) {
		for(int i = 0; i<amount;i++) {
			set.delete(keys[i]);
		}
	}
	
	public void deletePos(int amount, Set<T> set) {
		for(int i = 0; i<amount;i++) {
			set.delete(pos[i]);
		}
	}
	
}
