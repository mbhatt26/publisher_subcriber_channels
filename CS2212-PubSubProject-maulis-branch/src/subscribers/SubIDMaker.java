package subscribers;

public class SubIDMaker {
	private static long subUIDs = 0L;
	
	/**
	 * 
	 * @return the next number of type {@link long}in the series of UID for the AbstractSubscriber derived classes
	 */
	protected static long getNewSubID() {
		return subUIDs++;
	}
}

