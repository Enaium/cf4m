---
sidebar: auto
---

# Guide

## Install

### Maven

```xml
<repositories>
    <repository>
        <name>Enaium</name>
        <id>Enaium</id>
        <url>https://enaium.gitee.io/maven/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>cn.enaium</groupId>
        <artifactId>cf4m</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Gradle

```groovy
dependencies {
    compile group: 'cn.enaium', name: 'cf4m', version: '1.0.0'
}

repositories {
	maven { url 'https://enaium.gitee.io/maven/' }
}
```

### Libraries

[releases](https://github.com/Enaium/cf4m/releases)

## Usage

::: warning
Currently only Event, Module and Setting
:::

### Instance

Create the main class.

```java
public enum Example {

    instance;

    public CF4M cf4M = new CF4M(this);

}
```

### Start and Stop

Use `Start` and `Stop` in game Start and Stop.

`Example.instance.cf4M.start();` `Example.instance.cf4M.start();`


### Event

::: tip
2 events are built into CF4M (KeyboardEvent,UpdateEvent)
:::

::: warning 
You must `new KeyboardEvent(keyCode).call();` `new UpdateEvent().call();` can be used
:::

### Module

::: warning
Must be under the sibling package as the main class
:::

Create the `Sprint` class.

```java
@ModuleAT
public class Sprint extends Module {
    public Sprint() {
        super("Sprint", "Sprint", Keyboard.KEY_V, Category.MOVEMENT);
    }

    @EventTarget
    private void onUpdate(UpdateEvent updateEvent) {
        Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
}
```

::: tip
Plus `@ModuleAT` annotation CF4M will automatically add it to ModuleManager for you
:::

### Setting

```java
    @SettingAT
    private EnableSetting test1 = new EnableSetting(this, "test1", "test1", false);

    @SettingAT
    private IntegerSetting test2 = new IntegerSetting(this, "test1", "test1", 1, 1, 1);

    @SettingAT
    private FloatSetting test3 = new FloatSetting(this, "test1", "test1", 1.0F, 1.0F, 1.0F);

    @SettingAT
    private DoubleSetting test4 = new DoubleSetting(this, "test1", "test1", 1.0D, 1.0D, 1.0D);

    @SettingAT
    private LongSetting test5 = new LongSetting(this, "test1", "test1", 1L, 1L, 1L);

    @SettingAT
    private ModeSetting test6 = new ModeSetting(this, "test1", "test1", "Mode1", Arrays.asList("Mode1", "Mode2"));

    public Sprint() {
        super("Sprint", "Sprint", Keyboard.KEY_V, Category.MOVEMENT);
    }

    @EventTarget
    private void onUpdate(UpdateEvent updateEvent) {
        Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
```

::: tip
Plus `@SettingAT` annotation CF4M will automatically add it to SettingManager for you
:::

