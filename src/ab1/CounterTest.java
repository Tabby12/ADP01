package ab1;

import com.sun.javafx.geom.AreaOp.AddOp;

class CounterTest<T> {

	private Key[] keys;
	private Pos[] pos;
	
	
	public CounterTest() {
		keys = null;
		pos = null;
	}
	
	
	public static void main(String[] args) {
		CounterTest ct = new CounterTest();
		
		//Test Set A  DeleteKey
		ct.testSetA(10,true);
		ct.testSetA(100,true);
		ct.testSetA(1000,true);
		ct.testSetA(10000,true);
		ct.testSetA(100000,true);
		
		//Test Set A  DeletePos
		ct.testSetA(10,false);
		ct.testSetA(100,false);
		ct.testSetA(1000,false);
		ct.testSetA(10000,false);
		ct.testSetA(100000,false);
		
		//Test Set B DeleteKey
		ct.testSetB(10,true);
		ct.testSetB(100,true);
		ct.testSetB(1000,true);
		ct.testSetB(10000,true);
		ct.testSetB(100000,true);
		
		//Test Set B DeletePos
		ct.testSetB(10,true);
		ct.testSetB(100,true);
		ct.testSetB(1000,true);
		ct.testSetB(10000,true);
		ct.testSetB(100000,true);
		
		//Test Set C  DeleteKey
		ct.testSetC(10,true);
		ct.testSetC(100,true);
		ct.testSetC(1000,true);
		ct.testSetC(10000,true);
		ct.testSetC(100000,true);
		
		//Test Set C  DeletePos
		ct.testSetC(10,true);
		ct.testSetC(100,true);
		ct.testSetC(1000,true);
		ct.testSetC(10000,true);
		ct.testSetC(100000,true);
		
		
	}
	
	public void testSetA(int size, boolean key) {
		keys = new Key[100000];
		pos = new Pos[100000];
		SetA<Integer> setABeginning = new SetA<Integer>();
		SetA<Integer> setAMiddle = new SetA<Integer>();
		SetA<Integer> setAEnd = new SetA<Integer>();
		add(size, setABeginning);
		System.out.println("success");
		add(size,setAMiddle);
		System.out.println("success");
		add(size,setAEnd);
		System.out.println("success");
		setABeginning.getCounter().reset();
		setAMiddle.getCounter().reset();
		setAEnd.getCounter().reset();
		
		if (key) {
			setABeginning.delete(keys[0]);
			System.out.println("deleteKeyBeginning - " + " - " + size  + " - " + setABeginning.getCounter().getCount());
			setAMiddle.delete(keys[(size-1)/2]);
			System.out.println("deleteKeyEiddle - " + " - " + size + " - " + setAMiddle.getCounter().getCount());
			setAEnd.delete(keys[size-1]);
			System.out.println("deleteKeyEnd - " + " - " + size + " - " + setAEnd.getCounter().getCount());
		}
		else {
			setABeginning.delete(pos[0]);
			System.out.println("deletePosBeginning - " + size + setABeginning.getCounter().getCount());
			setAMiddle.delete(pos[(size-1)/2]);
			System.out.println("deletePosMiddle - " + size + setAMiddle.getCounter().getCount());
			setAEnd.delete(pos[size-1]);
			System.out.println("deletePosEnd - " + size + setAEnd.getCounter().getCount());
		}
	}
	
	public void testSetB(int size, boolean key) {
		keys = new Key[100000];
		pos = new Pos[100000];
		SetB1<Integer> setBBeginning = new SetB1<Integer>();
		SetB1<Integer> setBMiddle = new SetB1<Integer>();
		SetB1<Integer> setBEnd = new SetB1<Integer>();
		add(size, setBBeginning);
		System.out.println("success");
		add(size,setBMiddle);
		System.out.println("success");
		add(size,setBEnd);
		System.out.println("success");
		setBBeginning.getCounter().reset();
		setBMiddle.getCounter().reset();
		setBEnd.getCounter().reset();
		
		if (key) {
			setBBeginning.delete(keys[0]);
			System.out.println("deleteKeyBeginning - " + " - " + size  + " - " + setBBeginning.getCounter().getCount());
			setBMiddle.delete(keys[(size-1)/2]);
			System.out.println("deleteKeyEiddle - " + " - " + size + " - " + setBMiddle.getCounter().getCount());
			setBEnd.delete(keys[size-1]);
			System.out.println("deleteKeyEnd - " + " - " + size + " - " + setBEnd.getCounter().getCount());
		}
		else {
			setBBeginning.delete(pos[0]);
			System.out.println("deletePosBeginning - " + size + setBBeginning.getCounter().getCount());
			setBMiddle.delete(pos[(size-1)/2]);
			System.out.println("deletePosMiddle - " + size + setBMiddle.getCounter().getCount());
			setBEnd.delete(pos[size-1]);
			System.out.println("deletePosEnd - " + size + setBEnd.getCounter().getCount());
		}
	}
	
	public void testSetC(int size, boolean key) {
		keys = new Key[100000];
		pos = new Pos[100000];
		SetC<Integer> setCBeginning = new SetC<Integer>();
		SetC<Integer> setCMiddle = new SetC<Integer>();
		SetC<Integer> setCEnd = new SetC<Integer>();
		add(size, setCBeginning);
		System.out.println("success");
		add(size,setCMiddle);
		System.out.println("success");
		add(size,setCEnd);
		System.out.println("success");
		setCBeginning.getCounter().reset();
		setCMiddle.getCounter().reset();
		setCEnd.getCounter().reset();
		
		if (key) {
			setCBeginning.delete(keys[0]);
			System.out.println("deleteKeyBeginning - " + " - " + size  + " - " + setCBeginning.getCounter().getCount());
			setCMiddle.delete(keys[(size-1)/2]);
			System.out.println("deleteKeyEiddle - " + " - " + size + " - " + setCMiddle.getCounter().getCount());
			setCEnd.delete(keys[size-1]);
			System.out.println("deleteKeyEnd - " + " - " + size + " - " + setCEnd.getCounter().getCount());
		}
		else {
			setCBeginning.delete(pos[0]);
			System.out.println("deletePosBeginning - " + size + setCBeginning.getCounter().getCount());
			setCMiddle.delete(pos[(size-1)/2]);
			System.out.println("deletePosMiddle - " + size + setCMiddle.getCounter().getCount());
			setCEnd.delete(pos[size-1]);
			System.out.println("deletePosEnd - " + size + setCEnd.getCounter().getCount());
		}
	}
	
	
	


	public void add(int amount, Set<Integer> set) {
		Element<Integer> elem = null;
		
		for(int i = 0; i<amount;i++) {
			elem = new Element<Integer>(new Integer(i));
			pos[i] = set.add((Element<Integer>)elem);
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
