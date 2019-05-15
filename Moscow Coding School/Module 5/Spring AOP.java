import java.sql.SQLException;

import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

Аспектно ориентированное програмирование

пример
public class OrderService{
    public Order getOrder(Integer id){
        return orderDAO.getOrder(id);
    }
}

добавим логирование

public Order getOrder(Integer id){
    log.debug("Call method getOrder with id " + id);
    Order order = orderDAO.getOrder(id);
    log.debug("Order info is " + order.toString());
    return order;
}

добавим обработку исключений

public Order getOrder(Integer id) throws ServiceException{
    log.debug("Call method getOrder with id " + id);
    Order order = null;
    try {
    Order order = orderDAO.getOrder(id);
    }
    catch(SQLException e){
        throw new ServiceException(e);
    }
    log.debug("Order info is " + order.toString());
    return order;
}

добавим проверку прав доступа

public Order getOrder(Integer id) throws ServiceException, AuthException{
    if (!SecurityContext.getUser().hasRight("getOrder")){
        throw new AuthException("Permission Denied");
    }
    log.debug("Call method getOrder with id " + id);
    Order order = null;
    try {
    Order order = orderDAO.getOrder(id);
    }
    catch(SQLException e){
        throw new ServiceException(e);
    }
    log.debug("Order info is " + order.toString());
    return order;
}

добавим кэширование результатов

public Order getOrder(Integer id) throws ServiceException, AuthException{
    if (!SecurityContext.getUser().hasRight("getOrder")){
        throw new AuthException("Permission Denied");
    }
    log.debug("Call method getOrder with id " + id);
    Order order = null;
    try {
        if (cache.contains(cacheKey)){
            order = (Order)cache.get(cacheKey);
        }
        else{
         Order order = orderDAO.getOrder(id);
         cache.put(cacheKey, user);
        }
    }
    catch(SQLException e){
        throw new ServiceException(e);
    }
    log.debug("Order info is " + order.toString());
    return order;
}

Что бы делать все сервисные моменты но не сильно увеличивать общий код метода можно вынести сервисный код в отдельные классы - аспекты

Как работает аспект

Сделать что то до вызова метода (обработка входных аргументов) - вызвать исходный метод - сделать что то после вызова метода (обработка результатов)

public UserDTO getUser(Integer id){
    log.debug("Call..." + id); // logging aspect
    UserDTO user = userDAO.getUser(id);
    log.debug("Order.." + user.toString()); // logging aspect
    return user;
}

пример аспекта для логгирования

@Aspect // подключаемая сервисная функциональность которая позволяет модифицировать изначальный код 
public class LoggingAspect{
    private final static Logger log = Logger.getLogger(LoggingAspect.class);

    @Pointcut ("execution(**service.*(..))") // аспект будет применен к любому методу коорый будет заканчиваться на сервис
    public void serviceMethod(){
    }

    @Around ("serviceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint){
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs(); 
        log.debug("Call method " + methodName + " with args " + methodArgs );
        Object result = thisJoinPoint.proceed(); // вызоов изначального метода
        log.debug("result...");
        return result;
      }
}

XML конфиг для использования AOP
<aop:aspect-autoproxy/> //директива для авто генерации прокси если класс анотирован как Аспект она анализирует что за шаблон и к чему он должен применятся
// и применяется ко всем методам которые удовлетворяют шаблону

<bean id="orderDao" class="OrderDaoImpl"/>
<bean name="loggingAspect" class="LogginAspect"/> 
</beans>


ЯЗЫК POINTCUT
execution определяет pointcut на основе сигнатуры метода
execution(@CustomAnnotation? modifiers-pattern? ret-type-pattern declaring-type-pattern? .name-pattern(param-pattern) throws-pattern?)
? - опциональный параметр
declaring-type-pattern - Шаблон для метода и имени класса

примеры
execution(* *(..)) = методы с любой сигнатурой
execution(int *(..)) - любые методы возвращающие инт
execution(* com.package.subpackage.Classname.*(..)) - любой метод   из класса com.package.subpackage.Classname.
execution(@Test * *(..)) - метод с любой сигнатурой, помеченный аннотацией тест
bean - bean("*Bean") - отибрает все бины заканчиваешьсяна Bean
within - любой метод внутри класса

Advice @Around  - выполняется вместо начального вызова, позволяя определить логику до и после вызова

Юз кейс - найти ботлнек в программе для оптимизации выполнения
- проверка прав доступа
- работа с исключениями

Типы Advice

@Before - выполняется до точки подсоединения
@Around - вместо изначального метода 
@After - выполняется после завершения метода в любом случае
@AfterReturning - выполяется после успешного завершения метода
@AfterThrowing - выполняется после исключения из метода

Аннотация @Order
Порядок выполнения аспектов может быть задан аннотацией @Order
@Aspect
@Order(1)

@Aspect
@Order(2)