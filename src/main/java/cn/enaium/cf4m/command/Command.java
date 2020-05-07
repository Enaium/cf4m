package cn.enaium.cf4m.command;

import java.util.List;

/**
 * Project: cf4m
 * -----------------------------------------------------------
 * Copyright © 2020 | Enaium | All rights reserved.
 */
public interface Command {
    void run(String[] args);

    List<String> usage();
}
