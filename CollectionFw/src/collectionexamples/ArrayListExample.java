package collectionexamples;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		
		//Allows Null values 
		//Allows Duplicate Values
		//maintain the Insertion order and get the same order when we read/fetch the values
		
		ArrayList<String> state = new ArrayList<String>();
		state.add("Maharastra");
		state.add("Telengana");
		state.add("Delhi");
		state.add("Delhi");
		state.add("MP");
		state.add(null);
		state.add(null);
		state.add("Maharastra");
		state.add("Telengana");
		state.add("Delhi");
		state.add("Delhi");
		state.add("MP");
		state.add(null);
		state.add(null);
		state.add("Maharastra");
		state.add("Telengana");
		state.add("Delhi");
		state.add("Delhi");
		state.add("MP");
		state.add(null);
		state.add(null);
		System.out.println(state);
		
	}

}
