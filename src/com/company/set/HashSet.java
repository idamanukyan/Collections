package com.company.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashSet {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private List<List<Integer>> buckets;
    private int size;

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    public boolean add(int element) {
        if (contains(element)) {
            return false; // Element already exists in the set
        }

        if ((double) size / buckets.size() >= LOAD_FACTOR) {
            resizeBuckets();
        }

        int bucketIndex = getBucketIndex(element);
        buckets.get(bucketIndex).add(element);
        size++;
        return true;
    }

    public boolean contains(int element) {
        int bucketIndex = getBucketIndex(element);
        List<Integer> bucket = buckets.get(bucketIndex);
        return bucket.contains(element);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeBuckets() {
        int newCapacity = buckets.size() * 2;
        List<List<Integer>> newBuckets = new ArrayList<>(newCapacity);

        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(new LinkedList<>());
        }

        for (List<Integer> bucket : buckets) {
            for (Integer element : bucket) {
                int bucketIndex = element.hashCode() % newCapacity;
                newBuckets.get(bucketIndex).add(element);
            }
        }

        buckets = newBuckets;
    }

    private int getBucketIndex(Integer element) {
        int hashCode = element.hashCode();
        return hashCode % buckets.size();
    }


}
