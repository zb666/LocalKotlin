package com.coroutine.bod.localkotlin;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: JavaA
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-11-30
 */
@IPermiss(age = 1,array = {1,2})
public class JavaA {
    int value[] = {1,2,3};
    private String name=  " name";
    void  main(){
        Type superclass = getClass().getGenericSuperclass(); //继承
        //取泛型数组中的
        Type[] superType = getClass().getGenericInterfaces(); //接口实现
        //获取泛型列表
       ParameterizedType parameterizedType = (ParameterizedType) superType[0];
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Set set = new HashSet();
        set.add("");
        getUnion(new HashSet<String>(222));
    }

    @SuppressWarnings("unchecked")
    private synchronized void getUnion(Set<String> s1){
        int size = s1.size();
    }
}
