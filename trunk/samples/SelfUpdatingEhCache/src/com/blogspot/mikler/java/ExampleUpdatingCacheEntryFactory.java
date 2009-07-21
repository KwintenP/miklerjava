package com.blogspot.mikler.java;

import net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory;

/**
 * TODO Class description
 *
 * @author Mikhail Kolesnik
 *         Timestamp: Jul 21, 2009 4:53:47 PM
 */
public class ExampleUpdatingCacheEntryFactory extends ExampleCacheEntryFactory
                                              implements UpdatingCacheEntryFactory {
    public void updateEntryValue(Object key, Object value) throws Exception {
        System.out.println("~~~~~~UPDATING entry for key = " + key);
        final StringBuffer stringBuffer = (StringBuffer) value;
        stringBuffer.append(stringBuffer.length());
    }

}
