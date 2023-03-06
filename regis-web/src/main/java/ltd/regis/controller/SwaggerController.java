package ltd.regis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ltd.regis.vo.req.SwaggerReqVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.controller
 * @Author: Regis
 * @CreateTime: 2023-03-04  09:03
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags = "测试swagger")
public class SwaggerController {

    @ApiOperation("First swagger接口")
    @PostMapping("/swagger")
    public SwaggerReqVO testSwagger(@RequestBody SwaggerReqVO vo) {
        return vo;
    }
}
