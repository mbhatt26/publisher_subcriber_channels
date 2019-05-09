package pubSubServer;

import events.AbstractEvent;

/**
 * Implements the Strategy Design Pattern
 * 
 * Implements the functions of the AbstractModerator class.
 * Serves to manage the contents of event traffic flowing through ChannelEventDispatcher
 * @author jarro
 *
 */
public class ModeratorA extends AbstractModerator {
		//constructor
		protected ModeratorA() {}
		
		
		/**
		 * handles an event passed to it, moderates content and returns event
		 * @param e is the event passed to the object
		 * @return the event once edited according to internal moderation logic
		 */
		protected AbstractEvent moderate(AbstractEvent e) {
			System.out.println("ModeratorA has handled event " + e.getClass());
			return e;
		}
}
