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
BOL = [\r\n\f]+
WHITE_SPACE=[\ \n\t\f]
END_OF_LINE_COMMENT=("#")[^\r\n]*
GIVEN_KEYWORD= {WHITE_SPACE}*"Given "
WHEN_KEYWORD= {WHITE_SPACE}*"When "
THEN_KEYWORD= {WHITE_SPACE}*"Then "
BUT_KEYWORD= {WHITE_SPACE}*"But "
AND_KEYWORD= {WHITE_SPACE}*"And "
IF_KEYWORD= {WHITE_SPACE}*"If "
ELSEIF_KEYWORD= {WHITE_SPACE}*"Else If "
ENDIF_KEYWORD= {WHITE_SPACE}*"EndIf"
OTHERWISE_KEYWORD= {WHITE_SPACE}*"Otherwise"
FOREACH_KEYWORD= {WHITE_SPACE}*"For Each "
REEATFOR_KEYWORD= {WHITE_SPACE}*"Repeat For "
REPEAT_WHILE_KEYWORD= {WHITE_SPACE}*"Repeat While "

STEP_KEYWORD={GIVEN_KEYWORD}|{WHEN_KEYWORD}|{THEN_KEYWORD}
                |{BUT_KEYWORD}|{AND_KEYWORD}|{IF_KEYWORD}|{ELSEIF_KEYWORD}
                |{ENDIF_KEYWORD}|{OTHERWISE_KEYWORD}|{FOREACH_KEYWORD}|{REEATFOR_KEYWORD}|{REPEAT_WHILE_KEYWORD}

PROCESSING_KEWORDS={GIVEN_KEYWORD}|{WHEN_KEYWORD}|{THEN_KEYWORD}|{BUT_KEYWORD}|{AND_KEYWORD}

STEPNAME=[^\r\n]*
//STEPDATA=( [^*] | \*+ [^/*] )*
STEPDATA=( [^*] | \*+ [^/*] )*{STEP_KEYWORD}
%state PROCESS_STEP
%state IF_STEP
%state FOR_STEP
%state ELSE_IF_STEP
%state OTHERWISE_STEP
%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return FlowlaTypes.COMMENT; }
<YYINITIAL> {PROCESSING_KEWORDS}                                  { yybegin(PROCESS_STEP); return FlowlaTypes.STEP_KEYWORD; }
<PROCESS_STEP> {
        {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}
        {STEPDATA}                                          {return FlowlaTypes.MULTILINE_ARG;}
}
<YYINITIAL> {IF_KEYWORD}                                  { yybegin(IF_STEP); return FlowlaTypes.STEP_KEYWORD; }
<IF_STEP>{
        {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}
        {STEPDATA}                                          {return FlowlaTypes.MULTILINE_ARG;}
        {ELSEIF_KEYWORD}                                    { yybegin(ELSE_IF_STEP); return FlowlaTypes.STEP_KEYWORD; }
        {OTHERWISE_KEYWORD}                                    { yybegin(OTHERWISE_STEP); return FlowlaTypes.STEP_KEYWORD; }
}
<ELSE_IF_STEP>{
        {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}
        {STEPDATA}                                          {return FlowlaTypes.MULTILINE_ARG;}
        {OTHERWISE_KEYWORD}                                 { yybegin(OTHERWISE_STEP); return FlowlaTypes.STEP_KEYWORD; }
}
<OTHERWISE_STEP>{
        {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}
        {STEPDATA}                                          {return FlowlaTypes.MULTILINE_ARG;}
        {OTHERWISE_KEYWORD}                                 { yybegin(OTHERWISE_STEP); return FlowlaTypes.STEP_KEYWORD; }
}



({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }