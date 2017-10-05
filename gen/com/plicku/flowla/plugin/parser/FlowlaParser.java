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
    if (t == AND_STEP) {
      r = and_step(b, 0);
    }
    else if (t == BUT_STEP) {
      r = but_step(b, 0);
    }
    else if (t == ELSEIF_STEP) {
      r = elseif_step(b, 0);
    }
    else if (t == FOREACH_STEP) {
      r = foreach_step(b, 0);
    }
    else if (t == FORWHILE_STEP) {
      r = forwhile_step(b, 0);
    }
    else if (t == GIVEN_STEP) {
      r = given_step(b, 0);
    }
    else if (t == IF_STEP) {
      r = if_step(b, 0);
    }
    else if (t == OTHERWISE_STEP) {
      r = otherwise_step(b, 0);
    }
    else if (t == STEP) {
      r = step(b, 0);
    }
    else if (t == STEP_KEYWORD) {
      r = step_keyword(b, 0);
    }
    else if (t == STEPS) {
      r = steps(b, 0);
    }
    else if (t == THEN_STEP) {
      r = then_step(b, 0);
    }
    else if (t == WHEN_STEP) {
      r = when_step(b, 0);
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
  // and_kw stepname [multiline_arg]
  public static boolean and_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_step")) return false;
    if (!nextTokenIs(b, AND_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AND_KW, STEPNAME);
    r = r && and_step_2(b, l + 1);
    exit_section_(b, m, AND_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean and_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  /* ********************************************************** */
  // but_kw stepname [multiline_arg]
  public static boolean but_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "but_step")) return false;
    if (!nextTokenIs(b, BUT_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUT_KW, STEPNAME);
    r = r && but_step_2(b, l + 1);
    exit_section_(b, m, BUT_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean but_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "but_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  /* ********************************************************** */
  // elseif_kw stepname [multiline_arg] [step*]
  public static boolean elseif_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_step")) return false;
    if (!nextTokenIs(b, ELSEIF_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSEIF_KW, STEPNAME);
    r = r && elseif_step_2(b, l + 1);
    r = r && elseif_step_3(b, l + 1);
    exit_section_(b, m, ELSEIF_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean elseif_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  // [step*]
  private static boolean elseif_step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_step_3")) return false;
    elseif_step_3_0(b, l + 1);
    return true;
  }

  // step*
  private static boolean elseif_step_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseif_step_3_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elseif_step_3_0", c)) break;
      c = current_position_(b);
    }
    return true;
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
  // foreach_kw stepname [multiline_arg] [step+] endfor_kw
  public static boolean foreach_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreach_step")) return false;
    if (!nextTokenIs(b, FOREACH_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOREACH_KW, STEPNAME);
    r = r && foreach_step_2(b, l + 1);
    r = r && foreach_step_3(b, l + 1);
    r = r && consumeToken(b, ENDFOR_KW);
    exit_section_(b, m, FOREACH_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean foreach_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreach_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  // [step+]
  private static boolean foreach_step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreach_step_3")) return false;
    foreach_step_3_0(b, l + 1);
    return true;
  }

  // step+
  private static boolean foreach_step_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreach_step_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "foreach_step_3_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // forwhile_kw stepname [multiline_arg] [step+] endfor_kw
  public static boolean forwhile_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwhile_step")) return false;
    if (!nextTokenIs(b, FORWHILE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FORWHILE_KW, STEPNAME);
    r = r && forwhile_step_2(b, l + 1);
    r = r && forwhile_step_3(b, l + 1);
    r = r && consumeToken(b, ENDFOR_KW);
    exit_section_(b, m, FORWHILE_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean forwhile_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwhile_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  // [step+]
  private static boolean forwhile_step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwhile_step_3")) return false;
    forwhile_step_3_0(b, l + 1);
    return true;
  }

  // step+
  private static boolean forwhile_step_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forwhile_step_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "forwhile_step_3_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // given_kw stepname [multiline_arg]
  public static boolean given_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "given_step")) return false;
    if (!nextTokenIs(b, GIVEN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GIVEN_KW, STEPNAME);
    r = r && given_step_2(b, l + 1);
    exit_section_(b, m, GIVEN_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean given_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "given_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  /* ********************************************************** */
  // if_kw stepname [multiline_arg]
  //                 [step*]
  //              [elseif_step*]
  //              [otherwise_step]
  //              endif_kw
  public static boolean if_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step")) return false;
    if (!nextTokenIs(b, IF_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KW, STEPNAME);
    r = r && if_step_2(b, l + 1);
    r = r && if_step_3(b, l + 1);
    r = r && if_step_4(b, l + 1);
    r = r && if_step_5(b, l + 1);
    r = r && consumeToken(b, ENDIF_KW);
    exit_section_(b, m, IF_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean if_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  // [step*]
  private static boolean if_step_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_3")) return false;
    if_step_3_0(b, l + 1);
    return true;
  }

  // step*
  private static boolean if_step_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_3_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_step_3_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [elseif_step*]
  private static boolean if_step_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_4")) return false;
    if_step_4_0(b, l + 1);
    return true;
  }

  // elseif_step*
  private static boolean if_step_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_4_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!elseif_step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_step_4_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [otherwise_step]
  private static boolean if_step_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_step_5")) return false;
    otherwise_step(b, l + 1);
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
  // otherwise_kw [step+]
  public static boolean otherwise_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherwise_step")) return false;
    if (!nextTokenIs(b, OTHERWISE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OTHERWISE_KW);
    r = r && otherwise_step_1(b, l + 1);
    exit_section_(b, m, OTHERWISE_STEP, r);
    return r;
  }

  // [step+]
  private static boolean otherwise_step_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherwise_step_1")) return false;
    otherwise_step_1_0(b, l + 1);
    return true;
  }

  // step+
  private static boolean otherwise_step_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherwise_step_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!step(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "otherwise_step_1_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // given_step|then_step|when_step|and_step|but_step|if_step|foreach_step|forwhile_step
  public static boolean step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP, "<step>");
    r = given_step(b, l + 1);
    if (!r) r = then_step(b, l + 1);
    if (!r) r = when_step(b, l + 1);
    if (!r) r = and_step(b, l + 1);
    if (!r) r = but_step(b, l + 1);
    if (!r) r = if_step(b, l + 1);
    if (!r) r = foreach_step(b, l + 1);
    if (!r) r = forwhile_step(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // given_kw | then_kw |when_kw |and_kw |but_kw|if_kw|endif_kw|elseif_kw|otherwise_kw|foreach_kw|forwhile_kw
  public static boolean step_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP_KEYWORD, "<step keyword>");
    r = consumeToken(b, GIVEN_KW);
    if (!r) r = consumeToken(b, THEN_KW);
    if (!r) r = consumeToken(b, WHEN_KW);
    if (!r) r = consumeToken(b, AND_KW);
    if (!r) r = consumeToken(b, BUT_KW);
    if (!r) r = consumeToken(b, IF_KW);
    if (!r) r = consumeToken(b, ENDIF_KW);
    if (!r) r = consumeToken(b, ELSEIF_KW);
    if (!r) r = consumeToken(b, OTHERWISE_KW);
    if (!r) r = consumeToken(b, FOREACH_KW);
    if (!r) r = consumeToken(b, FORWHILE_KW);
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

  /* ********************************************************** */
  // then_kw stepname [multiline_arg]
  public static boolean then_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "then_step")) return false;
    if (!nextTokenIs(b, THEN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, THEN_KW, STEPNAME);
    r = r && then_step_2(b, l + 1);
    exit_section_(b, m, THEN_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean then_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "then_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

  /* ********************************************************** */
  // when_kw stepname [multiline_arg]
  public static boolean when_step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_step")) return false;
    if (!nextTokenIs(b, WHEN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHEN_KW, STEPNAME);
    r = r && when_step_2(b, l + 1);
    exit_section_(b, m, WHEN_STEP, r);
    return r;
  }

  // [multiline_arg]
  private static boolean when_step_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_step_2")) return false;
    consumeToken(b, MULTILINE_ARG);
    return true;
  }

}
