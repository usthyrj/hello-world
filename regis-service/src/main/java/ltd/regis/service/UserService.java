package ltd.regis.service;

import ltd.regis.entity.SysUser;
import ltd.regis.vo.req.RegisterReqVO;
import ltd.regis.vo.req.UpdateUserReqVO;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: service
 * @Author: Regis
 * @CreateTime: 2023-02-28  09:00
 * @Description:
 * @Version: 1.0
 */

public interface UserService {
    SysUser getUserInfo(String id);

    String register(RegisterReqVO vo);

    String updateUserInfo(UpdateUserReqVO vo);

    String deleteUserInfo(String id);
}
