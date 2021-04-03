package cn.enaium.cf4m.provider;

/**
 * Project: cf4m
 * Author: Enaium
 */
public interface CommandProvider extends Provider {
    /**
     * NotNull
     *
     * @return command key
     */
    String[] getKey();
}