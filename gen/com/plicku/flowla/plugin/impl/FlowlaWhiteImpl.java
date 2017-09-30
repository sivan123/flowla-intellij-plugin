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

public class FlowlaWhiteImpl extends ASTWrapperPsiElement implements FlowlaWhite {

  public FlowlaWhiteImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlowlaVisitor visitor) {
    visitor.visitWhite(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlowlaVisitor) accept((FlowlaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FlowlaEol> getEolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlowlaEol.class);
  }

  @Override
  @NotNull
  public List<FlowlaSpace> getSpaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlowlaSpace.class);
  }

}
