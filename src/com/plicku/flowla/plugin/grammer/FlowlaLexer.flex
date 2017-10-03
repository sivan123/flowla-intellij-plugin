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


STEPNAME=[^\r\n]*
//#STEP={STEP_KEYWORD}{STEPNAME}
%state STEP

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return FlowlaTypes.COMMENT; }
<YYINITIAL> {STEP_KEYWORD}                                  { yybegin(STEP); return FlowlaTypes.STEP_KEYWORD; }

<STEP> {
        {STEPNAME}                                          {return FlowlaTypes.STEPNAME;}
}
({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }