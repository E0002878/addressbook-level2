package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's unit in the addressbook
 * @author ZavierOng
 */
public class Unit {
	public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
            "Person unit should start with a # with a - in between";
    public static final String UNIT_VALIDATION_REGEX = "\\p{#}\\d+\\p{-}\\d+";
	
	private final String unitNumber;

    /**
     * Validates unit number
     * 
     * @throws IllegalValueException if given unit is invalid
     */
    public Unit(String unit) throws IllegalValueException{
    	unit = unit.trim();
    	if (!isValidUnit(unit)){
    		throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
    	}
    	this.unitNumber = unit;
    }
    
    public static boolean isValidUnit(String test){
    	return test.matches(UNIT_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return unitNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.unitNumber.equals(((Unit) other).unitNumber)); // state check
    }

    @Override
    public int hashCode() {
        return unitNumber.hashCode();
    }

}
