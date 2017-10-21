package com.plicku.flowla.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.IntIntHashMap;

public class FlowlaParserUtil extends GeneratedParserUtilBase {
    private static class ParserState {
        enum PrimaryMode {
            NORMAL, TYPE_DEF, TYPE_DESC
        }

        private PsiBuilder builder;
        private int currentIndent = 0;
        private int pragmaCount = 0;
        private PrimaryMode primaryMode = PrimaryMode.NORMAL;
        private int semiStmtListCount = 0;

        private IntIntHashMap tokIndentCache = new IntIntHashMap();

        ParserState(PsiBuilder builder) {
            this.builder = builder;
        }

        private String getPrecedingWhiteSpace() {
            int wsOffset = 0;
            while (builder.rawLookup(wsOffset - 1) == TokenType.WHITE_SPACE)
                --wsOffset;
            int wsStart = builder.rawTokenTypeStart(wsOffset);
            return builder.getOriginalText().subSequence(wsStart, builder.getCurrentOffset()).toString();
        }

        private String getFollowingWhiteSpace() {
            int nonWsOffset = 1;
            while (builder.rawLookup(nonWsOffset) == TokenType.WHITE_SPACE)
                ++nonWsOffset;
            int nonWsStart = builder.rawTokenTypeStart(nonWsOffset);
            return builder.getOriginalText().subSequence(builder.rawTokenTypeStart(1), nonWsStart).toString();
        }

        int getSpacesLeft() {
            return getPrecedingWhiteSpace().length();
        }

        int getSpacesRight() {
            return getFollowingWhiteSpace().length();
        }

        int getTokenIndent() {
            int tokStart = builder.getCurrentOffset();
            if (tokIndentCache.containsKey(tokStart))
                return tokIndentCache.get(tokStart);

            int indent = -1;
            String ws = getPrecedingWhiteSpace();
            int nlPos = ws.lastIndexOf('\n');
            if (nlPos != -1)
                indent = ws.length() - nlPos - 1;
            tokIndentCache.put(tokStart, indent);
            return indent;
        }
    }

    private static Key<ParserState> parserStateKey = new Key<>("parser-state");

    private static ParserState getParserState(PsiBuilder builder) {
        return builder.getUserData(parserStateKey);
    }


    public static boolean startOfKewWordEq(PsiBuilder builder, int level) {
        String origtext = builder.getOriginalText().toString();
        System.out.println("Token is "+origtext);
        return true;
//        ParserState state = getParserState(builder);
//        return state..getTokenIndent() == state.currentIndent;
    }


}