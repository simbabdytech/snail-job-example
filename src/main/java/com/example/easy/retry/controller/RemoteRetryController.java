package com.example.easy.retry.controller;


import java.util.Random;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.easy.retry.vo.OrderVo;
import com.example.easy.retry.service.RemoteRetryService;

@RestController
@RequestMapping("/remote")
@Api(value = "模拟远程重试案例", tags = "远程重试案例【RetryType.ONLY_REMOTE】")
public class RemoteRetryController {

    @Autowired
    private RemoteRetryService remoteRetryService;

    /**
     * 一个最简单的远程调用案例
     */
    @GetMapping("/retry")
    @ApiOperation(
        value = "一个简单的入门案例",
        notes = "🥇不进过本地重试阶段，直接上报到服务端\n" +
            "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    public void remote(@ApiParam(name = "params", value = "测试参数", defaultValue = "test")
    @RequestParam("params") String params) {
        remoteRetryService.remoteRetry(params);
    }

    /**
     * 一个最简单的远程调用案例
     */
    @GetMapping("/retry/sync")
    @ApiOperation(
            value = "一个简单的以同步方式远程重试入门案例",
            notes = "🥇不进过本地重试阶段，直接上报到服务端\n" +
                    "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    public void remoteSync(@ApiParam(name = "params", value = "测试参数", defaultValue = "test")
                       @RequestParam("params") String params) {
        remoteRetryService.remoteSync(params);
    }

    /**
     * 使用自定义的幂等Id生成规则
     */
    @PostMapping("/retryWithIdempotentId")
    @ApiOperation(
        value = "使用自定义的幂等Id生成规则",
        notes =
            "具体实现类参考: https://gitee.com/zhangyutongxue/easy-retry-demo/blob/master/easy-retry-springboot/src/main/java/com/maluxinyu/easyretry/customized/OrderIdempotentIdGenerate.java\n"
                + "具体的幂等策略参考: https://www.easyretry.com/pages/97cde9/#%E2%9A%A1%E5%B9%82%E7%AD%89id-idempotentid \n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    public void remoteRetryWithIdempotentId(@RequestBody OrderVo orderVo) {
        remoteRetryService.remoteRetryWithIdempotentId(orderVo);
    }

    /**
     * 使用自定义的单参数幂等Id生成规则
     */
    @ApiOperation(
        value = "使用自定义的单参数幂等Id生成规则",
        notes =
            "具体实现类参考: https://gitee.com/zhangyutongxue/easy-retry-demo/blob/master/easy-retry-springboot/src/main/java/com/maluxinyu/easyretry/customized/SingleParamIdempotentGenerate.java\n"
                +
                "🥇通过对orderId进行md5加密生成幂等ID, 具体的幂等策略参考: https://www.easyretry.com/pages/97cde9/#%E2%9A%A1%E5%B9%82%E7%AD%89id-idempotentid \n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    @GetMapping("/retryWithSingleParamIdempotentGenerate")
    public void retryWithSingleParamIdempotentGenerate(
        @ApiParam(name = "params", value = "测试参数", defaultValue = "test")
        @RequestParam("params") String params) {
        remoteRetryService.retryWithSingleParamIdempotentGenerate(params);
    }

    /**
     * 使用自定义的多参数幂等Id生成规则
     */
    @PostMapping("/retryWithMulParamIdempotentGenerate")
    @ApiOperation(
        value = "使用自定义的多参数幂等Id生成规则",
        notes =
            "具体实现类参考: https://gitee.com/zhangyutongxue/easy-retry-demo/blob/master/easy-retry-springboot/src/main/java/com/maluxinyu/easyretry/customized/MultiParamIdempotentGenerate.java\n"
                +
                "🥇通过对orderId进行md5加密生成幂等ID, 具体的幂等策略参考: https://www.easyretry.com/pages/97cde9/#%E2%9A%A1%E5%B9%82%E7%AD%89id-idempotentid \n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    public void retryWithMulParamIdempotentGenerate(@RequestBody OrderVo orderVo) {
        Random random = new Random();
        remoteRetryService.retryWithMulParamIdempotentGenerate(
            String.valueOf(UUID.randomUUID()),
            random.nextInt(),
            random.nextDouble(),
            'a',
            orderVo
        );
    }

    /**
     * 使用自定义的异常处理类 OrderRetryMethod
     */
    @ApiOperation(
        value = "指定自定义的异常处理类",
        notes =
            "具体实现类参考: https://gitee.com/zhangyutongxue/easy-retry-demo/blob/master/easy-retry-springboot/src/main/java/com/maluxinyu/easyretry/customized/OrderRetryMethod.java\n"
                +
                "🥇什么是自定义的异常处理类: https://www.easyretry.com/pages/540554/#%E8%87%AA%E5%AE%9A%E4%B9%89%E6%96%B9%E6%B3%95%E6%89%A7%E8%A1%8C%E5%99%A8\n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    @PostMapping("/retryWithRetryMethod")
    public void remoteRetryWithRetryMethod(@RequestBody OrderVo orderVo) {
        remoteRetryService.remoteRetryWithRetryMethod(orderVo);
    }

    /**
     * 使用自定义的回调函数
     */
    @ApiOperation(
        value = "使用自定义的回调函数",
        notes =
            "具体实现类参考: https://gitee.com/zhangyutongxue/easy-retry-demo/blob/master/easy-retry-springboot/src/main/java/com/maluxinyu/easyretry/customized/OrderCompleteCallback.java\n"
                +
                "🥇什么情况下触发回调: https://www.easyretry.com/pages/97cde9/#%E2%9A%A1%E5%9B%9E%E8%B0%83\n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    @PostMapping("/retryWithCallback")
    public void remoteRetryWithCallback(@RequestBody OrderVo orderVo) {
        remoteRetryService.remoteRetryWithCompleteCallback(orderVo);
    }

    /**
     * 指定bizNo
     */
    @ApiOperation(
        value = "指定bizNo",
        notes = "🥇什么是bizNo: https://www.easyretry.com/pages/540554/#bizno%E7%94%9F%E6%88%90%E5%99%A8\n"
                +
                "📢查看任务列表: http://preview.easyretry.com/#/retry-task/list"
    )
    @PostMapping("/remoteRetryWithBizNo")
    public void remoteRetryWithBizNo(@RequestBody OrderVo orderVo) {
        remoteRetryService.remoteRetryWithBizNo(orderVo);
    }


}