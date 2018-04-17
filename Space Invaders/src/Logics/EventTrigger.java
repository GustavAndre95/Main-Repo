/**
 * <h1>EventTrigger</h1>
 * Interfacet EventTrigger används av powerups, och metoden TriggerEvent bestämmer vad som ska göra
 * om PowerUpen aktiveras.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Logics;

public interface EventTrigger {
	public void triggerEvent(ObjectMap map);

}
