package cn.ccl.abu.module.member.service.point;

import cn.ccl.abu.framework.common.util.collection.CollectionUtils;
import cn.ccl.abu.module.member.controller.admin.point.vo.config.MemberPointConfigSaveReqVO;
import cn.ccl.abu.module.member.convert.point.MemberPointConfigConvert;
import cn.ccl.abu.module.member.dal.dataobject.point.MemberPointConfigDO;
import cn.ccl.abu.module.member.dal.mysql.point.MemberPointConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员积分配置 Service 实现类
 *
 * @author QingX
 */
@Service
@Validated
public class MemberPointConfigServiceImpl implements MemberPointConfigService {

    @Resource
    private MemberPointConfigMapper memberPointConfigMapper;

    @Override
    public void savePointConfig(MemberPointConfigSaveReqVO saveReqVO) {
        // 存在，则进行更新
        MemberPointConfigDO dbConfig = getPointConfig();
        if (dbConfig != null) {
            memberPointConfigMapper.updateById(MemberPointConfigConvert.INSTANCE.convert(saveReqVO).setId(dbConfig.getId()));
            return;
        }
        // 不存在，则进行插入
        memberPointConfigMapper.insert(MemberPointConfigConvert.INSTANCE.convert(saveReqVO));
    }

    @Override
    public MemberPointConfigDO getPointConfig() {
        List<MemberPointConfigDO> list = memberPointConfigMapper.selectList();
        return CollectionUtils.getFirst(list);
    }

}
