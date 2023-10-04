package cn.ccl.abu.module.system.convert.sms;

import cn.ccl.abu.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import cn.ccl.abu.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import cn.ccl.abu.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import cn.ccl.abu.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import cn.ccl.abu.module.system.dal.dataobject.sms.SmsChannelDO;
import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.framework.sms.core.property.SmsChannelProperties;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信渠道 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SmsChannelConvert {

    SmsChannelConvert INSTANCE = Mappers.getMapper(SmsChannelConvert.class);

    SmsChannelDO convert(SmsChannelCreateReqVO bean);

    SmsChannelDO convert(SmsChannelUpdateReqVO bean);

    SmsChannelRespVO convert(SmsChannelDO bean);

    List<SmsChannelRespVO> convertList(List<SmsChannelDO> list);

    PageResult<SmsChannelRespVO> convertPage(PageResult<SmsChannelDO> page);

    List<SmsChannelSimpleRespVO> convertList03(List<SmsChannelDO> list);

    SmsChannelProperties convert02(SmsChannelDO channel);

}
