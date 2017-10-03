// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.plicku.flowla.plugin.impl.*;

public interface FlowlaTypes {

  IElementType STEP = new FlowlaElementType("STEP");
  IElementType STEPS = new FlowlaElementType("STEPS");

  IElementType COMMENT = new FlowlaTokenType("COMMENT");
  IElementType CRLF = new FlowlaTokenType("CRLF");
  IElementType MULTILINE_ARG = new FlowlaTokenType("multiline_arg");
  IElementType STEPNAME = new FlowlaTokenType("stepname");
  IElementType STEP_KEYWORD = new FlowlaTokenType("step_keyword");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == STEP) {
        return new FlowlaStepImpl(node);
      }
      else if (type == STEPS) {
        return new FlowlaStepsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
