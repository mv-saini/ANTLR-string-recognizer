// Generated from C:/Users/snamv/IdeaProjects/ProjectANTLR/src/main/java\GrammarSample.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarSampleParser}.
 */
public interface GrammarSampleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarSampleParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(GrammarSampleParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarSampleParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(GrammarSampleParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarSampleParser#regex}.
	 * @param ctx the parse tree
	 */
	void enterRegex(GrammarSampleParser.RegexContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarSampleParser#regex}.
	 * @param ctx the parse tree
	 */
	void exitRegex(GrammarSampleParser.RegexContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarSampleParser#concat}.
	 * @param ctx the parse tree
	 */
	void enterConcat(GrammarSampleParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarSampleParser#concat}.
	 * @param ctx the parse tree
	 */
	void exitConcat(GrammarSampleParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterStar(GrammarSampleParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitStar(GrammarSampleParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noStar}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterNoStar(GrammarSampleParser.NoStarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noStar}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitNoStar(GrammarSampleParser.NoStarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicAlphabet}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasicAlphabet(GrammarSampleParser.BasicAlphabetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicAlphabet}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasicAlphabet(GrammarSampleParser.BasicAlphabetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicEpsilon}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasicEpsilon(GrammarSampleParser.BasicEpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicEpsilon}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasicEpsilon(GrammarSampleParser.BasicEpsilonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicRegex}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasicRegex(GrammarSampleParser.BasicRegexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicRegex}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasicRegex(GrammarSampleParser.BasicRegexContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarSampleParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(GrammarSampleParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarSampleParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(GrammarSampleParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarSampleParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarSampleParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarSampleParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarSampleParser.StringContext ctx);
}