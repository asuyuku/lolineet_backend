package com.lolineet.standard.base;

import com.lolineet.standard.exception.LolineetException;

public class SnowFlakeGenerator {

    /**
     * 开始时间戳
     */
    private static final long orig = 631468800000L;

    /**
     * Worker ID所占的位数
     */
    private final long workerBits = 5L;

    /**
     * DataCenter ID所占的位数
     */
    private final long dataCenterBits = 5L;

    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private final long maxWorkID = ~(-1L << workerBits);

    /**
     * 支持的最大数据中心ID
     */
    private final long maxDataCenterID = ~(-1L << dataCenterBits);

    /**
     * Sequence所占的位数
     */
    private final long sequenceBits = 12L;

    /**
     * Worker ID移位
     */
    private final long workerIDShift = sequenceBits;

    /**
     * DateCenter ID移位
     */
    private final long dataCenterShift = sequenceBits + workerBits;

    /**
     * Timestamp左移位
     */
    private final long timestampLeftShift = sequenceBits + workerBits + dataCenterBits;

    /**
     * Sequence Mask
     */
    private final long sequenceMask = ~(-1L << sequenceBits);//-1L ^ (-1L << sequenceBits)

    private long workerID;
    private long dataCenterID;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowFlakeGenerator(long workerID, long dataCenterID) {

        if (workerID > maxWorkID || workerID < 0L) {

            throw new IllegalArgumentException(String.format("worker ID can't be greater than %d or less than 0", maxWorkID));

        }

        if (dataCenterID > maxDataCenterID || dataCenterID < 0L) {

            throw new IllegalArgumentException(String.format("data center ID can't be greater than %d or less than 0", maxDataCenterID));

        }

        this.workerID = workerID;

        this.dataCenterID = dataCenterID;

    }


    /**
     * 获取下一个ID
     */
    public synchronized long next() {

        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {

            throw new LolineetException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));

        }

        if (timestamp == lastTimestamp) {

            sequence = (sequence + 1) & sequenceMask;

            if (sequence == 0) {
                timestamp = tillNextMillis(lastTimestamp);
            }

        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - orig) << timestampLeftShift) |
                (dataCenterID << dataCenterShift) |
                (workerID << workerIDShift) |
                sequence;


    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    protected long tillNextMillis(long lastTimestamp) {

        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {

            timestamp = timeGen();

        }

        return timestamp;

    }

}
