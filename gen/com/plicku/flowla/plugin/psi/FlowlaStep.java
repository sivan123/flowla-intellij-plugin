// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlowlaStep extends PsiElement {

  @NotNull
  FlowlaComment getComment();

  @NotNull
  List<FlowlaEol> getEolList();

  @NotNull
  FlowlaKeywordSpace getKeywordSpace();

  @NotNull
  FlowlaLineToEol getLineToEol();

  @Nullable
  FlowlaMultilineArg getMultilineArg();

  @NotNull
  FlowlaStepKeyword getStepKeyword();

  @NotNull
  FlowlaWhite getWhite();

}
