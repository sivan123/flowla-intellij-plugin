package com.plicku.flowla.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.plicku.flowla.plugin.psi.FlowlaTypes;

import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;

import static com.plicku.flowla.plugin.lexer.FlowlaLexerUtil.*;

public class FlowlaLexer implements FlexLexer {

  private Reader zzReader;
  private int zzLexicalState;
  private String zzKeywordState;
  private int zzMarkedPos;
  private int zzStartRead;
  private CharSequence zzBuffer;
  private int zzCurrentPos;
  private boolean zzAtEOF;
  private boolean zzAtBOL;
  private int zzEndRead;





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
    System.out.println("Advance called.. zzbuffer"+zzBuffer.length()+ "  currPos "+zzCurrentPos+" end "+zzEndRead +" zzKeywordState "+zzKeywordState);
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
        if (zzLexicalState == INITIAL_STATE) {
          if (!startedReadingChars) {
            if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
              startedReadingChars = true;
              zzStartRead = zzCurrentPos;
            }
          } else {
            StepTokenProperties stepTokenProperties = getStepTokenProperites(zzBuffer.subSequence(zzStartRead, zzCurrentPos).toString());
            if (stepTokenProperties!=null) {
              zzMarkedPos = zzCurrentPos;
              zzLexicalState = stepTokenProperties.getLexstate();
              zzKeywordState = stepTokenProperties.getKeyword();
              returnType = stepTokenProperties.getTokenType();
              break;
            }
          }
        } else if (zzLexicalState == KEYWORD_STATE) {
          StepTokenProperties stepTokenProperties= getStepTokenProperites(zzKeywordState);
          System.out.println("keyword state "+zzKeywordState+" zzLexicalState= "+zzLexicalState+" stepTokenProperties.isKeywordWithStepname() ="+stepTokenProperties.isKeywordWithStepname());
          if(stepTokenProperties.isKeywordWithStepname()) {
            if (!startedReadingChars) {
              if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
                zzStartRead = zzCurrentPos;
                startedReadingChars = true;
              }
            } else if (zzCurrentPos == zzEndRead || zzBuffer.charAt(zzCurrentPos) == '\n') {
              zzMarkedPos = zzCurrentPos;
              //check step data present
              if (stepTokenProperties.isStepDataPossible() && hasStepData())
                zzLexicalState = STEP_DATA_STATE;
              else
                zzLexicalState = INITIAL_STATE;

              returnType = FlowlaTypes.STEPNAME;
              break;
            }
          } else {
              zzLexicalState = INITIAL_STATE;
              zzKeywordState = null;
              zzCurrentPos--;
          }

        } else if (zzLexicalState == STEP_DATA_STATE) {
          if (!iswhitespace(zzBuffer.charAt(zzCurrentPos))) {
            zzStartRead = zzCurrentPos;
            zzCurrentPos = zzMarkedPos = endIndexOfStepData();
            zzLexicalState = INITIAL_STATE;
            zzKeywordState = null;
            returnType = FlowlaTypes.MULTILINE_ARG;
            break;
          }


        }

        zzCurrentPos++;
        if(zzCurrentPos==zzEndRead)
          zzMarkedPos=zzCurrentPos;

      }

      if(isWhiteSpace(yytext()))
        returnType = TokenType.WHITE_SPACE;

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