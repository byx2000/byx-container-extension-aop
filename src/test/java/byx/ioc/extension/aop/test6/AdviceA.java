package byx.ioc.extension.aop.test6;

import byx.aop.annotation.After;
import byx.aop.annotation.Filter;
import byx.ioc.annotation.Component;

@Component
public class AdviceA {
    @After @Filter(name = "f")
    public int after(int retVal) {
        return retVal + 1;
    }
}
