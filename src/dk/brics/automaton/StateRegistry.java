package dk.brics.automaton;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a registry to maintain relationship between state numbers
 * and various automaton IDs. This registry is useful when a union automaton
 * gets built out of multiple automata and subsequently it becomes essential to
 * track each state's original relationship with its previous automaton.
 * 
 * @author neeraj
 *
 */
public class StateRegistry {
	private static final Map<Integer, Integer> REGISTRY = new HashMap<Integer, Integer>( );

	/**
	 * Returns the automaton ID associated with the given state number.
	 * 
	 * @param state
	 *            the state number
	 * @return the automaton ID associated with the given state number;
	 *         {@link Automaton#UNASSIGNED_AUTOMATON_ID} if no automaton is
	 *         associated with the given state number
	 */
	public static Integer get( Integer state ) {
		if( StateRegistry.REGISTRY.get( state ) != null ) {
			return StateRegistry.REGISTRY.get( state );
		} else {
			return Automaton.UNASSIGNED_AUTOMATON_ID;
		}
	}

	/**
	 * Registers the given state number and automaton ID that it's associated
	 * with. Note: this method writes to a {@code java.util.HashMap} and is not
	 * thread-safe.
	 * 
	 * @param state
	 *            the state number
	 * @param automatonId
	 *            the automaton ID
	 */
	public static void set( Integer state, Integer automatonId ) {
		StateRegistry.REGISTRY.put( state, automatonId );
	}

}
