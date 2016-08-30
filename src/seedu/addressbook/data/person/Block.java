package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a person's block in the addressbook
 * @author ZavierOng
 */
public class Block {
	
	public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS =
            "Person block should only contain numbers";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";
	
	private final String blockNumber;

    /**
     * Validates block number
     * 
     * @throws IllegalValueException if given block is invalid
     */
    public Block(String block) throws IllegalValueException{
    	block = block.trim();
    	if (!isValidBlock(block)){
    		throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
    	}
    	this.blockNumber = block;
    }
    
    public static boolean isValidBlock(String test){
    	return test.matches(BLOCK_VALIDATION_REGEX);
    }
    
    @Override
    public String toString() {
        return blockNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.blockNumber.equals(((Block) other).blockNumber)); // state check
    }

    @Override
    public int hashCode() {
        return blockNumber.hashCode();
    }

	
}
