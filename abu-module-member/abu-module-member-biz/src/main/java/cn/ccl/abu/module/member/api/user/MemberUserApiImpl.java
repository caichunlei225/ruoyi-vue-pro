package cn.ccl.abu.module.member.api.user;

import cn.ccl.abu.module.member.api.user.dto.MemberUserRespDTO;
import cn.ccl.abu.module.member.convert.user.MemberUserConvert;
import cn.ccl.abu.module.member.dal.dataobject.user.MemberUserDO;
import cn.ccl.abu.module.member.service.user.MemberUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 会员用户的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class MemberUserApiImpl implements MemberUserApi {

    @Resource
    private MemberUserService userService;

    @Override
    public MemberUserRespDTO getUser(Long id) {
        MemberUserDO user = userService.getUser(id);
        return MemberUserConvert.INSTANCE.convert2(user);
    }

    @Override
    public List<MemberUserRespDTO> getUserList(Collection<Long> ids) {
        return MemberUserConvert.INSTANCE.convertList2(userService.getUserList(ids));
    }

    @Override
    public List<MemberUserRespDTO> getUserListByNickname(String nickname) {
        return MemberUserConvert.INSTANCE.convertList2(userService.getUserListByNickname(nickname));
    }

    @Override
    public MemberUserRespDTO getUserByMobile(String mobile) {
        return MemberUserConvert.INSTANCE.convert2(userService.getUserByMobile(mobile));
    }

}