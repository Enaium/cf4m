package cn.enaium.cf4m;

import cn.enaium.cf4m.manager.*;

/**
 * Project: cf4m
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class CF4M {
    /**
     * Instance.
     */
    private static CF4M instance;

    /**
     * Client package.
     */
    public String packName;

    /**
     * .minecraft/{clientName} path.
     */
    public String clientDataDir;

    /**
     * ClassManager.
     */
    public IClassManager classManager;

    /**
     * EventManager.
     */
    public EventManager event;

    /**
     * ModuleManager.
     */
    public ModuleManager module;

    /**
     * CommandManager.
     */
    public CommandManager command;

    /**
     * ConfigManager.
     */
    public ConfigManager config;

    /**
     * @param o             MainClass.
     * @param clientDataDir .minecraft/{clientName} path.
     */
    public CF4M(Object o, String clientDataDir) {
        instance = this;
        this.packName = o.getClass().getPackage().getName();
        this.clientDataDir = clientDataDir;
        this.classManager = new ClassManager();
    }

    /**
     * Start.
     */
    public void run() {

        event = new EventManager();
        module = new ModuleManager();
        command = new CommandManager();
        if (clientDataDir != null) {
            config = new ConfigManager();
            config.load();
        }
    }

    /**
     * Stop.
     */
    public void stop() {
        if (clientDataDir != null) {
            config.save();
        }
    }

    /**
     * @return Instance.
     */
    public static CF4M getInstance() {
        return instance;
    }
}
