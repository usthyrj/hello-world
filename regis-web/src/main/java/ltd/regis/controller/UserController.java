package ltd.regis.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.*;
import ltd.regis.entity.SysUser;
import ltd.regis.vo.req.RegisterReqVO;
import ltd.regis.vo.req.UpdateUserReqVO;
import org.springframework.web.bind.annotation.*;
import ltd.regis.service.UserService;

/**
 * @BelongsProject: mybatis-demo
 * @BelongsPackage: ltd.regis.controller
 * @Author: Regis
 * @CreateTime: 2023-02-28  09:03
 * @Description:
 * @Version: 1.0
 */

@RestController
@RequestMapping("/api")
@Api(tags = "用户模块",description = "用户相关接口")
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户详情接口")
    @ApiResponses({
            @ApiResponse(code = 0, message = "响应成功"),
            @ApiResponse(code = 1, message = "响应失败")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "string", paramType = "query",
                    required = true, defaultValue = "0f09e661-7e80-4e1b-b66a-2e266bb593bf")
    })
    public SysUser getUserDetail(@ApiParam(value = "用户ID", required = true) @RequestParam String id, HttpServletRequest request) {
        return userService.getUserInfo(id);
    }

    /*@GetMapping("/druid/stat")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }*/

    @GetMapping("/user/{id}")
    public SysUser getUserInfo(@PathVariable("id") String id) {
        return userService.getUserInfo(id);
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody RegisterReqVO vo) {
        return userService.register(vo);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody UpdateUserReqVO vo) {
        return userService.updateUserInfo(vo);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserInfo(@PathVariable String id) {
        return userService.deleteUserInfo(id);
    }



}
