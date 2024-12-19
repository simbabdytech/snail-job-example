package com.example.customized;

import cn.hutool.crypto.SecureUtil;
import com.aizuda.snailjob.client.core.IdempotentIdGenerate;
import com.aizuda.snailjob.common.core.model.IdempotentIdContext;

public class SingleParamIdempotentGenerate implements IdempotentIdGenerate {

    @Override
    public String idGenerate(IdempotentIdContext idempotentIdContext) throws Exception {
        Object[] args = idempotentIdContext.getArgs();
        String params = (String) args[0];
        return SecureUtil.md5(params);
    }
}

