// This is a generated file. Not intended for manual editing.
package com.plicku.flowla.plugin.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plicku.flowla.plugin.psi.FlowlaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.plicku.flowla.plugin.psi.*;

public class FlowlaPyStringImpl extends ASTWrapperPsiElement implements FlowlaPyString {

  public FlowlaPyStringImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlowlaVisitor visitor) {
    visitor.visitPyString(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlowlaVisitor) accept((FlowlaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FlowlaClosePyString getClosePyString() {
    return findNotNullChildByClass(FlowlaClosePyString.class);
  }

  @Override
  @NotNull
  public FlowlaOpenPyString getOpenPyString() {
    return findNotNullChildByClass(FlowlaOpenPyString.class);
  }

}
