package ltd.regis.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.vo.req
 * @Author: Regis
 * @CreateTime: 2023-03-04  07:45
 * @Description:
 * @Version: 1.0
 */

@Data
@ApiModel(value = "ltd.regis.vo.req.UpdateUserReqVO", description = "更新用户数据所用VO")
public class UpdateUserReqVO {

    @ApiModelProperty("ID")
    private String id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    private String phone;
    private String deptId;
    private String realName;
    private String nickName;
    private String email;
    private Integer status;
    private Integer sex;
    private Integer createWhere;


}
