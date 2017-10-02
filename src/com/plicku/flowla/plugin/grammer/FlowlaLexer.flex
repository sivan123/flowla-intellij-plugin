package com.plicku.flowla.plugin.grammer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.plicku.flowla.plugin.psi.FlowlaTypes;
import com.intellij.psi.TokenType;

%%

%public
%class FlowlaLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#")[^\r\n]*
SEPARATOR=[:=]
STEP_KEYWORD="Given "|"Then "|"When "
STEPNAME={STEP_KEYWORD}.*?[\n\r]
STEP={STEP_KEYWORD}{STEPNAME}
%state STEP

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return FlowlaTypes.COMMENT; }

//<YYINITIAL> {STEP_KEYWORD}                                { yystate(STEP); }

<STEP> {
    {STEP_KEYWORD}                                      {return FlowlaTypes.STEP_KEYWORD;}
    {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}

}
({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
