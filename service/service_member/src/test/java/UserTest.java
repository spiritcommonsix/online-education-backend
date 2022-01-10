import com.alibaba.excel.EasyExcel;
import com.coc.commonutils.ResultData;
import com.coc.member.MemberApplication;
import com.coc.member.entity.Order;
import com.coc.member.entity.SysRoleTable;
import com.coc.member.entity.SysRoleUserTable;
import com.coc.member.entity.vo.RegisterVo;
import com.coc.member.mapper.MembersMapper;
import com.coc.member.mapper.OrderMapper;
import com.coc.member.mapper.SysRoleTableMapper;
import com.coc.member.service.MembersService;
import com.coc.member.service.OrderService;
import com.coc.member.service.SysRoleUserTableService;
import com.coc.member.service.SysUserTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.core.Application;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
    @Autowired
    private SysUserTableService service;

    @Autowired
    private SysRoleUserTableService roleUserTableService;

    @Autowired
    private MembersService membersService;

    public void run()
    {
//        RegisterVo vo=new RegisterVo();
//        for(int index=10;index<30;index++)
//        {
//            vo.setUserName(String.format("user%d",index));
//            vo.setPassWord("000000");
//            vo.setTelNumber(String.format("138185151%d",index));
//            service.register(vo);
//        }
//        this.service.register();
//        String nums[]= {
//                "1381468361044566018",
//                "1381468364295151617",
//                "1381468366836899842",
//                "1381468368460095490",
//                "1381468370016182273",
//                "1381468371643572226",
//                "1381468373354848257",
//                "1381468375103873026",
//                "1381468376882257922",
//                "1381468378564173825"
//        };
//        final String TEACHER_NUM="1381432237916016641";
//        for(String num : nums) {
//            SysRoleUserTable table=new SysRoleUserTable();
//            table.setRoleId(TEACHER_NUM);
//            table.setUserId(num);
//            roleUserTableService.save(table);
//        }

        

    }


    public void getUserInfo()
    {
        //1388398933008531457
        String userId="1388398933008531457";
        String cardId="2edc146e-b0d8-11eb-a079-0a002700000211";
        ResultData resultData = membersService.fillAccount(userId, cardId);
        System.out.println(resultData);
    }

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MembersMapper membersMapper;
    @Test
    public void buyCourse(){

    }
}
