grammar GrammarSample;

ALPHABET: [a-zA-Z0-9];
WS: [ \t\r\n]+ -> skip;

init: regex ',' stringList EOF;

regex: concat ('+' concat)*;

concat: kleene+;

kleene: basic '*'  #star
      | basic #noStar
      ;

basic: ALPHABET #basicAlphabet
     | 'epsilon' #basicEpsilon
     | '(' regex ')' #basicRegex
     ;

stringList: string (',' string)*;

string: (ALPHABET)+;