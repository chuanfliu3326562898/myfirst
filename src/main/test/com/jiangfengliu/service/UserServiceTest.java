package com.jiangfengliu.service;

import com.jiangfengliu.util.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * 长行请求测试类
 *
 * @author tianweilin
 * @date 18/7/28
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TestUtil.class})
@PowerMockIgnore("javax.management.*")
public class UserServiceTest {

//    @InjectMocks
//    protected UserServiceImpl userService;
    @Mock
    protected UserService userService;

    @Test
    public void myBefore() throws Exception{
        //MockitoAnnotations.initMocks(this);


        PowerMockito.mockStatic(TestUtil.class);
        PowerMockito.doNothing().when(TestUtil.class,"print",ArgumentMatchers.anyString());
        //when(TestUtil.print("ljf")).thenReturn(true);
        System.out.println(userService.findNameById(ArgumentMatchers.anyInt()));
        //when(userService.findNameById(1)).thenReturn(new User());


    }


}
