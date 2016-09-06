package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's street in the addressbook
 * @author ZavierOng
 */
public class Street {
	
	public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_STREET_CONSTRAINTS =
            "Person block can contain letters and numbers but not symbols";
    public static final String STREET_VALIDATION_REGEX = "[\\w\\s]+";
	
	private final String streetName;
	
	/**
     * Validates street name
     * 
     * @throws IllegalValueException if given street is invalid
     */
    public Street(String street) throws IllegalValueException{
    	street = street.trim();
    	if (!isValidStreet(street)){
    		throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
    	}
    	this.streetName = street;
    }
    
    public static boolean isValidStreet(String test){
    	return test.matches(STREET_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return streetName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.streetName.equals(((Street) other).streetName)); // state check
    }

    @Override
    public int hashCode() {
        return streetName.hashCode();
    }
    
    public String getStreet() {
        return streetName;
    }
	
}
