package pubSubServer;

import java.util.List;

import events.AbstractEvent;
import publishers.AbstractPublisher;


/**
 * @author kkontog, ktsiouni, mgrigori
 * MUST IMPLEMENT the Singleton design pattern
 * Class providing an interface for {@link AbstractPublisher} objects to cover their publishing needs 
 */
public class ChannelEventDispatcher {

	private static ChannelEventDispatcher instance = null;
	private ChannelPoolManager cpManager;
	private AbstractModerator mod;
	
	/**
	 * constructor
	 */
	private ChannelEventDispatcher() {
		cpManager = ChannelPoolManager.getInstance();
		mod = new ModeratorDefault();
	}
	
	/**
	 * Implements the Singleton design Patter.
	 * Manages creation to reference only one object at a time.
	 * 
	 * @return the instance of the ChannelAccessControl object
	 */
	public static ChannelEventDispatcher getInstance() {
		if (instance == null)
			instance = new ChannelEventDispatcher();
		return instance;
	}

	/**
	 * changes the moderator hitched to the system according to the parameter
	 * 
	 * @param c is the flag that relates to one of three moderator classes below
	 */
	public void setMod(char c) {
		switch(c) {
		
		case 'A':
			mod = new ModeratorA();
			break;
		
		case 'B':
			mod = new ModeratorB();
			break;
		
		default:
			mod = new ModeratorDefault();
		}
	}
	
	/**
	 * @param event event to be published
	 * @param listOfChannels list of channel names to which the event must be published to 
	 */
	public void postEvent(AbstractEvent event, List<String> listOfChannels) {
		
		for(String channelName : listOfChannels) {
			AbstractChannel channel = cpManager.findChannel(channelName);
			if(channel == null) {
				channel = ChannelCreator.getInstance().addChannel(channelName);
			}
			System.out.println("Channel " + channelName + " has event " + event.getClass());
			channel.publishEvent(event);
		}
	}
	
	
}
