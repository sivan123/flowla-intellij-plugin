// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.plicku.flowla.plugin.impl.*;

public interface FlowlaTypes {

  IElementType CELL = new FlowlaElementType("CELL");
  IElementType CLOSE_PY_STRING = new FlowlaElementType("CLOSE_PY_STRING");
  IElementType COMMENT = new FlowlaElementType("COMMENT");
  IElementType COMMENT_LINE = new FlowlaElementType("COMMENT_LINE");
  IElementType EOL = new FlowlaElementType("EOL");
  IElementType KEYWORD_SPACE = new FlowlaElementType("KEYWORD_SPACE");
  IElementType LINES_TO_KEYWORD = new FlowlaElementType("LINES_TO_KEYWORD");
  IElementType LINE_TO_EOL = new FlowlaElementType("LINE_TO_EOL");
  IElementType MULTILINE_ARG = new FlowlaElementType("MULTILINE_ARG");
  IElementType OPEN_PY_STRING = new FlowlaElementType("OPEN_PY_STRING");
  IElementType PY_STRING = new FlowlaElementType("PY_STRING");
  IElementType RESERVED_WORDS_AND_SYMBOLS = new FlowlaElementType("RESERVED_WORDS_AND_SYMBOLS");
  IElementType ROW = new FlowlaElementType("ROW");
  IElementType SPACE = new FlowlaElementType("SPACE");
  IElementType STEP = new FlowlaElementType("STEP");
  IElementType STEPS = new FlowlaElementType("STEPS");
  IElementType STEP_KEYWORD = new FlowlaElementType("STEP_KEYWORD");
  IElementType TABLE = new FlowlaElementType("TABLE");
  IElementType WHITE = new FlowlaElementType("WHITE");

  IElementType EOF = new FlowlaTokenType("eof");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CELL) {
        return new FlowlaCellImpl(node);
      }
      else if (type == CLOSE_PY_STRING) {
        return new FlowlaClosePyStringImpl(node);
      }
      else if (type == COMMENT) {
        return new FlowlaCommentImpl(node);
      }
      else if (type == COMMENT_LINE) {
        return new FlowlaCommentLineImpl(node);
      }
      else if (type == EOL) {
        return new FlowlaEolImpl(node);
      }
      else if (type == KEYWORD_SPACE) {
        return new FlowlaKeywordSpaceImpl(node);
      }
      else if (type == LINES_TO_KEYWORD) {
        return new FlowlaLinesToKeywordImpl(node);
      }
      else if (type == LINE_TO_EOL) {
        return new FlowlaLineToEolImpl(node);
      }
      else if (type == MULTILINE_ARG) {
        return new FlowlaMultilineArgImpl(node);
      }
      else if (type == OPEN_PY_STRING) {
        return new FlowlaOpenPyStringImpl(node);
      }
      else if (type == PY_STRING) {
        return new FlowlaPyStringImpl(node);
      }
      else if (type == RESERVED_WORDS_AND_SYMBOLS) {
        return new FlowlaReservedWordsAndSymbolsImpl(node);
      }
      else if (type == ROW) {
        return new FlowlaRowImpl(node);
      }
      else if (type == SPACE) {
        return new FlowlaSpaceImpl(node);
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
      else if (type == TABLE) {
        return new FlowlaTableImpl(node);
      }
      else if (type == WHITE) {
        return new FlowlaWhiteImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
