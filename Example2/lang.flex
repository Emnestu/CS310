/*---- Java preamble code ----*/
package Example2;
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

/* Macro for digits **/
digits=[0-9]+

%%
/*---- Actions ----*/
/* The initial scanning state is YYINITIAL */
<YYINITIAL>"if"               {return new Token (Token.IF, yytext());}

<YYINITIAL>"/*"               {yybegin(COMMENT);} /*yybegin sets the current state */

<YYINITIAL>[a-z][a-z0-9]*     {return new Token (Token.IDENT, yytext());}

<YYINITIAL>{digits}           {return new Token (Token.INT, new Integer (yytext()));}

<YYINITIAL>({digits}"."[0-9]*)|([0-9]*"."{digits})
                   {return new Token (Token.REAL, new Double (yytext()));}

<YYINITIAL>[\r\n\t\ ]+    {}

<COMMENT>"*/"     {yybegin(YYINITIAL);}
<COMMENT>.        {}
