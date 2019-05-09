package subscribers;

import states.subscriber.StateName;


/**
 * @author kkontog, ktsiouni, mgrigori
 *  
 */
/**
 * @author kkontog, ktsiouni, mgrigori
 * creates new {@link AbstractSubscriber} objects
 * contributes to the State design pattern
 * implements the FactoryMethod design pattern   
 */
public class SubscriberFactory {

	
	/**
	 * creates a new basic {@link AbstractSubscriber} with a default state 
	 */
	public static AbstractSubscriber createSubscriber(StateName stateName) {
		AbstractSubscriber newSub = new DefaultSubscriber(SubIDMaker.getNewSubID());
		newSub.setState(stateName);
		return newSub;
	}
	
}
