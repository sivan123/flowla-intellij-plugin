package com.plicku.flowla.plugin.grammer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.plicku.flowla.plugin.psi.FlowlaTypes.*;

%%

%{
  public FlowlaLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class FlowlaLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+


%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "eof"              { return EOF; }


}

[^] { return BAD_CHARACTER; }
