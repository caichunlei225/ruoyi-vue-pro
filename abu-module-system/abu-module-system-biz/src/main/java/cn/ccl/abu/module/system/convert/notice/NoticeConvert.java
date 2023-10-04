package cn.ccl.abu.module.system.convert.notice;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.ccl.abu.module.system.controller.admin.notice.vo.NoticeRespVO;
import cn.ccl.abu.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.ccl.abu.module.system.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
