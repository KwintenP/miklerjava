package com.blogspot.mikler.java;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;

public class ExampleCacheProvider {
    private CacheManager cacheManager;
    private CacheEntryFactory updatingFactory;
    public SelfPopulatingCache selfPopulatingCache;

    public ExampleCacheProvider() throws Exception {
        cacheManager = CacheManager.create();
        Ehcache  originalCache = cacheManager.getCache("com.blogspot.mikler.java.cache");

        final String cacheType = System.getProperty("com.blogspot.mikler.java.cache.factory");
        if (cacheType == null || cacheType.equals("create")){
            updatingFactory = new ExampleCacheEntryFactory();
        } else {
            updatingFactory = new ExampleUpdatingCacheEntryFactory();
        }
        selfPopulatingCache = new SelfPopulatingCache(originalCache, updatingFactory);
        //chache refresh thread
        Thread updatingThread = new Thread(){
            public void run() {
                super.run();
                while (true){
                    System.out.println("!!!!! Doing refresh !!!!!");
                    selfPopulatingCache.refresh();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                }
            }
        };
        updatingThread.setDaemon(true);
        updatingThread.start();

    }

    public Ehcache getCache(){
        return selfPopulatingCache;
    }
}
