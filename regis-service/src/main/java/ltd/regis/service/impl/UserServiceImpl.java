package ltd.regis.service.impl;


import javax.annotation.Resource;
import ltd.regis.entity.SysUser;
import ltd.regis.mapper.SysUserMapper;
import ltd.regis.utils.PasswordEncoder;
import ltd.regis.utils.PasswordUtils;
import ltd.regis.vo.req.RegisterReqVO;
import ltd.regis.vo.req.UpdateUserReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ltd.regis.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;


/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: service.impl
 * @Author: Regis
 * @CreateTime: 2023-02-28  09:01
 * @Description:
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "sysUserMapper")
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserInfo(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String register(RegisterReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        sysUser.setCreateTime(new Date());
        sysUser.setId(UUID.randomUUID().toString());
        String salt = PasswordUtils.getSalt();
        String encode = PasswordUtils.encode(vo.getPassword(), salt);
        sysUser.setPassword(encode);
        sysUser.setSalt(salt);
        int insert = sysUserMapper.insert(sysUser);
        return insert == 0 ? "failed" : "succeed";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateUserInfo(UpdateUserReqVO vo) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(vo, sysUser);
        if(!StringUtils.hasLength(sysUser.getPassword())){
            sysUser.setPassword(null);
        }else {
            String salt = PasswordUtils.getSalt();
            String password = PasswordUtils.encode(sysUser.getPassword(), salt);
            sysUser.setPassword(password);
            sysUser.setSalt(salt);
        }
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
//        模拟异常
//        int i1 = 1/0;
        return i == 1 ? "success" : "failed";
    }

    @Override
    public String deleteUserInfo(String id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setDeleted(1);
        sysUser.setUpdateTime(new Date());
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return i == 1 ? "success" : "failed";
    }
}
