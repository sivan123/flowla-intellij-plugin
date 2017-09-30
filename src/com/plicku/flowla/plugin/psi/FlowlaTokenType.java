package com.plicku.flowla.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.plicku.flowla.plugin.FlowlaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FlowlaTokenType extends IElementType{
    public FlowlaTokenType(@NotNull @NonNls String debugName) {
        super(debugName, FlowlaLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "FlowlaTokenType."+super.toString();
    }
}
