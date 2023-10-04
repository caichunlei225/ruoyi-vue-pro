package cn.ccl.abu.module.promotion.controller.app.decorate;

import cn.ccl.abu.framework.common.enums.CommonStatusEnum;
import cn.ccl.abu.framework.common.pojo.CommonResult;
import cn.ccl.abu.framework.common.validation.InEnum;
import cn.ccl.abu.module.promotion.controller.app.decorate.vo.AppDecorateComponentRespVO;
import cn.ccl.abu.module.promotion.convert.decorate.DecorateComponentConvert;
import cn.ccl.abu.module.promotion.enums.decorate.DecoratePageEnum;
import cn.ccl.abu.module.promotion.service.decorate.DecorateComponentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static cn.ccl.abu.framework.common.pojo.CommonResult.success;

@Tag(name = "用户 APP - 店铺装修")
@RestController
@RequestMapping("/promotion/decorate")
@Validated
public class AppDecorateController {

    @Resource
    private DecorateComponentService decorateComponentService;

    @GetMapping("/list")
    @Operation(summary = "获取指定页面的组件列表")
    @Parameter(name = "page", description = "页面编号", required = true)
    public CommonResult<List<AppDecorateComponentRespVO>> getDecorateComponentListByPage(
            @RequestParam("page") @InEnum(DecoratePageEnum.class) Integer page) {
        return success(DecorateComponentConvert.INSTANCE.convertList(
                decorateComponentService.getDecorateComponentListByPage(page, CommonStatusEnum.ENABLE.getStatus())));
    }

}
