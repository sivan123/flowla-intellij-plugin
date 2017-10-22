package com.plicku.flowla.plugin.lexer;

import com.intellij.psi.tree.IElementType;


public class StepTokenProperties {
    String keyword;
    IElementType tokenType;
    int lexstate;
    boolean stepDataPossible;
    boolean keywordWithStepname;
    boolean closureKeyword;
    Integer lexKeywordSubState;


    public StepTokenProperties(String keyword, IElementType tokenType,
                               int lexstate, boolean stepDataPossible, boolean keywordWithStepname,
                               boolean closureKeyword) {
        this.keyword = keyword;
        this.tokenType = tokenType;
        this.lexstate = lexstate;
        this.stepDataPossible = stepDataPossible;
        this.keywordWithStepname = keywordWithStepname;
        this.closureKeyword = closureKeyword;
    }

    public Integer getLexKeywordSubState() {
        return lexKeywordSubState;
    }

    public void setLexKeywordSubState(Integer lexKeywordSubState) {
        this.lexKeywordSubState = lexKeywordSubState;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public IElementType getTokenType() {
        return tokenType;
    }

    public void setTokenType(IElementType tokenType) {
        this.tokenType = tokenType;
    }

    public int getLexstate() {
        return lexstate;
    }

    public void setLexstate(int lexstate) {
        this.lexstate = lexstate;
    }

    public boolean isStepDataPossible() {
        return stepDataPossible;
    }

    public void setStepDataPossible(boolean stepDataPossible) {
        this.stepDataPossible = stepDataPossible;
    }

    public boolean isKeywordWithStepname() {
        return keywordWithStepname;
    }

    public void setKeywordWithStepname(boolean keywordWithStepname) {
        this.keywordWithStepname = keywordWithStepname;
    }

    public boolean isClosureKeyword() {
        return closureKeyword;
    }

    public void setClosureKeyword(boolean closureKeyword) {
        this.closureKeyword = closureKeyword;
    }
}
