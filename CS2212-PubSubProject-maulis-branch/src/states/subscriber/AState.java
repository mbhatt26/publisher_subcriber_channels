package states.subscriber;

import events.AbstractEvent;

public class AState implements IState {

	/**As described in IState:
	 * the handleEvent method will behave appropriately depending on the implementation.
	 * In general it will do something, after an AbstractEvent is published on an 
	 * AbstractChannel to which the ConcreteState's host Object is subscribed
	 * @param event			the event which a subscriber is notified of and which its state must handle
	 * @param channelName	the channel which the event is posted to
	 */
	public void handleEvent(AbstractEvent event, String channelName) {
		System.out.println("An " + this.getClass() + " has handled " + event.getClass() + " in the " + channelName +" channel.");
	}

}