package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import events.EventFactory;
import events.EventMessage;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;

public class DefaultStrategy implements IStrategy {

	public DefaultStrategy() {
	}

	/**
	 * Publish a default event of type Advertisement to every channel.
	 */
	public void doPublish(int publisherId) {
		List<AbstractChannel> channels = ChannelDiscovery.getInstance().listChannels();
		AbstractEvent newEvent = EventFactory.createEvent(events.EventType.Advertisement, publisherId, new EventMessage("",""));
		int s = channels.size();
		
		int i = 0;
		
		System.out.println("Publisher " + publisherId + " publishes event " + newEvent);
		
		List<String> inputChannels = new ArrayList<String>();
		
		while(i<s){
			String current = channels.get(i).getChannelTopic();
			inputChannels.add(current);
			i++;
		}
		ChannelEventDispatcher.getInstance().postEvent(newEvent, inputChannels);
	}

	/**
	 * Publish an event to every channel.
	 */
	public void doPublish(AbstractEvent event, int publisherId) {
		List<AbstractChannel> channels = ChannelDiscovery.getInstance().listChannels();
		int s = channels.size();
		
		int i = 0;
		
		System.out.println("Publisher " + publisherId + " publishes event " + event);
		
		List<String> inputChannels = new ArrayList<String>();
		
		while(i<s){
			String current = channels.get(i).getChannelTopic();
			inputChannels.add(current);
			i++;
		}
		ChannelEventDispatcher.getInstance().postEvent(event, inputChannels);

	}

}
