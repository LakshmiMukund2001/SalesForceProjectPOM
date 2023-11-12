package com.test.utilities;
import java.util.ArrayList;

public class BasicJavaUtils {
	public static ArrayList populateUserNameMenuArrayList() {
		 ArrayList<String> items = new ArrayList<String>();
		    items.add("My Profile");
		    items.add("My Settings");
		    items.add("Developer Console");
		    items.add("Switch to Lightning Experience");
		    items.add("Logout");
		    return items;
		
	}

}
