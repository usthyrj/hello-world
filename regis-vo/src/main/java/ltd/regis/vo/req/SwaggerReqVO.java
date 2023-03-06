package ltd.regis.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.vo.req
 * @Author: Regis
 * @CreateTime: 2023-03-04  09:01
 * @Description:
 * @Version: 1.0
 */

@Data
public class SwaggerReqVO {

    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
