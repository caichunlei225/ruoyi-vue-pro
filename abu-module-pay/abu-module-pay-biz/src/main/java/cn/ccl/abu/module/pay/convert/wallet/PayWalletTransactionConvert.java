package cn.ccl.abu.module.pay.convert.wallet;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionRespVO;
import cn.ccl.abu.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import cn.ccl.abu.module.pay.service.wallet.bo.CreateWalletTransactionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletTransactionConvert {

    PayWalletTransactionConvert INSTANCE = Mappers.getMapper(PayWalletTransactionConvert.class);

    PageResult<AppPayWalletTransactionRespVO> convertPage(PageResult<PayWalletTransactionDO> page);

    PayWalletTransactionDO convert(CreateWalletTransactionBO bean);

}
