package cn.ccl.abu.module.system.convert.mail;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import cn.ccl.abu.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
