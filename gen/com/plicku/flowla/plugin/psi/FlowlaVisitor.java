// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class FlowlaVisitor extends PsiElementVisitor {

  public void visitStep(@NotNull FlowlaStep o) {
    visitPsiElement(o);
  }

  public void visitSteps(@NotNull FlowlaSteps o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
