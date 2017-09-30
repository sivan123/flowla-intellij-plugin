package com.plicku.flowla.plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.plicku.flowla.plugin.FlowlaFileType;
import com.plicku.flowla.plugin.FlowlaLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FlowlaFile extends PsiFileBase {

    public FlowlaFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, FlowlaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return FlowlaFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Flowla File";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
