// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlowlaStep extends PsiElement {

  @Nullable
  FlowlaAndStep getAndStep();

  @Nullable
  FlowlaButStep getButStep();

  @Nullable
  FlowlaForeachStep getForeachStep();

  @Nullable
  FlowlaForwhileStep getForwhileStep();

  @Nullable
  FlowlaGivenStep getGivenStep();

  @Nullable
  FlowlaIfStep getIfStep();

  @Nullable
  FlowlaThenStep getThenStep();

  @Nullable
  FlowlaWhenStep getWhenStep();

}
