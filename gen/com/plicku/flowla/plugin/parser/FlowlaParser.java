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
    if (t == CELL) {
      r = cell(b, 0);
    }
    else if (t == CLOSE_PY_STRING) {
      r = close_py_string(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == COMMENT_LINE) {
      r = comment_line(b, 0);
    }
    else if (t == EOL) {
      r = eol(b, 0);
    }
    else if (t == KEYWORD_SPACE) {
      r = keyword_space(b, 0);
    }
    else if (t == LINE_TO_EOL) {
      r = line_to_eol(b, 0);
    }
    else if (t == LINES_TO_KEYWORD) {
      r = lines_to_keyword(b, 0);
    }
    else if (t == MULTILINE_ARG) {
      r = multiline_arg(b, 0);
    }
    else if (t == OPEN_PY_STRING) {
      r = open_py_string(b, 0);
    }
    else if (t == PY_STRING) {
      r = py_string(b, 0);
    }
    else if (t == RESERVED_WORDS_AND_SYMBOLS) {
      r = reserved_words_and_symbols(b, 0);
    }
    else if (t == ROW) {
      r = row(b, 0);
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
    else if (t == STEPS) {
      r = steps(b, 0);
    }
    else if (t == TABLE) {
      r = table(b, 0);
    }
    else if (t == WHITE) {
      r = white(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return flowFile(b, l + 1);
  }

  /* ********************************************************** */
  // '[^\r\n|]'+ '|'
  public static boolean cell(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CELL, "<cell>");
    r = cell_0(b, l + 1);
    r = r && consumeToken(b, "|");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[^\r\n|]'+
  private static boolean cell_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cell_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[^\\r\\n|]");
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, "[^\\r\\n|]")) break;
      if (!empty_element_parsed_guard_(b, "cell_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // eol space* '"""' white
  public static boolean close_py_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "close_py_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLOSE_PY_STRING, "<close py string>");
    r = eol(b, l + 1);
    r = r && close_py_string_1(b, l + 1);
    r = r && consumeToken(b, "\"\"\"");
    r = r && white(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space*
  private static boolean close_py_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "close_py_string_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "close_py_string_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (comment_line white)*
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    int c = current_position_(b);
    while (true) {
      if (!comment_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comment", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // comment_line white
  private static boolean comment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment_line(b, l + 1);
    r = r && white(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // space* '#' line_to_eol
  public static boolean comment_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_LINE, "<comment line>");
    r = comment_line_0(b, l + 1);
    r = r && consumeToken(b, "#");
    r = r && line_to_eol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space*
  private static boolean comment_line_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_line_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comment_line_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // '\r'? '\n'
  public static boolean eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EOL, "<eol>");
    r = eol_0(b, l + 1);
    r = r && consumeToken(b, "\\n");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '\r'?
  private static boolean eol_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol_0")) return false;
    consumeToken(b, "\\r");
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean flowFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flowFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flowFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // comment|steps|lines_to_keyword
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    if (!r) r = steps(b, l + 1);
    if (!r) r = lines_to_keyword(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ' '
  public static boolean keyword_space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword_space")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD_SPACE, "<keyword space>");
    r = consumeToken(b, " ");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (!eol .)*
  public static boolean line_to_eol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_to_eol")) return false;
    Marker m = enter_section_(b, l, _NONE_, LINE_TO_EOL, "<line to eol>");
    int c = current_position_(b);
    while (true) {
      if (!line_to_eol_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "line_to_eol", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !eol .
  private static boolean line_to_eol_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_to_eol_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (!(eol space* reserved_words_and_symbols) .)*
  public static boolean lines_to_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_to_keyword")) return false;
    Marker m = enter_section_(b, l, _NONE_, LINES_TO_KEYWORD, "<lines to keyword>");
    int c = current_position_(b);
    while (true) {
      if (!lines_to_keyword_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lines_to_keyword", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // !(eol space* reserved_words_and_symbols) .
  private static boolean lines_to_keyword_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_to_keyword_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !lines_to_keyword_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // eol space* reserved_words_and_symbols
  private static boolean lines_to_keyword_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_to_keyword_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    r = r && lines_to_keyword_0_0_1(b, l + 1);
    r = r && reserved_words_and_symbols(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // space*
  private static boolean lines_to_keyword_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lines_to_keyword_0_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lines_to_keyword_0_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // table | py_string
  public static boolean multiline_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTILINE_ARG, "<multiline arg>");
    r = table(b, l + 1);
    if (!r) r = py_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // space* '"""' space* eol
  public static boolean open_py_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "open_py_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPEN_PY_STRING, "<open py string>");
    r = open_py_string_0(b, l + 1);
    r = r && consumeToken(b, "\"\"\"");
    r = r && open_py_string_2(b, l + 1);
    r = r && eol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space*
  private static boolean open_py_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "open_py_string_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "open_py_string_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // space*
  private static boolean open_py_string_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "open_py_string_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "open_py_string_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // open_py_string (!close_py_string .)* close_py_string
  public static boolean py_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "py_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PY_STRING, "<py string>");
    r = open_py_string(b, l + 1);
    r = r && py_string_1(b, l + 1);
    r = r && close_py_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!close_py_string .)*
  private static boolean py_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "py_string_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!py_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "py_string_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // !close_py_string .
  private static boolean py_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "py_string_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !close_py_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (step_keyword keyword_space) | table |  comment_line
  public static boolean reserved_words_and_symbols(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reserved_words_and_symbols")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESERVED_WORDS_AND_SYMBOLS, "<reserved words and symbols>");
    r = reserved_words_and_symbols_0(b, l + 1);
    if (!r) r = table(b, l + 1);
    if (!r) r = comment_line(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // step_keyword keyword_space
  private static boolean reserved_words_and_symbols_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reserved_words_and_symbols_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step_keyword(b, l + 1);
    r = r && keyword_space(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // space* '|' cell+ eol
  public static boolean row(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ROW, "<row>");
    r = row_0(b, l + 1);
    r = r && consumeToken(b, "|");
    r = r && row_2(b, l + 1);
    r = r && eol(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // space*
  private static boolean row_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "row_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // cell+
  private static boolean row_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "row_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = cell(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!cell(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "row_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ' ' | '\t'
  public static boolean space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPACE, "<space>");
    r = consumeToken(b, " ");
    if (!r) r = consumeToken(b, "\\t");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // comment step_keyword keyword_space line_to_eol (eol+ | eof) multiline_arg? white
  public static boolean step(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP, "<step>");
    r = comment(b, l + 1);
    r = r && step_keyword(b, l + 1);
    r = r && keyword_space(b, l + 1);
    r = r && line_to_eol(b, l + 1);
    r = r && step_4(b, l + 1);
    r = r && step_5(b, l + 1);
    r = r && white(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // eol+ | eof
  private static boolean step_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = step_4_0(b, l + 1);
    if (!r) r = consumeToken(b, EOF);
    exit_section_(b, m, null, r);
    return r;
  }

  // eol+
  private static boolean step_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eol(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!eol(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "step_4_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // multiline_arg?
  private static boolean step_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_5")) return false;
    multiline_arg(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'Given' | 'When' | 'Then' | 'And' | 'But'
  public static boolean step_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "step_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STEP_KEYWORD, "<step keyword>");
    r = consumeToken(b, "Given");
    if (!r) r = consumeToken(b, "When");
    if (!r) r = consumeToken(b, "Then");
    if (!r) r = consumeToken(b, "And");
    if (!r) r = consumeToken(b, "But");
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
  // row+
  public static boolean table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE, "<table>");
    r = row(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!row(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "table", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (space | eol)*
  public static boolean white(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "white")) return false;
    Marker m = enter_section_(b, l, _NONE_, WHITE, "<white>");
    int c = current_position_(b);
    while (true) {
      if (!white_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "white", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // space | eol
  private static boolean white_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "white_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = space(b, l + 1);
    if (!r) r = eol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
