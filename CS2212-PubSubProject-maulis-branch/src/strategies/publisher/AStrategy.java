package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import events.EventFactory;
import events.EventMessage;
import events.EventType;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;

public class AStrategy implements IStrategy {

	public AStrategy() {		
	}

	/**
	 * This posts a new default event to the channel 0 in the directory, as an announcement.
	 */
	public void doPublish(int publisherId) {
		String current = "main";
		AbstractEvent newEvent = EventFactory.createEvent(events.EventType.Announcement, publisherId, new EventMessage("",""));
		
		System.out.println("Publisher " + publisherId + " publishes event " + newEvent);
		
		List<String> inputChannels = new ArrayList<String>();
		inputChannels.add(current);
		
		ChannelEventDispatcher.getInstance().postEvent(newEvent, inputChannels);
	}

	/**
	 * This posts the given channel to the channel 0 in the directory, as an announcement.
	 */
	public void doPublish(AbstractEvent event, int publisherId) {
		String current = "0";
		List<String> inputChannels = new ArrayList<String>();
		inputChannels.add(current);
		
		System.out.println("Publisher " + publisherId + " publishes event " + event);
		
		ChannelEventDispatcher.getInstance().postEvent(event, inputChannels);
	}

}
