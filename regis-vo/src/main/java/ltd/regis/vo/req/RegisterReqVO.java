package ltd.regis.vo.req;

import lombok.Data;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.vo.req
 * @Author: Regis
 * @CreateTime: 2023-03-02  10:41
 * @Description:
 * @Version: 1.0
 */

@Data
public class RegisterReqVO {
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String createWhere;
    private String email;
    private String nickName;


}
