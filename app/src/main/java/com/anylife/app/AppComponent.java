package com.anylife.app;

import com.anylife.jsbridge.dagger.JSBridgeModuleAllActivityModule;
import com.zenglb.framework.dagger.AModuleAllActivityModule;
import com.zlb.base.BaseApplication;
import com.zlb.dagger.module.BaseGlobalModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * 全局的单例的东西提到这里来，比如SharedPrefenced,DaoSession 等等 ！
 *
 * Created by anylife.zlb@gmail.com on 2018/1/11.
 */
@Singleton
@Component(modules = {
        BaseGlobalModule.class,         //全局的Module,要确保提供的对象是全局唯一的

        AndroidInjectionModule.class,   //在应用程序的MainComponent（application 中inject了）中，注入AndroidInjectionModule，
        // 以确保Android的类(Activity、Fragment、Service、BroadcastReceiver及ContentProvider等)可以绑定。
        // 一般把AndroidInjectionModule放在ApplicationComponent中，其他的Component依赖Application即可
        AndroidSupportInjectionModule.class,  //使用的Fragment 是V4 包中的？不然就只需要AndroidInjectionModule

        //下面的是ABCD 等Module 的Activity 需要依赖注入的ActivityModule 配置

        AModuleAllActivityModule.class, //减少模版代码,需要依赖注入的只需要添加两行代码就好了
        JSBridgeModuleAllActivityModule.class,

})

//YourApplicationComponent
public interface AppComponent {

    void inject(BaseApplication application);

}
