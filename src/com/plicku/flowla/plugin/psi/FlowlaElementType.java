package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.plicku.flowla.plugin.FlowlaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FlowlaElementType extends IElementType {
    public FlowlaElementType(@NotNull @NonNls String debugName) {
        super(debugName, FlowlaLanguage.INSTANCE);
    }
}
