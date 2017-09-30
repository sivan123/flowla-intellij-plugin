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

public class FlowlaStepImpl extends ASTWrapperPsiElement implements FlowlaStep {

  public FlowlaStepImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlowlaVisitor visitor) {
    visitor.visitStep(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlowlaVisitor) accept((FlowlaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FlowlaComment getComment() {
    return findNotNullChildByClass(FlowlaComment.class);
  }

  @Override
  @NotNull
  public List<FlowlaEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlowlaEol.class);
  }

  @Override
  @NotNull
  public FlowlaKeywordSpace getKeywordSpace() {
    return findNotNullChildByClass(FlowlaKeywordSpace.class);
  }

  @Override
  @NotNull
  public FlowlaLineToEol getLineToEol() {
    return findNotNullChildByClass(FlowlaLineToEol.class);
  }

  @Override
  @Nullable
  public FlowlaMultilineArg getMultilineArg() {
    return findChildByClass(FlowlaMultilineArg.class);
  }

  @Override
  @NotNull
  public FlowlaStepKeyword getStepKeyword() {
    return findNotNullChildByClass(FlowlaStepKeyword.class);
  }

  @Override
  @NotNull
  public FlowlaWhite getWhite() {
    return findNotNullChildByClass(FlowlaWhite.class);
  }

}
