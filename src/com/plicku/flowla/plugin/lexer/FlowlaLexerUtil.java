package com.plicku.flowla.plugin.lexer;

import com.intellij.psi.tree.IElementType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.plicku.flowla.plugin.psi.FlowlaTypes.*;

public class FlowlaLexerUtil {
    public static final String AND="And ";
    public static final String WHEN="When ";
    public static final String GIVEN="Given ";
    public static final String THEN="Then ";
    public static final String BUT="But ";
    public static final String FOR_EACH="For Each ";
    public static final String END_FOR = "EndFor";
    public static final String IF="If ";
    public static final String ELSE_IF="Else If ";
    public static final String END_IF="EndIf";
    public static final String OTHERWISE ="Otherwise";
    public static final String REPEAT_FOR ="Repeat Step(s) For ";
    public static final String REPEAT_WHILE ="Repeat Step(s) while ";
    public static final String END_REPEAT="EndRepeat";
    private static int keywordLexSubstate=0;


    public static final int INITIAL_STATE=0;
    public static final int KEYWORD_STATE=1;
    public static final int STEP_DATA_STATE=2;

    public static final Pattern keywordPattern;



    static Map<String, StepTokenProperties> keyWordMap = new HashMap<>();
    static Map<IElementType, StepTokenProperties> tokenMap = new HashMap<>();
    static {
        keyWordMap.put(AND, new StepTokenProperties(AND,AND_KW,KEYWORD_STATE,true,true,false));
        keyWordMap.put(WHEN,new StepTokenProperties(WHEN,WHEN_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(GIVEN,new StepTokenProperties(GIVEN,GIVEN_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(THEN,new StepTokenProperties(THEN,THEN_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(BUT,new StepTokenProperties(BUT,BUT_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(FOR_EACH,new StepTokenProperties(FOR_EACH,FOREACH_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(END_FOR,new StepTokenProperties(END_FOR,ENDFOR_KW,KEYWORD_STATE,false,false,true) );
        keyWordMap.put(IF,new StepTokenProperties(IF,IF_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(ELSE_IF,new StepTokenProperties(ELSE_IF,ELSEIF_KW,KEYWORD_STATE,true,true,false) );
        keyWordMap.put(END_IF,new StepTokenProperties(END_IF,ENDIF_KW,KEYWORD_STATE,false,false,true));
        keyWordMap.put(OTHERWISE,new StepTokenProperties(OTHERWISE,OTHERWISE_KW,KEYWORD_STATE,false,false,false));
        keyWordMap.put(REPEAT_FOR,new StepTokenProperties(REPEAT_FOR,REPEATEFOR_KW,KEYWORD_STATE,true,true,false));
        keyWordMap.put(REPEAT_WHILE,new StepTokenProperties(REPEAT_WHILE,REPEATWHILE_KW,KEYWORD_STATE,true,true,false));
        keyWordMap.put(END_REPEAT,new StepTokenProperties(END_REPEAT,ENDREPEAT_KW,KEYWORD_STATE,false,false,true));

        keyWordMap.forEach((s, stepTokenProperties) -> tokenMap.put(stepTokenProperties.tokenType,stepTokenProperties));
        String keywords = keyWordMap.keySet().stream().collect(Collectors.joining("|"));
        keywordPattern= Pattern.compile(String.format("(?m)^\\s*(%s)",keywords));

    }


    private static void populateKeywordMap(String keyword,StepTokenProperties stepTokenProperties)
    {
        stepTokenProperties.setLexKeywordSubState(keywordLexSubstate);
        keyWordMap.put(keyword,stepTokenProperties);
        keywordLexSubstate++;
    }


    public static boolean isKeyWord(IElementType tokenType)
    {
        return tokenMap.containsKey(tokenType);
    }

    public static boolean isWhiteSpace(CharSequence sequence)
    {
        return "".equals(sequence.toString().trim());
    }

    public static StepTokenProperties getStepTokenProperites(String keyword)
    {
        return keyWordMap.get(keyword);
    }


    public static Collection<StepTokenProperties> getStepTokenPropertiesList()
    {
        return keyWordMap.values();
    }




}
