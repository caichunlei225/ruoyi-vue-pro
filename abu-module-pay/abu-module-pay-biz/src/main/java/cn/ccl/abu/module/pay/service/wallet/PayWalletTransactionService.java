package cn.ccl.abu.module.pay.service.wallet;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.module.pay.controller.app.wallet.vo.transaction.AppPayWalletTransactionPageReqVO;
import cn.ccl.abu.module.pay.dal.dataobject.wallet.PayWalletTransactionDO;
import cn.ccl.abu.module.pay.enums.member.PayWalletBizTypeEnum;
import cn.ccl.abu.module.pay.service.wallet.bo.CreateWalletTransactionBO;

import javax.validation.Valid;

/**
 * 钱包余额流水 Service 接口
 *
 * @author jason
 */
public interface PayWalletTransactionService {

    /**
     * 查询钱包余额流水分页
     *
     * @param userId   用户编号
     * @param userType 用户类型
     * @param pageVO   分页查询参数
     */
    PageResult<PayWalletTransactionDO> getWalletTransactionPage(Long userId, Integer userType,
                                                                AppPayWalletTransactionPageReqVO pageVO);

    /**
     * 新增钱包余额流水
     *
     * @param bo 创建钱包流水 bo
     * @return 新建的钱包 do
     */
    PayWalletTransactionDO createWalletTransaction(@Valid CreateWalletTransactionBO bo);

    /**
     * 根据 no，获取钱包余流水
     *
     * @param no 流水号
     */
    PayWalletTransactionDO getWalletTransactionByNo(String no);

    /**
     * 获取钱包流水
     *
     * @param bizId  业务编号
     * @param type  业务类型
     * @return 钱包流水
     */
    PayWalletTransactionDO getWalletTransaction(String bizId, PayWalletBizTypeEnum type);
    
}