// Generated from C:/Users/snamv/IdeaProjects/ProjectANTLR/src/main/java\GrammarSample.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarSampleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarSampleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarSampleParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(GrammarSampleParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarSampleParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegex(GrammarSampleParser.RegexContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarSampleParser#concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(GrammarSampleParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code star}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(GrammarSampleParser.StarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noStar}
	 * labeled alternative in {@link GrammarSampleParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoStar(GrammarSampleParser.NoStarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicAlphabet}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicAlphabet(GrammarSampleParser.BasicAlphabetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicEpsilon}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicEpsilon(GrammarSampleParser.BasicEpsilonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicRegex}
	 * labeled alternative in {@link GrammarSampleParser#basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicRegex(GrammarSampleParser.BasicRegexContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarSampleParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(GrammarSampleParser.StringListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarSampleParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(GrammarSampleParser.StringContext ctx);
}