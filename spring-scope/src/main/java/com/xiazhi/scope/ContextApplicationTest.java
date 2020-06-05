package com.xiazhi.scope;

import com.xiazhi.scope.support.ThreadScope;
import com.xiazhi.scope.web.Model;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
public class ContextApplicationTest {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

        for (int i = 0; i < 2; i++) {

            new Thread(() -> {
                Model bean = context.getBean(Model.class);
                System.out.println("==============");
                Model bean1 = context.getBean(Model.class);
            }).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
