import java.util.*;

/**
 * This class is responsible for the creation of NFA automaton. It uses thompson's rules to create a NFA automaton.
 */
public class ThompsonNFA {

    /**
     * Start of the automaton.
     */
    private NFAState start;

    /**
     * end of the automaton.
     */
    private NFAState end;

    /**
     * This is a set that contains all the states that belong to this automaton. This can be omitted because you can
     * simply go to the end of the transition and get its transitions and so on, but it makes looping in certain cases
     * simple.
     */
    private Set<NFAState> states;

    /**
     * Contains the output of the string. "OK" if the string can be generated by the automaton otherwise "KO".
     */
    private ArrayList<String> output;

    /**
     * Creates an empty nfa automaton.
     */
    public ThompsonNFA(){
        this.start = null;
        this.end = null;
        this.output = new ArrayList<>();
        this.states = new HashSet<>();
    }

    /**
     * Creates a new nfa automaton.
     * @param start start of the automaton.
     * @param end end of the automaton.
     */
    public ThompsonNFA(NFAState start, NFAState end) {
        this.start = start;
        this.end = end;
        this.output = new ArrayList<>();
        this.states = new HashSet<>();
        this.states.add(this.start);
        this.states.add(this.end);
    }

    /**
     * Returns the start of the automaton.
     * @return start.
     */
    public NFAState getStart() {
        return this.start;
    }

    /**
     * Returns the end of the automaton.
     * @return end.
     */
    public NFAState getEnd() {
        return this.end;
    }

    /**
     * Returns the output generated by the nfa automaton.
     * @return list containing output.
     */
    public ArrayList<String> getOutput() {
        return this.output;
    }

    /**
     * This method checks if the given string can be generated by this automaton.
     * @param s string to check.
     */
    public void accept(String s){
        //calculate the closure of the start of the automaton.
        ArrayList<NFAState> closure = new ArrayList<>(this.eClosure(this.start));

        //for every character in string.
        for (char c : s.toCharArray()){
            //next states to do e-closure on
            Set<NFAState> nextStates = new HashSet<>();

            //loop for every transition of every state.
            for(NFAState state : closure)
                for(NFATransition t : state.getTransitions())
                    if(t.getSymbol().equals(String.valueOf(c)))
                        nextStates.add(t.getEnd());

            //clears the old closure.
            closure.clear();
            //calculate new closure with next states.
            for(NFAState next : nextStates)
                closure.addAll(this.eClosure(next));

            //if closure is empty meaning can go anywhere then string can't be generated by this NFA because there
            // are more characters to check but can't go anywhere else.
            if(closure.size() == 0){
                this.output.add("KO");
                return;
            }
        }

        //if all characters have been checked. If last calculated closure has a final state then we can say that
        // this string 's' can be generated by this NFA.
        for (NFAState state : closure) {
            if (state.isFinalState()) {
                this.output.add("OK");
                return;
            }
        }
        //No final state found so this string can't be generated by this NFA.
        this.output.add("KO");
    }

    /**
     * Calculates the e-closure if a given state recursively.
     * @param state state to do closure on.
     * @return the list of closure states.
     */
    private ArrayList<NFAState> eClosure(NFAState state){
        ArrayList<NFAState> nfaStates = new ArrayList<>();
        nfaStates.add(state);

        //loop on all transitions of state and if the state's transitions with an 'epsilon' then add all the closure
        // states of the end of that transition to the list of closure states.
        for(NFATransition transition : state.getTransitions())
            if(transition.getSymbol().equals("epsilon"))
                nfaStates.addAll(this.eClosure(transition.getEnd()));

        return nfaStates;
    }

    /**
     * This method runs the union operation on NFA's.
     * @param union Contains the NFA's to do union operation.
     * @param newUnionStart new union start, which will go into other NFA's with epsilon.
     * @param newUnionEnd new union end, which is accessed by the end of other NFA's with epsilon.
     */
    public void unionGenerator(ArrayList<ThompsonNFA> union, NFAState newUnionStart, NFAState newUnionEnd){
        //assign the new end and start.
        this.start = newUnionStart;
        this.end = newUnionEnd;

        //for loop to loop all the nfa's to do union on.
        for (ThompsonNFA nfa : union) {
            //New transition from new start to old start of a NFA with symbol epsilon and old start is not initial anymore.
            NFATransition t1 = new NFATransition(this.start, nfa.start, "epsilon");
            this.start.addTransition(t1);
            nfa.start.setInitialState(false);

            //New transition from old end of a NFA to new end with symbol epsilon and old start is not final anymore.
            NFATransition t2 = new NFATransition(nfa.end, this.end, "epsilon");
            nfa.end.addTransition(t2);
            nfa.end.setFinalState(false);

            //Add newly formed states to the set of all states of the automaton.
            this.states.add(this.start);
            this.states.add(this.end);

            //adds the rest of the nfa states to the set of the all the states of the unionized new automaton.
            this.states.addAll(nfa.states);
        }
    }

    /**
     * This method concats the NFA's.
     * @param toConcat Contains the NFA's to concat
     */
    public void concatGenerator(ArrayList<ThompsonNFA> toConcat) {
        //assign start of concatenated nfa as the start of 1st NFA to concat and end as the end of the last NFA.
        this.start = toConcat.get(0).start;
        this.end = toConcat.get(toConcat.size() - 1).end;

        //Adds the start and end to concatenated NFA's set of states.
        this.states.add(this.start);
        this.states.add(this.end);

        //for loop to update the end of each NFA (except the last one) as the start of the next NFA (series of concatenation).
        for(int i = 0; i < toConcat.size() - 1; i++) {
            //temp fields for better readability.
            ThompsonNFA currentNFA = toConcat.get(i);
            ThompsonNFA nextNFA = toConcat.get(i + 1);

            //adds all the index i's nfa states to the set of all the states.
            this.states.addAll(toConcat.get(i).states);

            //old end to be replaced by the start of the next nfa in the transitions.
            NFAState oldEndToReplace = currentNFA.end;

            //updates the old end with the new end.
            currentNFA.end = nextNFA.start;
            nextNFA.start.setInitialState(false);

            //for-each loop that updates the rest of the transitions old end with new end.
            Set<NFAState> toAdd = new HashSet<>();
            for(NFAState state : this.states){
                if(!state.getName().equals(oldEndToReplace.getName())){
                    for(NFATransition transition : state.getTransitions()){
                        if(transition.getEnd().getName().equals(oldEndToReplace.getName())){
                            NFATransition l = new NFATransition(transition.getStart(), currentNFA.end, transition.getSymbol());
                            toAdd.add(currentNFA.end);
                            transition.getStart().addTransition(l);
                            transition.getStart().getTransitions().remove(transition);
                        }
                        toAdd.add(state);
                    }
                }
            }
            //removes the old end from the set and adds the remaining states from other nfa's to the new concatenated nfa.
            this.states.remove(oldEndToReplace);
            this.states.addAll(toAdd);
        }
        //adds the states of the last nfa which were not iterated in the for loop.
        this.states.addAll(toConcat.get(toConcat.size() - 1).states);
    }

    /**
     * Generates new NFA with ALPHABET.
     * @param symbol symbol of transition
     */
    public void basicAlphabetGenerator(String symbol){
        NFATransition transition = new NFATransition(start, end, symbol);
        this.start.addTransition(transition);
    }

    /**
     * Generates new NFA with epsilon.
     * @param symbol symbol of transition, in this case always epsilon.
     */
    public void basicEpsilonGenerator(String symbol){
        NFATransition transition = new NFATransition(start, end, symbol);
        this.start.addTransition(transition);
    }

    /**
     * Generates new kleene NFA.
     * @param newKleeneStart new start
     * @param newKleeneEnd new end
     */
    public void kleeneGenerator(NFAState newKleeneStart, NFAState newKleeneEnd){
        //Old states are not initial or final after this.
        this.start.setInitialState(false);
        this.end.setFinalState(false);

        //Old end is connected to old new with epsilon.
        NFATransition t1 = new NFATransition(this.end, this.start, "epsilon");
        this.end.addTransition(t1);

        //new start is connected to old new with epsilon.
        NFATransition t3= new NFATransition(newKleeneStart, this.start, "epsilon");
        newKleeneStart.addTransition(t3);

        //Old end is connected to new end with epsilon.
        NFATransition t4 = new NFATransition(this.end, newKleeneEnd, "epsilon");
        this.end.addTransition(t4);

        //Assign new start and new end.
        this.start = newKleeneStart;
        this.end = newKleeneEnd;

        //new start is connected to new end with epsilon.
        NFATransition t2 = new NFATransition(this.start, this.end, "epsilon");
        this.start.addTransition(t2);

        //Add the new start and new end to the set of all states.
        this.states.add(this.start);
        this.states.add(this.end);
    }


    @Override
    public String toString() {
        return "ThompsonNFA{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
