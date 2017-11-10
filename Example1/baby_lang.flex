/* --------------------------Usercode Section------------------------ */

/* Code in this section will be added to the top of the generated Java class */
package Example1;
%%

/* -----------------Options and Declarations Section----------------- */

%class Alex
%function alex

/* Specifies that the return type of the method yylex() will be void and not Yytoken */
%type Void

/* regular expressions [macros] for a letter and a new line */
letter = [A-Za-z]
word = {letter}+
number = [0-9]
numbers = {number}+
newline = \r|\n|\r\n

%%

/* ------------------------Lexical Rules Section---------------------- */


/* Print the text matched by the current rule */ 
{word} {System.out.println(yytext());}

/* Print the text matched by the current rule */ 
{numbers} {System.out.println(yytext());}

/* Ignore (do nothing) with newline */
{newline} {}

/* Ignore (do nothing) for any other character (dot represented any char other than a new line) */
. {}
