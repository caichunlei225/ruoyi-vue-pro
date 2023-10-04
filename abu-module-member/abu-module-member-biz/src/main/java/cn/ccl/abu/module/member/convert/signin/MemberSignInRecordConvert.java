package cn.ccl.abu.module.member.convert.signin;

import cn.ccl.abu.framework.common.pojo.PageResult;
import cn.ccl.abu.framework.common.util.collection.MapUtils;
import cn.ccl.abu.module.member.api.user.dto.MemberUserRespDTO;
import cn.ccl.abu.module.member.controller.admin.signin.vo.record.MemberSignInRecordRespVO;
import cn.ccl.abu.module.member.controller.app.signin.vo.record.AppMemberSignInRecordRespVO;
import cn.ccl.abu.module.member.dal.dataobject.signin.MemberSignInRecordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static cn.ccl.abu.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * 签到记录 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface MemberSignInRecordConvert {

    MemberSignInRecordConvert INSTANCE = Mappers.getMapper(MemberSignInRecordConvert.class);

    default PageResult<MemberSignInRecordRespVO> convertPage(PageResult<MemberSignInRecordDO> pageResult, List<MemberUserRespDTO> users) {
        PageResult<MemberSignInRecordRespVO> voPageResult = convertPage(pageResult);
        // user 拼接
        Map<Long, MemberUserRespDTO> userMap = convertMap(users, MemberUserRespDTO::getId);
        voPageResult.getList().forEach(record -> MapUtils.findAndThen(userMap, record.getUserId(),
                memberUserRespDTO -> record.setNickname(memberUserRespDTO.getNickname())));
        return voPageResult;
    }
    PageResult<MemberSignInRecordRespVO> convertPage(PageResult<MemberSignInRecordDO> pageResult);

    PageResult<AppMemberSignInRecordRespVO> convertPage02(PageResult<MemberSignInRecordDO> pageResult);

}
