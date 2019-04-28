import java.sql.SQLException;

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