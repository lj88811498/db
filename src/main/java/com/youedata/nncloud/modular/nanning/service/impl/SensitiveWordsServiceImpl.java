package com.youedata.nncloud.modular.nanning.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.youedata.nncloud.modular.nanning.dao.SensitiveWordsMapper;
import com.youedata.nncloud.modular.nanning.enums.MatchType;
import com.youedata.nncloud.modular.nanning.model.SensitiveWords;
import com.youedata.nncloud.modular.nanning.service.ISensitiveWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 敏感词Service
 *
 * @author TC
 * @Date 2018-12-29 09:18:31
 */
@Service
@Transactional(rollbackFor = java.lang.Exception.class)
public class SensitiveWordsServiceImpl extends ServiceImpl<BaseMapper<SensitiveWords>, SensitiveWords> implements ISensitiveWordsService {

    private Map<Object, Object> sensitiveWordsMap;

    private static final String END_FLAG = "end";

    @Autowired
    private SensitiveWordsMapper mapper;

    @Override
    public String checkNickName(String nickname) {
        List<String> words = mapper.getWords();
        Set<String> set = new HashSet<>(words);
        initSensitiveWordsMap(set);
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(nickname);
        boolean b = m.find();
        if (isContainSensitiveWord(nickname) || b) {
            return "true";
        }
        return "false";
    }

    public boolean isContainSensitiveWord(String text) {
        Set<String> sensitiveWords = getSensitiveWords(text, MatchType.MIN_MATCH);
        if (sensitiveWords != null && sensitiveWords.size() > 0) {
            return true;
        }
        return false;
    }


    public Set<String> getSensitiveWords(String text, MatchType matchType) {
        if (text == null || text.trim().length() == 0) {
            throw new IllegalArgumentException("The input text must not be empty.");
        }
        Set<String> sensitiveWords = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            int sensitiveWordLength = getSensitiveWordLength(text, i, matchType);
            if (sensitiveWordLength > 0) {
                String sensitiveWord = text.substring(i, i + sensitiveWordLength);
                sensitiveWords.add(sensitiveWord);
                if (matchType == MatchType.MIN_MATCH) {
                    break;
                }
                i = i + sensitiveWordLength - 1;
            }
        }
        return sensitiveWords;
    }

    public int getSensitiveWordLength(String text, int startIndex, MatchType matchType) {
        if (text == null || text.trim().length() == 0) {
            throw new IllegalArgumentException("The input text must not be empty.");
        }
        char currentChar;
        Map<Object, Object> currentMap = sensitiveWordsMap;
        int wordLength = 0;
        boolean endFlag = false;
        for (int i = startIndex; i < text.length(); i++) {
            currentChar = text.charAt(i);
            Map<Object, Object> subMap = (Map<Object, Object>) currentMap.get(currentChar);
            if (subMap == null) {
                break;
            } else {
                wordLength++;
                if (subMap.containsKey(END_FLAG)) {
                    endFlag = true;
                    if (matchType == MatchType.MIN_MATCH) {
                        break;
                    } else {
                        currentMap = subMap;
                    }
                } else {
                    currentMap = subMap;
                }
            }
        }
        if (!endFlag) {
            wordLength = 0;
        }
        return wordLength;
    }


    private void initSensitiveWordsMap(Set<String> sensitiveWords) {
        if (sensitiveWords == null || sensitiveWords.isEmpty()) {
            throw new IllegalArgumentException("Senditive words must not be empty!");
        }
        sensitiveWordsMap = new HashMap<>(sensitiveWords.size());
        String currentWord;
        Map<Object, Object> currentMap;
        Map<Object, Object> subMap;
        Iterator<String> iterator = sensitiveWords.iterator();
        while (iterator.hasNext()) {
            currentWord = iterator.next();
            //敏感词长度必须大于等于2
            if (currentWord == null || currentWord.trim().length() < 2) {
                continue;
            }
            currentMap = sensitiveWordsMap;
            for (int i = 0; i < currentWord.length(); i++) {
                char c = currentWord.charAt(i);
                subMap = (Map<Object, Object>) currentMap.get(c);
                if (subMap == null) {
                    subMap = new HashMap<>();
                    currentMap.put(c, subMap);
                    currentMap = subMap;
                } else {
                    currentMap = subMap;
                }
                if (i == currentWord.length() - 1) {
                    //如果是最后一个字符，则put一个结束标志，这里只需要保存key就行了，value为null可以节省空间。
                    //如果不是最后一个字符，则不需要存这个结束标志，同样也是为了节省空间。
                    currentMap.put(END_FLAG, null);
                }
            }
        }
    }
}
