package cn.ccl.abu.module.member.controller.admin.point;

import cn.ccl.abu.framework.common.pojo.CommonResult;
import cn.ccl.abu.module.member.controller.admin.point.vo.config.MemberPointConfigRespVO;
import cn.ccl.abu.module.member.controller.admin.point.vo.config.MemberPointConfigSaveReqVO;
import cn.ccl.abu.module.member.convert.point.MemberPointConfigConvert;
import cn.ccl.abu.module.member.dal.dataobject.point.MemberPointConfigDO;
import cn.ccl.abu.module.member.service.point.MemberPointConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.ccl.abu.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 会员积分设置")
@RestController
@RequestMapping("/member/point/config")
@Validated
public class MemberPointConfigController {

    @Resource
    private MemberPointConfigService memberPointConfigService;

    @PutMapping("/save")
    @Operation(summary = "保存会员积分配置")
    @PreAuthorize("@ss.hasPermission('point:config:save')")
    public CommonResult<Boolean> savePointConfig(@Valid @RequestBody MemberPointConfigSaveReqVO saveReqVO) {
        memberPointConfigService.savePointConfig(saveReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得会员积分配置")
    @PreAuthorize("@ss.hasPermission('point:config:query')")
    public CommonResult<MemberPointConfigRespVO> getPointConfig() {
        MemberPointConfigDO config = memberPointConfigService.getPointConfig();
        return success(MemberPointConfigConvert.INSTANCE.convert(config));
    }

}
