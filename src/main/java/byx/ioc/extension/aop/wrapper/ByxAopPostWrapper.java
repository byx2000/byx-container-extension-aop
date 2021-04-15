package byx.ioc.extension.aop.wrapper;

import byx.aop.ByxAOP;
import byx.ioc.core.Container;
import byx.ioc.core.ObjectPostWrapper;
import byx.ioc.core.WrapperContext;
import byx.ioc.extension.aop.annotation.AdviceBy;

/**
 * 创建AOP代理的包装器
 *
 * @author byx
 */
public class ByxAopPostWrapper implements ObjectPostWrapper {
    @Override
    public Object doWrap(WrapperContext ctx) {
        Object obj = ctx.getObject();
        Container container = ctx.getContainer();

        // 如果标注了AdviceBy注解，则创建并返回AOP代理对象
        if (obj.getClass().isAnnotationPresent(AdviceBy.class)) {
            Class<?> adviceClass = obj.getClass().getAnnotation(AdviceBy.class).value();
            return ByxAOP.getAopProxy(obj, container.getObject(adviceClass));
        }

        // 否则直接返回原对象
        return obj;
    }
}
