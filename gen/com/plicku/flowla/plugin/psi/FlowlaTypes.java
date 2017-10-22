// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.plicku.flowla.plugin.impl.*;

public interface FlowlaTypes {

  IElementType AND_STEP = new FlowlaElementType("AND_STEP");
  IElementType BUT_STEP = new FlowlaElementType("BUT_STEP");
  IElementType ELSEIF_STEP = new FlowlaElementType("ELSEIF_STEP");
  IElementType FOREACH_STEP = new FlowlaElementType("FOREACH_STEP");
  IElementType GIVEN_STEP = new FlowlaElementType("GIVEN_STEP");
  IElementType IF_STEP = new FlowlaElementType("IF_STEP");
  IElementType OTHERWISE_STEP = new FlowlaElementType("OTHERWISE_STEP");
  IElementType REPEAT_FOR = new FlowlaElementType("REPEAT_FOR");
  IElementType REPEAT_WHILE = new FlowlaElementType("REPEAT_WHILE");
  IElementType STEP = new FlowlaElementType("STEP");
  IElementType STEPS = new FlowlaElementType("STEPS");
  IElementType STEP_KEYWORD = new FlowlaElementType("STEP_KEYWORD");
  IElementType THEN_STEP = new FlowlaElementType("THEN_STEP");
  IElementType WHEN_STEP = new FlowlaElementType("WHEN_STEP");

  IElementType AND_KW = new FlowlaTokenType("and_kw");
  IElementType BUT_KW = new FlowlaTokenType("but_kw");
  IElementType COMMENT = new FlowlaTokenType("COMMENT");
  IElementType CRLF = new FlowlaTokenType("CRLF");
  IElementType ELSEIF_KW = new FlowlaTokenType("elseif_kw");
  IElementType ENDFOR_KW = new FlowlaTokenType("endfor_kw");
  IElementType ENDIF_KW = new FlowlaTokenType("endif_kw");
  IElementType ENDREPEAT_KW = new FlowlaTokenType("endrepeat_kw");
  IElementType FOREACH_KW = new FlowlaTokenType("foreach_kw");
  IElementType FORWHILE_KW = new FlowlaTokenType("forwhile_kw");
  IElementType GIVEN_KW = new FlowlaTokenType("given_kw");
  IElementType IF_KW = new FlowlaTokenType("if_kw");
  IElementType MULTILINE_ARG = new FlowlaTokenType("multiline_arg");
  IElementType OTHERWISE_KW = new FlowlaTokenType("otherwise_kw");
  IElementType REPEATEFOR_KW = new FlowlaTokenType("repeatefor_kw");
  IElementType REPEATWHILE_KW = new FlowlaTokenType("repeatwhile_kw");
  IElementType STEPNAME = new FlowlaTokenType("stepname");
  IElementType THEN_KW = new FlowlaTokenType("then_kw");
  IElementType WHEN_KW = new FlowlaTokenType("when_kw");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == AND_STEP) {
        return new FlowlaAndStepImpl(node);
      }
      else if (type == BUT_STEP) {
        return new FlowlaButStepImpl(node);
      }
      else if (type == ELSEIF_STEP) {
        return new FlowlaElseifStepImpl(node);
      }
      else if (type == FOREACH_STEP) {
        return new FlowlaForeachStepImpl(node);
      }
      else if (type == GIVEN_STEP) {
        return new FlowlaGivenStepImpl(node);
      }
      else if (type == IF_STEP) {
        return new FlowlaIfStepImpl(node);
      }
      else if (type == OTHERWISE_STEP) {
        return new FlowlaOtherwiseStepImpl(node);
      }
      else if (type == REPEAT_FOR) {
        return new FlowlaRepeatForImpl(node);
      }
      else if (type == REPEAT_WHILE) {
        return new FlowlaRepeatWhileImpl(node);
      }
      else if (type == STEP) {
        return new FlowlaStepImpl(node);
      }
      else if (type == STEPS) {
        return new FlowlaStepsImpl(node);
      }
      else if (type == STEP_KEYWORD) {
        return new FlowlaStepKeywordImpl(node);
      }
      else if (type == THEN_STEP) {
        return new FlowlaThenStepImpl(node);
      }
      else if (type == WHEN_STEP) {
        return new FlowlaWhenStepImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
