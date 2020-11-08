package personmain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** PersonMain.java
 * Test for Person class with exceptions
 * @author Jose Moreno
 */

public class PersonMain {
	
	public static void main (String args[]) throws SalariInvalidException, PropertyNotInitializedException, DepartamentInvalidException {
		try {
                    
                        Person d = new Person("45788201P", "Caracaca", 12);
                        Person a = new Person("12345678Z", "Peter", 20);
			Person b = new Person();
			System.out.println("Person a: "+a.toString());
			System.out.println("Person b: "+b.toString());
			//Attempt to read name
			System.out.println("Name of a: "+a.getName());
			//System.out.println("Name of b: "+b.getName());
			//Attempt to read nif
			System.out.println("NIF of a: "+a.getNif());
			//System.out.println("NIF of b: "+b.getNif());
			//Attempt to write age
			a.setAge(21);
			System.out.println("Age of a: "+a.getAge());
			//b.setAge(-2);
			System.out.println("Age of b: "+b.getAge());
			//Attempt to create new Person
			Person c = new Person("45788201P", "John", 10);

			System.out.println("Person c: "+c.toString());
                        System.out.println("Person d: "+d.toString());
                        
                        
                        Empleat e = new Empleat(1111.223, "caca", "Informatica", 1902, d);
                        Empleat ne = new Empleat();
                        //System.out.println(ne.getDepartament());
                        System.out.println(e.getSalari());
                        System.out.println(e.getDepartament());
                        
		} catch (InvalidValueException ive) {
			System.out.println(ive.getMessage());			
		} catch (PropertyNotInitializedException pnie) {
			System.out.println(pnie.getMessage());			
		} catch(SalariInvalidException e){
                    System.out.println(e.getMessage());
                } catch(DepartamentInvalidException e){
                    System.out.println(e.getMessage());
                }
                
                
	}
}

