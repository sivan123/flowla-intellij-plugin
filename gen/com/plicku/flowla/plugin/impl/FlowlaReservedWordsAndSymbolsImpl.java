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

public class FlowlaReservedWordsAndSymbolsImpl extends ASTWrapperPsiElement implements FlowlaReservedWordsAndSymbols {

  public FlowlaReservedWordsAndSymbolsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlowlaVisitor visitor) {
    visitor.visitReservedWordsAndSymbols(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlowlaVisitor) accept((FlowlaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FlowlaCommentLine getCommentLine() {
    return findChildByClass(FlowlaCommentLine.class);
  }

  @Override
  @Nullable
  public FlowlaKeywordSpace getKeywordSpace() {
    return findChildByClass(FlowlaKeywordSpace.class);
  }

  @Override
  @Nullable
  public FlowlaStepKeyword getStepKeyword() {
    return findChildByClass(FlowlaStepKeyword.class);
  }

  @Override
  @Nullable
  public FlowlaTable getTable() {
    return findChildByClass(FlowlaTable.class);
  }

}
