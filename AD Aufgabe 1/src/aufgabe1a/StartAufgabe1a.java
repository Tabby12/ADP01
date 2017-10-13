package aufgabe1a;

public class StartAufgabe1a 
{
	public static <T> void main(String[] args) 
	{
		ArraySet arrSet = new ArraySet();
		ArraySet arrSet2= new ArraySet();
		
		Elem<String> elemStringArr21 = new Elem<String>("Ömer");
		Elem<String> elemStringArr22 = new Elem<String>("Paul");
		Elem<String> elemStringArr23 = new Elem<String>("Vado");
		Elem<Integer> elemIntArr2 = new Elem<Integer>(Integer.valueOf(123));
		
		arrSet2.add(elemStringArr21);
		arrSet2.add(elemStringArr22);
		arrSet2.add(elemStringArr23);
		arrSet2.add(elemIntArr2);
		
		Elem<String> elemString = new Elem<String>("TK");
		Elem<Integer> elemInt = new Elem<Integer>(Integer.valueOf(123));
		Elem<String> elemString2 = new Elem<String>("AH");
		
		arrSet.add(elemString);
		arrSet.add(elemInt);
		arrSet.add(elemString2);
		arrSet.add(elemStringArr21);
		
		
		
		arrSet.showall();
		System.out.println();
		arrSet.showall();
		System.out.println(arrSet.contains(elemString2));
		System.out.println(arrSet.find(elemString.getKey()));
		arrSet.showall();
		System.out.println(arrSet.retrieve(new Pos(elemString, arrSet, true)).toString());
		System.out.println();
		arrSet.showall();
		System.out.println();
		arrSet2.showall();
		System.out.println();
		arrSet.unify(arrSet2).showall();
	}
}
