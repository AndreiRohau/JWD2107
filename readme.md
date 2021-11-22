Self study (general understanding)
Thread example, how to process objs in multiple threads (flexible threads)
(Additional resources: 
https://www.baeldung.com/java-mutex
https://javarush.ru/groups/posts/2174-v-chem-raznica-mezhdu-mjhjuteksom-monitorom-i-semaforom
)
-------
synchronized - keyword

-------
volatile - keyword
_______
lock (ReentrantLock, ReentrantReadWriteLock are 'synchronized' alternatives)

-------

semaphore (CountDownLatch, Semaphore, CyclicBarrier, Phaser):

Mutex (or mutual exclusion) (single thread semaphore)
- the simplest type of synchronizer – it ensures that only one thread can execute the critical section of a computer program at a time

Semaphore
- allows working with common resource to specific amount of threads only
- offers to a thread to wait until other threads release the resource CyclicBarrier

CountDownLatch
- makes threads to wait until specific amount of operations will be done


CyclicBarrier
- offers to list of Threads to wait until they all reach a specific point, then barrier removes
______
DeadLock - during resource blocking operations threads stopped and cannot return to work