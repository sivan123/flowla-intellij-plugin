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
  @Nullable
  public FlowlaAndStep getAndStep() {
    return findChildByClass(FlowlaAndStep.class);
  }

  @Override
  @Nullable
  public FlowlaButStep getButStep() {
    return findChildByClass(FlowlaButStep.class);
  }

  @Override
  @Nullable
  public FlowlaForeachStep getForeachStep() {
    return findChildByClass(FlowlaForeachStep.class);
  }

  @Override
  @Nullable
  public FlowlaGivenStep getGivenStep() {
    return findChildByClass(FlowlaGivenStep.class);
  }

  @Override
  @Nullable
  public FlowlaIfStep getIfStep() {
    return findChildByClass(FlowlaIfStep.class);
  }

  @Override
  @Nullable
  public FlowlaRepeatFor getRepeatFor() {
    return findChildByClass(FlowlaRepeatFor.class);
  }

  @Override
  @Nullable
  public FlowlaRepeatWhile getRepeatWhile() {
    return findChildByClass(FlowlaRepeatWhile.class);
  }

  @Override
  @Nullable
  public FlowlaThenStep getThenStep() {
    return findChildByClass(FlowlaThenStep.class);
  }

  @Override
  @Nullable
  public FlowlaWhenStep getWhenStep() {
    return findChildByClass(FlowlaWhenStep.class);
  }

}
