package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's postal code in the addressbook
 * @author ZavierOng
 */
public class PostalCode {

	public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS =
            "Person postal code should only contain numbers";
    public static final String POSTAL_CODE_VALIDATION_REGEX = "\\d+";
	
	private final String postalCodeNumber;

    /**
     * Validates block number
     * 
     * @throws IllegalValueException if given postal code is invalid
     */
    public PostalCode(String postalCode) throws IllegalValueException{
    	postalCode = postalCode.trim();
    	if (!isValidPostalCode(postalCode)){
    		throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
    	}
    	this.postalCodeNumber = postalCode;
    }
    
    public static boolean isValidPostalCode(String test){
    	return test.matches(POSTAL_CODE_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return postalCodeNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.postalCodeNumber.equals(((PostalCode) other).postalCodeNumber)); // state check
    }

    @Override
    public int hashCode() {
        return postalCodeNumber.hashCode();
    }
    
    public String getPostalCode() {
        return postalCodeNumber;
    }
}
