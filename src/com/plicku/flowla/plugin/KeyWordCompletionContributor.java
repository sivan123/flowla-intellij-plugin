package com.plicku.flowla.plugin;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.plicku.flowla.plugin.lexer.FlowlaLexerUtil;
import org.jetbrains.annotations.NotNull;

public class KeyWordCompletionContributor extends CompletionContributor {

    public KeyWordCompletionContributor() {

        FlowlaLexerUtil.getStepTokenPropertiesList().forEach(stepTokenProperties -> {

            extend(CompletionType.BASIC,
                    PlatformPatterns.psiElement(stepTokenProperties.getTokenType()).withLanguage(FlowlaLanguage.INSTANCE),
                    new CompletionProvider<CompletionParameters>() {
                        public void addCompletions(@NotNull CompletionParameters parameters,
                                                   ProcessingContext context,
                                                   @NotNull CompletionResultSet resultSet) {
                            resultSet.addElement(LookupElementBuilder.create(stepTokenProperties.getKeyword()));
                        }
                    }
            );

        });

    }

}
