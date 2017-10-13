package aufgabe1b;

import aufgabe1a.Elem;
import aufgabe1a.Pos;

public class StartAufgabe1b
{
	public static void main(String[] args)
	{
		ArraySet2 arr = new ArraySet2();
		ArraySet2 arr2 = new ArraySet2();
		
		Elem<String> elemStringArr1 = new Elem<String>("Ömer");
		Elem<String> elemStringArr12 = new Elem<String>("Paul");
		Elem<String> elemStringArr13 = new Elem<String>("Vado");
		Elem<Integer> elemIntArr14 = new Elem<Integer>(Integer.valueOf(123));
		
		arr.add(elemStringArr1);
		arr.add(elemStringArr12);
		arr.add(elemStringArr13);
		arr.add(elemIntArr14);
		
		Elem<String> elemString2 = new Elem<String>("TK");
		Elem<Integer> elemInt21 = new Elem<Integer>(Integer.valueOf(123));
		Elem<String> elemString22 = new Elem<String>("AH");
		
		arr2.add(elemString2);
		arr2.add(elemInt21);
		arr2.add(elemString22);
		
		ArraySet2 arrSetUnified = (ArraySet2) arr.unify(arr2);
		arrSetUnified.showall();
		
		System.out.println();
		System.out.println(arr.contains(elemStringArr1));
		System.out.println(arr.contains(elemString2));
		System.out.println();
		
		arr.showall();
		arr.delete(new Pos(elemStringArr12, arr, true)); // elem an stelle 2
		System.out.println();
		arr.showall();
		System.out.println();
		arr.delete(new Pos(elemStringArr13, arr, false)); // elem an stelle 3
		arr.showall();
//		arr.delete(4);
		System.out.println();
//		arr.delete(4);
		arr.showall();
		System.out.println();
		arr.add(elemStringArr12);
		arr.showall();
		System.out.println();
		
		System.out.println(arr.find(elemStringArr12.getKey()));
		System.out.println();
//		System.out.println(arr.retrieve(1));
//		System.out.println(arr.retrieve(-199));
//		System.out.println(arr.retrieve(4));
//		System.out.println(arr.retrieve(5));
		System.out.println();
		System.out.println(arr.size());
		
		
	}
}
