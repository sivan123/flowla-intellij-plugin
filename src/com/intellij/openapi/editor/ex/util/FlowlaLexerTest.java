package com.intellij.openapi.editor.ex.util;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.ex.util.SegmentArrayWithData;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.text.ImmutableCharSequence;
import com.plicku.flowla.plugin.FlowlaSyntaxHighlighter;
import com.plicku.flowla.plugin.lexer.FlowlaLexer;
import org.junit.Test;

public class FlowlaLexerTest {
    SegmentArrayWithData mySegments =new SegmentArrayWithData();
    Lexer myLexer = new FlowlaSyntaxHighlighter().getHighlightingLexer();
    int myInitialState=0;
    @Test
    public void advance() throws Exception {


        String feature="Given sXXXdsASDAt\n" +
                "sadasdada\n" +
                "Then dfsdfsd\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" ;

                //"\tGiven the test ends";
       FlowlaLexer flowlaLexer = new FlowlaLexer(null);
      // flowlaLexer.reset(feature.subSequence(0,feature.length()-1),0,feature.length()-1,0);
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());
//        System.out.println(flowlaLexer.advance());
//        System.out.println(flowlaLexer.yytext());

        doSetText(feature.subSequence(0,feature.length()-1));
    }


    private void doSetText(final CharSequence text) {



        final TokenProcessor processor = createTokenProcessor(0);
        final int textLength = text.length();
        myLexer.start(text,0, textLength,  0);
        mySegments.removeAll();
        int i = 0;
        while (true) {
            final IElementType tokenType = myLexer.getTokenType();
            if (tokenType == null) break;

            int data = packData(tokenType, myLexer.getState());
            processor.addToken(i, myLexer.getTokenStart(), myLexer.getTokenEnd(), data, tokenType);
            i++;
            myLexer.advance();
        }
        processor.finish();

        if (textLength > 0 && (mySegments.mySegmentCount == 0 || mySegments.myEnds[mySegments.mySegmentCount - 1] != textLength)) {
            throw new IllegalStateException("Unexpected termination offset for lexer " + myLexer);
        }


    }

    private int packData(IElementType tokenType, int state) {
        final short idx = tokenType.getIndex();
        return state == myInitialState ? idx : -idx;
    }

    protected TokenProcessor createTokenProcessor(final int startIndex) {
        return new TokenProcessor();
    }


    protected class TokenProcessor {
        public void addToken(final int i, final int startOffset, final int endOffset, final int data, final IElementType tokenType) {
            mySegments.setElementAt(i, startOffset, endOffset, data);
        }

        public void finish() {
        }
    }



}