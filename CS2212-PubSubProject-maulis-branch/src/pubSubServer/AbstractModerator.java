package pubSubServer;
import events.AbstractEvent;

/**
 * Filters and moderates events traveling through the system.
 * Views, edits, and deletes events passed to it according to
 * internal logic.
 */

public abstract class AbstractModerator {
	
	/**
	 * views and edits passed event according to internal logic, passing the changed object back to the caller
	 * @param e is the event being moderated (viewed, edited)
	 * @return the edited event object, null is deleted.
	 */
	protected AbstractEvent moderate(AbstractEvent e) {return e;}
}
