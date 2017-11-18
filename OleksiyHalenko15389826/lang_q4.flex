/*---- Java preamble code ----*/
package Example4;
%%

/*---- Options and directives ----*/
%type Token // return a Token

/* The code included in %eofval{....}%eofval will be copied verbatim into the scanning method and will be
executed each time when the end of file is reached. The code returns a Token that indicates the end of file. */
%eofval{
  {return new Token (Token.EOF, null);}
%eofval}

/* The following declares a state called COMMENT - the lexical analyser can match different rules depending on the
   state it is in. */
%state COMMENT 
%state INLINE_COMMENT 

/* Macro for digits **/
digits=[0-9]+
reserved_words="if"|"for"|"while"|"do"|"class"|"public"|"static"|"void"|"int"|"float"
special_characters="{\", \"}"|"(\", \")"|"[\", \"]"|"."|";"|"="|"=="|"+"|"-"|"*"|"/"

%%
/*---- Actions ----*/
/* The initial scanning state is YYINITIAL */
<YYINITIAL>{reserved_words} 						{return new Token (Token.RESERVED_WORD, yytext());}

<YYINITIAL>{special_characters}						{return new Token (Token.SPECIAL_CHARACTER, yytext());}

<YYINITIAL>"/*"               						{yybegin(COMMENT);} /*yybegin sets the current state */

<YYINITIAL>"//"               						{yybegin(INLINE_COMMENT);}

<YYINITIAL>[a-zA-Z_][a-zA-Z0-9_]*     		{return new Token (Token.IDENTIFIER, yytext());}

<YYINITIAL>{digits}           						{return new Token (Token.INT_LITERAL, new Integer (yytext()));}

<YYINITIAL>({digits}"."[0-9]*)|([0-9]*"."{digits}f)	{return new Token (Token.FLT_LITERAL, new Double (yytext()));}

<YYINITIAL>\".*?\"									{return new Token (Token.STR_LITERAL, new String (yytext()));}

<YYINITIAL>[\r\n\t\ ]+    							{}

<COMMENT>"*/"     									{yybegin(YYINITIAL);}

<COMMENT>.        									{}

<INLINE_COMMENT>"\r"|"\n"							{yybegin(YYINITIAL);}

<INLINE_COMMENT>.									{}
