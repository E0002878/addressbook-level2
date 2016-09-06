package seedu.addressbook.data.person;

public class Contact {
	
    public final String value;
    private boolean isPrivate;
    
    public Contact(String contactSegment, boolean isPrivate){
    	this.value = contactSegment.trim();
    	this.isPrivate = isPrivate;
    }
    
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidSegment(String test, String validationRegex) {
        return test.matches(validationRegex);
    }
    
    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
