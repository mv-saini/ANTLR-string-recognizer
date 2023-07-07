/**
 * This class creates the structure of a NFA transition. It contains the start and end of the transition which are
 * NFA states and the symbol with which the transition occurs.
 */
public class NFATransition {

    /**
     * start of the transition.
     */
    private NFAState start;

    /**
     * end of the transition.
     */
    private NFAState end;

    /**
     * symbol of the transition.
     */
    private String symbol;

    /**
     * Creates the transition.
     * @param start start of the transition.
     * @param end end of the transition.
     * @param symbol symbol of the transition.
     */
    public NFATransition(NFAState start, NFAState end, String symbol) {
        this.start = start;
        this.end = end;
        this.symbol = symbol;
    }

    /**
     * Returns the start the transition.
     * @return start
     */
    public NFAState getStart() {
        return this.start;
    }

    /**
     * Returns the end the transition.
     * @return end
     */
    public NFAState getEnd() {
        return this.end;
    }

    /**
     * Returns the symbol of transition.
     * @return symbol
     */
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return start.toString() + " => " + symbol + " => " + end.toString();
    }
}
