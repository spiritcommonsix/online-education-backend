import com.coc.auth.AuthApplication;
import com.coc.auth.entity.SysBackendApi;
import com.coc.auth.entity.SysFrontedMenu;
import com.coc.auth.entity.SysRole;
import com.coc.auth.service.SysBackendApiService;
import com.coc.auth.service.SysFrontedMenuService;
import com.coc.auth.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthTest {
    @Autowired
    private SysFrontedMenuService frontedMenuService;

    @Autowired
    private SysBackendApiService backendApiService;

    public void addmenu()
    {
        String names[]={
                "我发布的课程",
                "我的学习小组"
        };
        for(String name:names)
        {
            SysFrontedMenu frontedMenu=new SysFrontedMenu();
            frontedMenu.setFrontedMenuName(name);
            frontedMenu.setFrontedMenuPid("1381531478940286977");
            frontedMenuService.save(frontedMenu);
        }
    }

    @Test
    public void addApi(){
        SysBackendApi api=new SysBackendApi();
        api.setBackendApiName("普通管理员");
        api.setBackendApiUrl("/manage/**");
        api.setBackendApiMethod("GET,POST,PUT,DELETE");
        backendApiService.save(api);
    }

    @Autowired
    SysRoleService roleService;


    public void roleInsert(){
        SysRole role=new SysRole();
        role.setRoleName("ROLE_MANAGER");
        role.setDescription("普通管理员");
        roleService.save(role);
    }

}
