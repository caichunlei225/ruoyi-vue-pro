package cn.ccl.abu.module.infra.convert.test;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import cn.ccl.abu.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import cn.ccl.abu.module.infra.controller.admin.test.vo.TestDemoRespVO;
import cn.ccl.abu.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import cn.ccl.abu.module.infra.dal.dataobject.test.TestDemoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
