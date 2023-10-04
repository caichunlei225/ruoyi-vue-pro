package cn.ccl.abu.module.promotion.convert.decorate;

import cn.ccl.abu.module.promotion.controller.admin.decorate.vo.DecorateComponentRespVO;
import cn.ccl.abu.module.promotion.controller.admin.decorate.vo.DecorateComponentSaveReqVO;
import cn.ccl.abu.module.promotion.controller.app.decorate.vo.AppDecorateComponentRespVO;
import cn.ccl.abu.module.promotion.dal.dataobject.decorate.DecorateComponentDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DecorateComponentConvert {

    DecorateComponentConvert INSTANCE = Mappers.getMapper(DecorateComponentConvert.class);

    List<DecorateComponentRespVO> convertList02(List<DecorateComponentDO> list);

    DecorateComponentDO convert(DecorateComponentSaveReqVO bean);

    List<AppDecorateComponentRespVO> convertList(List<DecorateComponentDO> list);

}
