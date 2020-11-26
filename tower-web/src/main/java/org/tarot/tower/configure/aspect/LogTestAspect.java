package org.tarot.tower.configure.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @package: org.tarot.tower.configure.aspect
 * @author: 王子豪
 * @date: 2020/11/22 8:38
 * @description: 实现简单的日志切面
 * 依赖注入(DI)有助于应用对象之间的解耦，面向切面编程(AOP)有助于横切关注点与它们所影响的对象之间的解耦
 * AOP框架使用代理模式创建的对象，从而实现在连接点处插入通知(即应用切面)，就是通过代理来对目标对象应用切面。
 * Spring中，AOP代理可以用JDK动态代理或CGLIB代理CglibAopProxy实现。Spring中AOP代理由Spring的IOC容器
 * 负责生成、管理，其依赖关系也由IOC容器负责管理。因此，AOP代理可以直接使用容器中的Bean实例作为目标，这种关系
 * 可由IOC容器的依赖注入提供。Spring中创建代理的规则为口默认使用JDK动态代理来创建AOP代理，这样就可以为任何接
 * 口实例创建代理。当需要代理的类不是接口的时候，Spring会切换为使用CGLIB代理，也可强制使用CGLIB代理。
 */
@Component
@Aspect
public class LogTestAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogTestAspect.class);

    /**
     * AOP功能
     * 1.横切关注点(Cross-cutting Concerns)
     * 表示对哪些方法进行拦截，拦截后怎么处理
     *
     * 2.切面(Aspect)
     * Aspect注解将一个java类定义为切面类。类(Class)是对物体特征的抽象，切面(Aspect)是对横切关注点的抽象。
     * 在Aspect中会包含着Pointcut以及相应的Advice
     *
     * 3.连接点(Joint Point)
     * 被拦截到的点，例如被拦截的方法，对类成员的访问以及异常处理程序块的执行等等，它自身还可以嵌套其他JointPoint
     *
     * 4.切入点(Pointcut)
     * 使用@Pointcut定义一个切入点(规则表达式)。对连接点进行拦截定义。Pointcut表示一组JointPoint，这些JointPoint
     * 或是通过逻辑关系组合起来，或是通过通配、正则表达式等方式集中起来，它定义了相应的Advice将要发生的地方
     *
     * 5.通知(Advice)
     * 所谓通知指的就是指拦截到连接点之后要执行的代码，通知分为前置、后置、异常、最终返回、环绕通知等5种：
     * Advice定义了在 Pointcut里面定义的程序点具体要做的操作。通知类型分为：
     *      前置@Before：在切入点开始处切入内容
     *      后置@After：在切入点结尾处切入内容通知(Advice)
     *      最终返回@AfterReturning：在切入点return之后切人内容(返回值回调，可以用来对处理返回值做一些加工处理)
     *      环绕@Around：在切入点前后切入内容，并自己控制何时执行切入点自身的内容
     *      异常@AfterThrowing：用来处理当切入内容部分抛出异常之后的处理逻辑
     *
     * 6.目标对象(Target Object)
     * 目标对象表示需要被织入横切关注点的对象，即该对象是切入点选择的对象，需要被通知的对象，从而
     * 也可称为“被通知对象”;由于 Spring AOP 通过代理模式实现，从而这个对象永远是被代理对象
     *
     * 7.织入(Weaving)
     * 织入是一个是将切面应用到目标对象从而创建出AOP代理对象的过程。织入可以在编译期、类装载期、运行期进行。
     * 组装方面来创建一个被通知对象。这可以在编译时完成(例如使用 AspectJ 编译器)，也可以在运行时完成。
     * Spring和其他纯 Java AOP 框架一样，在运行时完成织入
     *
     * 8.引入(Introduction)
     * 在不修改代码的前提下，引入可以在运行期为类动态地添加一些方法或字段，为已有的类添加额外新的字段或方法，
     * Spring允许引入新的接口(对应一个实现)到所有被代理对象(目标对象)
     *
     * 9.AOP代理(AOP Proxy)
     * 在 Spring 中，AOP代理可以用JDK动态代理或CGLIB代理实现，而通过拦截器模型应用切面
     */
    /**
     * 连接点匹配类型
     * 1. execution(MethodSignature) 方法执行
     * 2. call(MethodSignature) 方法调用
     * 3. execution(ConstructorSignature) 构造器执行
     * 4. call(ConstructorSignature) 构造器调用
     * 5. staticinitialization(TypeSignature) 类初始化
     * 6. get(FieldSignature) 属性读操作
     * 7. set(FieldSignature) 属性写操作
     * 8. handler(FieldSignature) 处理执行
     * 9. initialization(ConstructorSignature) 对象初始化
     * 10.preinitialization(ConstructorSignature) 对象预先初始化
     */
    /**
     * AspectJ类型匹配通配符语法
     * controller.*.*(..) 代表子目录下的所有方法
     * '*' 代表匹配任何数量字符
     * '..' 代表匹配任何数量的字符重复 如类型模式匹配任何数量子包，方法参数模式中匹配任何数量参数
     * '+' 表示匹配指定类型的子类型，仅能作为后缀放在类型模式后边
     *
     * execution配置表达式语法
     * 权限 返回类型 包名.类名.方法名(参数)
     * 例如：
     * public Object org.tarot.tower.controller.RequestTestController.*(..))
     * * org.tarot.tower.controller.RequestTestController.*(..))
     * 等
     */
    //横切点(连接点) -- 本例只针对RequestTestController
    @Pointcut("execution(public * org.tarot.tower.controller.RequestTestController.*(..))")
    public void logPointCut() {

    }

    //环绕通知
    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object o = null;
        try {
            logger.info("Around: 方法环绕开始");
            long startTime = System.currentTimeMillis();
            o = pjp.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("Around: 方法环绕结束耗时为: " + (endTime - startTime));
            logger.info("Around: 方法环绕结果为: " + o);
        } catch (Throwable throwable) {
            logger.error(pjp.getSignature() + " 出现异常: " + throwable);
        }
        return o;
    }

    //方法执行前
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("请求地址: " + request.getRequestURL());
        logger.info("HTTP METHOD: " + request.getMethod());
        logger.info("IP: " + request.getRemoteAddr());
        logger.info("CLASS.METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        logger.info("参数: " + Arrays.toString(joinPoint.getArgs()));
    }

    //方法执行结束，不管是抛出异常或者正常退出都会执行
    @After(value = "logPointCut()")
    public void after(JoinPoint joinPoint) {
        logger.info("After 方法最后执行");
    }

    //方法执行后，增强处理
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) {
        logger.info("AfterReturning 方法的返回值: " + ret);
    }

    //方法异常时执行
    @AfterThrowing(value = "logPointCut()")
    public void doThrows(JoinPoint joinPoint){
        logger.error("AfterThrowing：方法异常时执行");
    }

}
