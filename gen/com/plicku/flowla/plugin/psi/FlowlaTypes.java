// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.plicku.flowla.plugin.impl.*;

public interface FlowlaTypes {

  IElementType EOL = new FlowlaElementType("EOL");
  IElementType SPACE = new FlowlaElementType("SPACE");
  IElementType STEP = new FlowlaElementType("STEP");
  IElementType STEPNAME = new FlowlaElementType("STEPNAME");
  IElementType STEPS = new FlowlaElementType("STEPS");
  IElementType STEP_KEYWORD = new FlowlaElementType("STEP_KEYWORD");

  IElementType COMMENT = new FlowlaTokenType("COMMENT");
  IElementType CRLF = new FlowlaTokenType("CRLF");
  IElementType EOF = new FlowlaTokenType("eof");
  IElementType MULTILINE_ARG = new FlowlaTokenType("multiline_arg");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == EOL) {
        return new FlowlaEolImpl(node);
      }
      else if (type == SPACE) {
        return new FlowlaSpaceImpl(node);
      }
      else if (type == STEP) {
        return new FlowlaStepImpl(node);
      }
      else if (type == STEPNAME) {
        return new FlowlaStepnameImpl(node);
      }
      else if (type == STEPS) {
        return new FlowlaStepsImpl(node);
      }
      else if (type == STEP_KEYWORD) {
        return new FlowlaStepKeywordImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
