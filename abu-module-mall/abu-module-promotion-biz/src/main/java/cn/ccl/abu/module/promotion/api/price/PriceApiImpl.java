package cn.ccl.abu.module.promotion.api.price;

import cn.ccl.abu.module.promotion.api.price.dto.PriceCalculateReqDTO;
import cn.ccl.abu.module.promotion.api.price.dto.PriceCalculateRespDTO;
import cn.ccl.abu.module.promotion.service.price.PriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 价格 API 实现类
 *
 * @author 芋道源码
 */
@Service
public class PriceApiImpl implements PriceApi {

    @Resource
    private PriceService priceService;

    @Override
    public PriceCalculateRespDTO calculatePrice(PriceCalculateReqDTO calculateReqDTO) {
        //return priceService.calculatePrice(calculateReqDTO); TODO 没有 calculatePrice 这个方法

        return null;
    }

}
