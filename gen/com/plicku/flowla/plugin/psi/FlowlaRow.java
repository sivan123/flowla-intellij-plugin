// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlowlaRow extends PsiElement {

  @NotNull
  List<FlowlaCell> getCellList();

  @NotNull
  FlowlaEol getEol();

  @NotNull
  List<FlowlaSpace> getSpaceList();

}
