package personmain;

/**
 * @(#)PersonTester.java
 * Unit test for class Person
 * @author Jose Moreno
 * @version 1.00 2008/01/24
 */
public class PersonTester 
{
	//output messatges for tests
	private String msgPass;
	private String msgFail;
    //constructor of test class
    public PersonTester() 
    {
    	msgPass = new String("Test OK");
    	msgFail = new String("Test KO");
    }
	//funcions de test
	public void testChangeAge(Person pers, 
		int ageInputVal, int ageExpectedOutputVal ) throws InvalidValueException
	{
		alert("\nTest set/get property \"age\"");
		pers.setAge(ageInputVal);
		int ageOutputVal = pers.getAge();
		assertEquals(ageOutputVal, ageExpectedOutputVal);
	}	
	public void testChangeName(Person pers, 
		String nameInputVal, String nameExpectedOutputVal ) throws InvalidValueException, PropertyNotInitializedException
	{
		alert("\nTest set/get property \"name\"");
		pers.setName(nameInputVal);
		String nameOutputVal = new String(pers.getName());
		assertEquals(nameOutputVal, nameExpectedOutputVal);
	}
	public void testNameNotInit(Person pers) 
	{
		alert("\nTest get property \"name\" not initialized");
		try 
		{
			String nameOutputVal = new String(pers.getName());
		} catch (PropertyNotInitializedException pnie) 
		{
			alert(this.msgPass);
			return;
		}
		alert(this.msgFail);
	}
	public void ageNotValid(Person pers, int ageInputVal) 
	{
		alert("\nTest set property \"age\" not valid value");
		try 
		{
			pers.setAge(ageInputVal);
		} catch (InvalidValueException pvie) 
		{
			alert(this.msgPass);
			return;
		}
		alert(this.msgFail);
	}
	public void constructorWithInvalidParams(String nif, String name, int age) 
	{
		alert("\nTest constructor with invalid parameters");
		try 
		{
			Person p = new Person(nif, name, age);
		} catch (InvalidValueException pvie) 
		{
			alert(this.msgPass);
			return;
		}
		alert(this.msgFail);
	}
   //auxiliary methods 
    private void alert(String msg) 
    {
    	System.out.println(msg);
    }
    private void assertEquals(Object ObtainedValue, Object expectedValue) 
    {
    	if (ObtainedValue.equals(expectedValue))
    		alert(this.msgPass);
    	else
    		alert(this.msgFail);
    }
	//main function
    public static void main(String[] args) throws PropertyNotInitializedException, InvalidValueException
    {
        PersonTester tester = new PersonTester();
        //tests
        tester.testNameNotInit(new Person());
        tester.testChangeAge(new Person(), 15, 15);
        tester.testChangeName(new Person(), "Peter", "Peter");
        tester.ageNotValid(new Person(), -10);  
        tester.testChangeAge(new Person(), 23, 23);  
        tester.constructorWithInvalidParams("12345678Z", "Peter", -3);
        tester.constructorWithInvalidParams("12345678Z", null, 10); 
        tester.constructorWithInvalidParams(null, "Peter", 10); 
    }
}
