package personmain;

import static java.lang.Integer.parseInt;

/**
 * Person.java
 * TAD Person
 * @author Jose
 * @version 
 */
 public class Person {
	/* fields, attributes, properties */
	private String nif;
	private String name;
	private int age;
	/* constructors */
	/** Person()
	 * full initializer constructor
	 * @param String nif: the nif id of this person
	 * @param String name: the name of this person
	 * @param int age: the age of this person
	 * @throws InvalidValueException if a value for a property is not valid
	 * @return nothing
	 */
	public Person(String nif, String name, int age) throws InvalidValueException {
		setNif(nif);
		setName(name);
		setAge(age); 
	}
	/** Person()
	 * constructor without any initialization (default constructor)
	 * @param none
	 * @return nothing
	 */
	public Person() {
	}
	/** Person()
	 * copy constructor
	 * @param Person p: person to copy from
	 * @return nothing
	 */
	public Person(Person p) {
		nif = p.nif;
		name = p.name;
		age = p.age; 
	}
	/* accessors */
	/** getNif()
	 * @param none
	 * @throws PropertyNotInitializedException if property is not initialized
	 * @throws InvalidValueException if property value is not valid
	 * @return nif
	 */
	public String getNif() 
		throws PropertyNotInitializedException, InvalidValueException {
		if (nif==null) throw new PropertyNotInitializedException("the \"nif\" is not set");
		if (!isNifValid()) throw new InvalidValueException("Property \"nif\" has not a valid value");
		return nif;
	}
	/** setNif()
	 * @param String nif: the nif to set
	 * @throws InvalidValueException if parameter value is not valid for property 'nif'
	 * @return nothing
	 */
	public void setNif(String nif) throws InvalidValueException {
		if (!isAValidNif(nif)) throw new InvalidValueException("invalid value for property \"nif\"");
		this.nif = nif;
	}
	/** getName()
	 * @param none
	 * @throws PropertyNotInitializedException if property is not initialized
	 * @return name
	 */
	public String getName() throws PropertyNotInitializedException {
		if (name==null) throw new PropertyNotInitializedException("the \"name\" is not set");
		return name;
	}
	/** setName()
	 * @param String name: the name to set
	 * @throws InvalidValueException if parameter value is not valid for property 'name'
	 * @return nothing
	 */
	public void setName(String name) throws InvalidValueException {
		if (name==null) throw new InvalidValueException("invalid value for property \"name\"");
		this.name = name;
	}
	/** getAge()
	 * @param none
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/** setAge()
	 * @param int age: the age to set
	 * @throws InvalidValueException if value is not valid
	 * @return nothing
	 */
	public void setAge(int age) throws InvalidValueException {
		if ( age >= 0 ) this.age = age;
		else throw new InvalidValueException("invalid value for property \"age\"");
	}
	/* methods */
	/** isNifValid()
	 * checks if property 'nif' has a valid value
	 * @param none
	 * @return true if nif is valid, false otherwise
	 */
	public boolean isNifValid() {
		boolean flag = true;
                if(!isAValidNif(this.nif)){
                    flag = false;
                }
		return flag;
	}
	/** isAValidNif()
	 * checks if parameter 'nif' has a valid value for property 'nif'
	 * @param String nif: the nif value to check
	 * @return true if value is valid for a nif, false otherwise
	 */
	public static boolean isAValidNif(String nif){
		boolean flag = true; 
                String caracteres[] = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
                
                if(nif.length() == 9){
                    String letra = nif.substring(8).toUpperCase();
                    Integer numeros = parseInt(nif.substring(0, 8));
                    Integer resto = 0;
                    resto = numeros % 23;
                    if(!letra.equals(caracteres[resto])){
                       flag = false; 
                    }
                }else{
                    flag = false;
                }
		return flag;
	}	
	/** toString()
	 * gives a String representations of this person
	 * @param none
	 * @return a string representation of this person
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{Person: nif=");
		sb.append(nif);
		sb.append(";name=");
		sb.append(name);
		sb.append(";age=");
		sb.append(age);
		sb.append("}");
		return sb.toString();
		//return ( "{Person: nif="+nif+";name="+name+";age="+age+"}" );
	}
	/** equals()
	 * compares this person to another one
	 * two persons are equals if their nifs are equals.
	 * @param Person other: the other person to compare to
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Person other) {
		return (nif.equals(other.nif));
	}
}
