// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlowlaWhite extends PsiElement {

  @NotNull
  List<FlowlaEol> getEolList();

  @NotNull
  List<FlowlaSpace> getSpaceList();

}