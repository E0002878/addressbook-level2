package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must contain the block"
    		+ ", street, unit and postal code with each separated by a ,";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
	
    private Block blockNumber;
    private Street streetName;
    private Unit unitNumber;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
    	
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        createAddress(address);
    }
    
    private void createAddress(String address) throws IllegalValueException {
    	final int BLOCK_INDEX = 0;
    	final int STREET_INDEX = 1;
    	final int UNIT_INDEX = 2;
    	final int POSTAL_CODE_INDEX = 3;

        String[] addressSegment = address.split(",");
        if (addressSegment.length != 3) {
        	throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        blockNumber = new Block(addressSegment[BLOCK_INDEX].trim());
        streetName = new Street(addressSegment[STREET_INDEX].trim());
        unitNumber = new Unit(addressSegment[UNIT_INDEX].trim());
        postalCode= new PostalCode(addressSegment[POSTAL_CODE_INDEX].trim());
    }
    
    /**
     * @return the String representation of the address formatted 
     * by BLOCK, STREET, UNIT, POSTAL_CODE 
     */
    public String getAddress() {
    	return this.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "" + blockNumber.getBlock() + ", " + streetName.getStreet() + ", " + unitNumber.getUnit() + ", " 
        		+ postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}