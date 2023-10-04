package cn.ccl.abu.module.product.convert.propertyvalue;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.framework.common.util.collection.CollectionUtils;
import cn.ccl.abu.framework.common.util.collection.MapUtils;
import cn.ccl.abu.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import cn.ccl.abu.module.product.controller.admin.property.vo.value.ProductPropertyValueCreateReqVO;
import cn.ccl.abu.module.product.controller.admin.property.vo.value.ProductPropertyValueRespVO;
import cn.ccl.abu.module.product.controller.admin.property.vo.value.ProductPropertyValueUpdateReqVO;
import cn.ccl.abu.module.product.dal.dataobject.property.ProductPropertyDO;
import cn.ccl.abu.module.product.dal.dataobject.property.ProductPropertyValueDO;
import cn.ccl.abu.module.product.service.property.bo.ProductPropertyValueDetailRespBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static cn.ccl.abu.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * 属性值 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductPropertyValueConvert {

    ProductPropertyValueConvert INSTANCE = Mappers.getMapper(ProductPropertyValueConvert.class);

    ProductPropertyValueDO convert(ProductPropertyValueCreateReqVO bean);

    ProductPropertyValueDO convert(ProductPropertyValueUpdateReqVO bean);

    ProductPropertyValueRespVO convert(ProductPropertyValueDO bean);

    List<ProductPropertyValueRespVO> convertList(List<ProductPropertyValueDO> list);

    PageResult<ProductPropertyValueRespVO> convertPage(PageResult<ProductPropertyValueDO> page);

    default List<ProductPropertyValueDetailRespBO> convertList(List<ProductPropertyValueDO> values, List<ProductPropertyDO> keys) {
        Map<Long, ProductPropertyDO> keyMap = convertMap(keys, ProductPropertyDO::getId);
        return CollectionUtils.convertList(values, value -> {
            ProductPropertyValueDetailRespBO valueDetail = new ProductPropertyValueDetailRespBO()
                    .setValueId(value.getId()).setValueName(value.getName());
            // 设置属性项
            MapUtils.findAndThen(keyMap, value.getPropertyId(),
                    key -> valueDetail.setPropertyId(key.getId()).setPropertyName(key.getName()));
            return valueDetail;
        });
    }

    List<ProductPropertyValueDetailRespDTO> convertList02(List<ProductPropertyValueDetailRespBO> list);

}
