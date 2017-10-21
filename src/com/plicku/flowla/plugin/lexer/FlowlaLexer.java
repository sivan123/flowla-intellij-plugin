package com.plicku.flowla.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.plicku.flowla.plugin.psi.FlowlaTypes;


import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.intellij.psi.CustomHighlighterTokenType.WHITESPACE;

public class FlowlaLexer implements FlexLexer {

  private Reader zzReader;
  private int zzLexicalState;
  private int zzMarkedPos;
  private int zzStartRead;
  private CharSequence zzBuffer;
  private int zzCurrentPos;
  private boolean zzAtEOF;
  private boolean zzAtBOL;
  private int zzEndRead;



  private final static int INITAL_STATE=0;
  private final static int GIVEN_STATE=1;
  private final static int THEN_STATE=2;
  private final static int STEPDATA_STATE=3;


  private static Map<Integer,List<Integer>> stateMap = new HashMap<>();
  private static final String GIVEN_KW="Given ";
  private static final String THEN_KW="Then ";
  private static final String IF_KW="If ";

  private static final Pattern keywordPattern = Pattern.compile("(?m)^\\s*(Given |Then |And |For Each |If |Else If)");


  static {
    stateMap.put(INITAL_STATE, Arrays.asList(GIVEN_STATE,THEN_STATE));
    stateMap.put(GIVEN_STATE, Arrays.asList(STEPDATA_STATE));
    stateMap.put(THEN_STATE, Arrays.asList(STEPDATA_STATE));
  }

  private boolean zzEOFDone;

  public FlowlaLexer(java.io.Reader in) {
    this.zzReader = in;
  }
  @Override
  public void yybegin(int newState) {
    zzLexicalState = newState;
  }

  @Override
  public int yystate() {
    return zzLexicalState;
  }

  @Override
  public int getTokenStart() {
    return zzStartRead;
  }

  @Override
  public int getTokenEnd() {
    return getTokenStart() + yylength();

  }

  private boolean zzRefill() throws java.io.IOException {
    return true;
  }

  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }

  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }

  @Override
  public IElementType advance() throws IOException {
    System.out.println("Advance called.. zzbuffer"+zzBuffer.length()+ "  currPos "+zzCurrentPos+" end "+zzEndRead );
    try {

      zzStartRead=zzCurrentPos;

      IElementType returnType = TokenType.BAD_CHARACTER;
      boolean startedReadingChars = false;


      if (zzCurrentPos == zzEndRead ) {
        zzStartRead=zzCurrentPos;
        System.out.println("Returning type null Token " + yytext());
        return null;
      }

      while (zzCurrentPos < zzEndRead) {
        if (zzEndRead == 0) {
          return TokenType.WHITE_SPACE;
        }
        if (zzLexicalState == INITAL_STATE) {
          if (!startedReadingChars) {
            if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
              startedReadingChars = true;
              zzStartRead = zzCurrentPos;
            }
          } else {
            if (isSame(zzBuffer.subSequence(zzStartRead, zzCurrentPos), GIVEN_KW)) {
              zzMarkedPos = zzCurrentPos;
              zzLexicalState = GIVEN_STATE;
              returnType = FlowlaTypes.GIVEN_KW;
              break;
            } else if (isSame(zzBuffer.subSequence(zzStartRead, zzCurrentPos), THEN_KW)) {
              zzMarkedPos = zzCurrentPos;
              zzLexicalState = THEN_STATE;
              returnType = FlowlaTypes.THEN_KW;
              break;
            }
          }
        } else if (zzLexicalState == GIVEN_STATE || zzLexicalState == THEN_STATE) {
          if (!startedReadingChars) {
            if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
              zzStartRead = zzCurrentPos;
              startedReadingChars = true;
            }
          } else if (zzCurrentPos == zzEndRead || zzBuffer.charAt(zzCurrentPos) == '\n') {
            zzMarkedPos = zzCurrentPos;
            //check step data present
            if (hasStepData())
              zzLexicalState = STEPDATA_STATE;
            else
              zzLexicalState = INITAL_STATE;

            returnType = FlowlaTypes.STEPNAME;
            break;
          }
        } else if (zzLexicalState == STEPDATA_STATE) {
          if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
            zzStartRead = zzCurrentPos;
            zzCurrentPos = zzMarkedPos = endIndexOfStepData();
            zzLexicalState = INITAL_STATE;
            returnType = FlowlaTypes.MULTILINE_ARG;
            break;
          }


        }

        zzCurrentPos++;
        if(zzCurrentPos==zzEndRead)
          zzMarkedPos=zzCurrentPos;

      }


      System.out.println("zzStartRead = "+zzStartRead+" zzMarkedPos = "+ zzMarkedPos);
      System.out.println("Returning type " + returnType + " Token " + yytext());

      return returnType;
    }catch (IndexOutOfBoundsException e)
    {
      e.printStackTrace();
      System.out.println("zzbufferlenth = "+zzBuffer.length()+" currpos "+zzCurrentPos+" zendread "+zzEndRead);
      return null;
    }
  }

  @Override
  public void reset(CharSequence charSequence, int start, int end, int initialState) {
    System.out.println("Reset called as start = "+start+" end = "+end+" initialState "+initialState+" charSequence "+charSequence);
    zzBuffer = charSequence;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);

  }

  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;

    }
  }

  private static boolean isSame(CharSequence s, CharSequence t) {
    int i = 0;

    while (i < s.length() && i < t.length()) {
      char a = s.charAt(i);
      char b = t.charAt(i);

      int diff = a - b;

      if (diff != 0) {
        return false;
      }
      i++;
    }
    return s.length() - t.length() == 0;
  }

  private boolean iswhitespace(Character c)
  {
    if(zzBuffer.charAt(zzCurrentPos) == '\n' || zzBuffer.charAt(zzCurrentPos) == '\r' || zzBuffer.charAt(zzCurrentPos) == '\t' || zzBuffer.charAt(zzCurrentPos) == ' ')
    {
      return true;
    }
    return false;
  }

  private int endIndexOfStepData()
  {
    String text = zzBuffer.subSequence(zzCurrentPos,zzEndRead).toString();
    Matcher matcher=keywordPattern.matcher(text);
    while (matcher.find())
    {
      return zzCurrentPos+matcher.start();
    }
    return zzEndRead;
  }
  private boolean hasStepData()
  {
    return !"".equals(zzBuffer.subSequence(zzCurrentPos,endIndexOfStepData()).toString().trim());
  }

}