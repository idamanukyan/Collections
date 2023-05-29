package com.company.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int capacity;
    private double loadFactor;
    private int size;
    private List<LinkedList<Entry>> buckets;

    public HashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.buckets = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }

    public void put(String key, Integer value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = buckets.get(bucketIndex);

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets.set(bucketIndex, bucket);
        }

        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.add(new Entry(key, value));
        size++;

        if ((double) size / capacity > loadFactor) {
            resize();
        }
    }

    public Integer get(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = buckets.get(bucketIndex);

        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    public void remove(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = buckets.get(bucketIndex);

        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public boolean containsKey(String key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry> bucket = buckets.get(bucketIndex);

        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(String key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        List<LinkedList<Entry>> newBuckets = new ArrayList<>(newCapacity);

        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(null);
        }

        for (LinkedList<Entry> bucket : buckets) {
            if (bucket != null) {
                for (Entry entry : bucket) {
                    int newIndex = entry.getKey().hashCode() % newCapacity;
                    LinkedList<Entry> newBucket = newBuckets.get(newIndex);

                    if (newBucket == null) {
                        newBucket = new LinkedList<>();
                        newBuckets.set(newIndex, newBucket);
                    }

                    newBucket.add(entry);
                }
            }
        }

        capacity = newCapacity;
        buckets = newBuckets;
    }
}
