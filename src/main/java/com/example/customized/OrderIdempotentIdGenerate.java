package com.example.customized;

import cn.hutool.crypto.SecureUtil;
import com.aizuda.snailjob.client.core.IdempotentIdGenerate;
import com.aizuda.snailjob.common.core.model.IdempotentIdContext;
import com.example.vo.OrderVo;


public class OrderIdempotentIdGenerate implements IdempotentIdGenerate {

    @Override
    public String idGenerate(IdempotentIdContext idempotentIdContext) throws Exception {
        Object[] args = idempotentIdContext.getArgs();
        OrderVo orderVo = (OrderVo) args[0];
        return SecureUtil.md5(orderVo.getOrderId());
    }

}

