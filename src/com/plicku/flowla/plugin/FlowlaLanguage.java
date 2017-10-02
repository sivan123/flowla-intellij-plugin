package com.plicku.flowla.plugin;


import com.intellij.lang.Language;

public class FlowlaLanguage extends Language {
    public static final FlowlaLanguage INSTANCE = new FlowlaLanguage();

    private FlowlaLanguage() {
        super("Flowla");
    }
}
