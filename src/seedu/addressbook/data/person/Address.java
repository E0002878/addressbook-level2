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

    private final Block blockNumber;
    private final Street streetName;
    private final Unit unitNumber;
    private final PostalCode postalCode;
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
    
    private void createAddress(String address){
        String[] addressSegment = address.split(",");
        
        blockNumber = new Block(addressSegment[0].trim());
        streetName = new Street(addressSegment[1].trim());
        unitNumber = new Unit(addressSegment[2].trim());
        postalCode= new PostalCode(addressSegment[3].trim());
    }
    
    /**
     * @return the blockNumber
     */
    private String getBlock() {
    	return blockNumber.getBlock();
    }

    /**
     * @return the streetName
     */
    private String getStreet() {
        return streetName.getStreet();
    }

    /**
     * @return the unitNumber
     */
    private String getUnit() {
        return unitNumber.getUnit();
    }

    /**
     * @return the postalCodeNumber
     */
    private String getPostalCode() {
        return postalCode.getPostalCode();
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
        return "" + getBlock() + ", " + getStreet() + ", " + getUnit() + ", " + getPostalCode();;
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