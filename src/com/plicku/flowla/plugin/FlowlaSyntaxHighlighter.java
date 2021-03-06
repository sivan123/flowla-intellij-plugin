package com.plicku.flowla.plugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import com.plicku.flowla.plugin.lexer.FlowlaLexerUtil;
import com.plicku.flowla.plugin.psi.FlowlaTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.plicku.flowla.plugin.psi.FlowlaTypes.*;

public class FlowlaSyntaxHighlighter extends SyntaxHighlighterBase{
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("STEP_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STEP_NAME =
            createTextAttributesKey("STEP_NAME", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
    public static final TextAttributesKey STEP_DATA =
            createTextAttributesKey("STEP_DATA", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] STEP_DATA_KEYS = new TextAttributesKey[]{STEP_DATA};
    private static final TextAttributesKey[] STEP_KEYWORDS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] NAME = new TextAttributesKey[]{STEP_NAME};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlowlaLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {


        if (FlowlaLexerUtil.isKeyWord(tokenType)) {
            return STEP_KEYWORDS;
        } else if (STEP_NAME.equals(tokenType)) {
            return NAME;
        } else if (COMMENT.equals(tokenType)) {
            return COMMENT_KEYS;
        } else if (BAD_CHARACTER.equals(tokenType)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
