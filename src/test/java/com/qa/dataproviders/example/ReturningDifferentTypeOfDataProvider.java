package com.qa.dataproviders.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReturningDifferentTypeOfDataProvider {

	/*
	 * Different Return Types of DataProvider 
	 * 1. Object[][] - 2D Array 
	 * 
	 * 2. Object[] - One Dimensional Array
	 * 
	 * 3. 	Iterator<Object> - refers to an iterator that iterates over
	 * 		a collection of objects. An iterator is an interface in Java that allows you
	 * 		to iterate (or loop) through a collection of elements, such as arrays or
	 * 		lists. So, Iterator<Object> specifically refers to an iterator that works
	 * 		with objects of any type. When you declare a variable or a method return type
	 * 		as Iterator<Object>, you're indicating that the iterator will iterate over a
	 * 		collection of objects, but you don't specify the exact type of objects it
	 * 		will contain. Iterator<Object[]>
	 * 
	 * 4. 	Iterator<Object[]> - Lets BreakDown This
	 *    	Object[] is an array of objects in Java. It means that each element in the array can hold any object, regardless of its type.
	 *  	An iterator is an interface in Java that allows you to iterate through a collection of elements.
	 *  
	 *  	When you combine these two concepts as Iterator<Object[]>, you're indicating that the iterator will iterate over a collection of arrays, 
	 *  	where each array contains objects. In other words, each element that the iterator returns will be an array of objects (Object[]), 
	 *  	and you can access individual objects within each array.
	 */

	@Test(priority = 1,dataProvider = "objectData1")
	public void testData(String a, String b) {

		System.out.println(a + " - " + b);

	}
    
	/*
	 * Test will run 3 times, since 3 set of data
	 */
	@DataProvider(name = "objectData1")
	public Object[][] dataSupplierOne() {

		Object[][] data = { { "Biscuits", "Chocolate" }, { "Cookies", "Choco Chips" }, { "Drink", "Sprite" } };
		return data;

	}
	
/*--------------------------------------------------------------------------------------------------------------------------------- */	
	
	@Test(priority = 2, dataProvider = "objectDataTwo")
	public void testDataTwo(String a) {

		System.out.println(a);

	}
    
	/*
	 * Test will run 5 times, since 5 set of data
	 */
	@DataProvider(name = "objectDataTwo")
	public Object[] dataSupplierTwo() {

		Object[]data = { "Biscuits", "Cookies", "Choco Chips", "Drink" };
		return data;

	}
	
/*--------------------------------------------------------------------------------------------------------------------------------------- */	
	@Test(priority = 3, dataProvider = "objectDataThree")
	public void testDataThree(Object a) {
		System.out.println(a);
	}
    
	/*
	 * Test will run 4 times, since 4 set of data.
	 */
	@DataProvider(name = "objectDataThree")
	public Iterator<Object> dataSupplierThree() {

		List<Object> list = new ArrayList<>();
		list.add("Test");
		list.add(9);
		list.add(true);
		list.add("Mumbai");
		return list.iterator();
		
		/*
		 * We cannot return List we need to return iterator of object Iterator<Object>
		*/

	}

/*------------------------------------------------------------------------------------------------------------------------------------ */	
	
	
	@Test(priority = 4, dataProvider = "objectDataFour")
	public void testDataFour(Object a, Object b, Object c, Object d) {
		System.out.println(a +" - " + b + "- " + c + " - " + d);
	}
    
	/*
	 * Test will run 4 times, since 4 set of data.
	 */
	@DataProvider(name = "objectDataFour")
	public Iterator<Object[]> dataSupplierFour() {

		List<Object[]> list = new ArrayList<>();
		list.add(new Object [] {"Test" , "English", "29", "c"});
		list.add(new Object [] {"Test" , "Maths", "49", "A"});
		list.add(new Object [] {"Test" , "Physics", "45", "A"});
		list.add(new Object [] {"Test" , "Geography", "35", "B"});
		return list.iterator();
	

	}

}
