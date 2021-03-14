package com.codegym.task.task37.task3708.retrievers;

import com.codegym.task.task37.task3708.cache.LRUCache;
import com.codegym.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{

    //fields
    OriginalRetriever originalRetriever;
    LRUCache<Long, Object> lruCache;

    //costr
    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(20);
    }

    @Override
    public Object retrieve(long id) {

        Object foundObject = lruCache.find(id);
        if (foundObject != null) return foundObject;

        Object objectToPutToCacheAndToReturn = originalRetriever.retrieve(id);
        lruCache.set(id, objectToPutToCacheAndToReturn);
        return objectToPutToCacheAndToReturn;

    }
}