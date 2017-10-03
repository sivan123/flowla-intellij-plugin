// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.plicku.flowla.plugin.psi.FlowlaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FlowlaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == STEP) {
      r = step(b, 0);
    }
    else if (t == STEPS) {
      r = steps(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return flowlaFile(b, l + 1);
  }

  /* ********************************************************** */
  // item_*
  static boolean flowlaFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flowlaFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flowlaFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // steps|COMMENT|CRLF|[""]
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = steps(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = item__3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [""]
  private static boolean item__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__3")) return false;
    consumeToken(b, "");
    return true;
  }

  /* ********************************************************** */
  // [""]step_keyword [stepname] [multiline_arg]
  public static boolean step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP, "<step>");
    r = step_0(b, l + 1);
    r = r && consumeToken(b, STEP_KEYWORD);
    r = r && step_2(b, l + 1);
    r = r && step_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [""]
  private static boolean step_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_0")) return false;
    consumeToken(b, "");
    return true;
  }

  // [stepname]
  private static boolean step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_2")) return false;
    consumeToken(b, STEPNAME);
    return true;
  }

  // [multiline_arg]
  private static boolean step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_3")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  /* ********************************************************** */
  // step*
  public static boolean steps(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "steps")) return false;
    Marker m = enter_section_(b, l, _NONE_, STEPS, "<steps>");
    int c = current_position_(b);
    while (true) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "steps", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

}
