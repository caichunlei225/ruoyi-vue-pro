package cn.ccl.abu.module.infra.convert.file;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.infra.controller.admin.file.vo.file.FileRespVO;
import cn.ccl.abu.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
