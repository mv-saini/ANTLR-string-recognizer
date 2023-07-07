import java.util.ArrayList;

/**
 * This class creates the structure of a NFA state. It contains name of the state, whether the state is initial or
 * final and its transitions.
 */
public class NFAState {

    /**
     * Name of state
     */
    private String name;

    /**
     * State is the start state of the automaton.
     */
    private boolean initialState;

    /**
     * State is the final state of the automaton.
     */
    private boolean finalState;

    /**
     * All the transitions of the state.
     */
    private ArrayList<NFATransition> transitions;

    /**
     * Creates a state.
     * @param name name of the state.
     * @param initialState whether the state is initial or not.
     * @param finalState whether the state is final or not.
     * @param transitions transitions of this new state.
     */
    public NFAState(String name, boolean initialState, boolean finalState, ArrayList<NFATransition> transitions) {
        this.name = name;
        this.initialState = initialState;
        this.finalState = finalState;
        this.transitions = transitions;
    }

    /**
     * Returns the name of the state.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the status of the state.
     * @return true if state is initial else false.
     */
    public boolean isInitialState() {
        return this.initialState;
    }

    /**
     * Returns the status of the state.
     * @return true if state is final else false.
     */
    public boolean isFinalState() {
        return this.finalState;
    }

    /**
     * Returns the transitions of the state.
     * @return transitions.
     */
    public ArrayList<NFATransition> getTransitions() {
        return this.transitions;
    }

    /**
     * Updates the status of the state.
     * @param initialState new status.
     */
    public void setInitialState(boolean initialState) {
        this.initialState = initialState;
    }

    /**
     * Updates the status of the state.
     * @param finalState new status.
     */
    public void setFinalState(boolean finalState) {
        this.finalState = finalState;
    }

    /**
     * Adds a new transitions to state.
     * @param transition the new transition to add.
     */
    public void addTransition(NFATransition transition){
        this.transitions.add(transition);
    }

    @Override
    public String toString() {
        return "NFAState{" +
                "name='" + name + '\'' +
                ", initialState=" + initialState +
                ", finalState=" + finalState +
                ", transitions=" + transitions +
                '}';
    }
}
