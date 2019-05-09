package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import events.EventFactory;
import events.EventMessage;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;

public class BStrategy implements IStrategy {

	public BStrategy() {
	}

	/**
	 * Publish a general default event to every third channel.
	 */
	public void doPublish(int publisherId) {
		List<AbstractChannel> channels = ChannelDiscovery.getInstance().listChannels();
		int s = channels.size();
		
		int i = 0;
		AbstractEvent newEvent = EventFactory.createEvent(events.EventType.General, publisherId, new EventMessage("",""));

		System.out.println("Publisher " + publisherId + " publishes event " + newEvent);
		
		List<String> inputChannels = new ArrayList<String>();
		
		while(i<s){
			if (i%3==0){
				String current = channels.get(i).getChannelTopic();
				inputChannels.add(current);
			}
			i++;
		}
		ChannelEventDispatcher.getInstance().postEvent(newEvent, inputChannels);
	}

	
	/**
	 * Publish the given event to every third channel.
	 */
	public void doPublish(AbstractEvent event, int publisherId) {
		List<AbstractChannel> channels = ChannelDiscovery.getInstance().listChannels();
		int s = channels.size();
		
		int i = 0;
		
		System.out.println("Publisher " + publisherId + " publishes event " + event);
		
		List<String> inputChannels = new ArrayList<String>();
		
		while(i<s){
			if (i%3==0){
				String current = channels.get(i).getChannelTopic();
				inputChannels.add(current);
			}
			i++;
		}
		ChannelEventDispatcher.getInstance().postEvent(event, inputChannels);
	}
}
