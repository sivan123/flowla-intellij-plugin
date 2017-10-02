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
    if (t == EOL) {
      r = eol(b, 0);
    }
    else if (t == SPACE) {
      r = space(b, 0);
    }
    else if (t == STEP) {
      r = step(b, 0);
    }
    else if (t == STEP_KEYWORD) {
      r = step_keyword(b, 0);
    }
    else if (t == STEPNAME) {
      r = stepname(b, 0);
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
    return simpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // 'regexp:\r?\n'
  public static boolean eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EOL, "<eol>");
    r = consumeToken(b, "regexp:\\r?\\n");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // steps|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = steps(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ' ' | 'regex:\t'
  public static boolean space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPACE, "<space>");
    r = consumeToken(b, " ");
    if (!r) r = consumeToken(b, "regex:\\t");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // space* step_keyword stepname? (eol+ | eof) multiline_arg? (space | eol)*
  public static boolean step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP, "<step>");
    r = step_0(b, l + 1);
    r = r && step_keyword(b, l + 1);
    r = r && step_2(b, l + 1);
    r = r && step_3(b, l + 1);
    r = r && step_4(b, l + 1);
    r = r && step_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space*
  private static boolean step_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "step_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // stepname?
  private static boolean step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_2")) return false;
    stepname(b, l + 1);
    return true;
  }

  // eol+ | eof
  private static boolean step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step_3_0(b, l + 1);
    if (!r) r = consumeToken(b, EOF);
    exit_section_(b, m, null, r);
    return r;
  }

  // eol+
  private static boolean step_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "step_3_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // multiline_arg?
  private static boolean step_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_4")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  // (space | eol)*
  private static boolean step_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!step_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "step_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // space | eol
  private static boolean step_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = space(b, l + 1);
    if (!r) r = eol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'Given ' | 'Then ' | 'For Each ' | 'But ' | 'And '
  public static boolean step_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP_KEYWORD, "<step keyword>");
    r = consumeToken(b, "Given ");
    if (!r) r = consumeToken(b, "Then ");
    if (!r) r = consumeToken(b, "For Each ");
    if (!r) r = consumeToken(b, "But ");
    if (!r) r = consumeToken(b, "And ");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (!eol )*
  public static boolean stepname(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stepname")) return false;
    Marker m = enter_section_(b, l, _NONE_, STEPNAME, "<stepname>");
    int c = current_position_(b);
    while (true) {
      if (!stepname_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stepname", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !eol
  private static boolean stepname_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stepname_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
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
