package cn.ccl.abu.module.system.convert.logger;

import cn.ccl.abu.module.system.controller.admin.logger.vo.operatelog.OperateLogExcelVO;
import cn.ccl.abu.module.system.controller.admin.logger.vo.operatelog.OperateLogRespVO;
import cn.ccl.abu.module.system.dal.dataobject.logger.OperateLogDO;
import cn.ccl.abu.module.system.dal.dataobject.user.AdminUserDO;
import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.framework.common.util.collection.MapUtils;
import cn.ccl.abu.module.system.api.logger.dto.OperateLogCreateReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.ccl.abu.framework.common.exception.enums.GlobalErrorCodeConstants.SUCCESS;

@Mapper
public interface OperateLogConvert {

    OperateLogConvert INSTANCE = Mappers.getMapper(OperateLogConvert.class);

    OperateLogDO convert(OperateLogCreateReqDTO bean);

    PageResult<OperateLogRespVO> convertPage(PageResult<OperateLogDO> page);

    OperateLogRespVO convert(OperateLogDO bean);

    default List<OperateLogExcelVO> convertList(List<OperateLogDO> list, Map<Long, AdminUserDO> userMap) {
        return list.stream().map(operateLog -> {
            OperateLogExcelVO excelVO = convert02(operateLog);
            MapUtils.findAndThen(userMap, operateLog.getUserId(), user -> excelVO.setUserNickname(user.getNickname()));
            excelVO.setSuccessStr(SUCCESS.getCode().equals(operateLog.getResultCode()) ? "成功" : "失败");
            return excelVO;
        }).collect(Collectors.toList());
    }

    OperateLogExcelVO convert02(OperateLogDO bean);

}