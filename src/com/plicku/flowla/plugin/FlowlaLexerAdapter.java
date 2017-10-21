package com.plicku.flowla.plugin;

import com.intellij.lexer.FlexAdapter;
import com.plicku.flowla.plugin.lexer.FlowlaLexer;


import java.io.Reader;

public class FlowlaLexerAdapter extends FlexAdapter {
    public FlowlaLexerAdapter() {

        super(new FlowlaLexer((Reader) null));
    }
}
