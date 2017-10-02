package com.plicku.flowla.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FlowlaFileType extends LanguageFileType {
    public static final FlowlaFileType INSTANCE = new FlowlaFileType();
    private FlowlaFileType() {
        super(FlowlaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Flowla file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Flowla language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "flowla";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return FlowlaIcons.FILE;
    }

}
