package com.youedata.nncloud.core.common.constant.dictmap;

import com.youedata.nncloud.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * Created by sky on 2018/11/26.
 * 修改用户状态（禁用/启用）的记录日志
 */
public class UserStatusDict extends AbstractDictMap{
    @Override
    public void init() {
        put("userInfoId","操作");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("userInfoId","getUserStatus");
    }
}
