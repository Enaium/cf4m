package cn.enaium.cf4m.manager;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.Configuration;
import cn.enaium.cf4m.configuration.IConfiguration;
import com.google.common.collect.Lists;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Project: cf4m
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class ClassManager {
    private final ArrayList<Class<?>> classes = Lists.newArrayList();

    public ClassManager() {
        try {
            for (ClassPath.ClassInfo info : ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClasses()) {
                if (info.getName().startsWith(CF4M.INSTANCE.packName)) {
                    Class<?> type = Class.forName(info.getName());
                    if (type.isAnnotationPresent(Configuration.class)) {
                        CF4M.INSTANCE.configuration = (IConfiguration) type.newInstance();
                    }
                    classes.add(type);
                }
            }
        } catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

    public ArrayList<Class<?>> getClasses() {
        return classes;
    }
}
