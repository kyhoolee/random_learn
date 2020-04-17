package com.kylee.rxjava;
import io.reactivex.Flowable;
public class ReactTut {
    /**
     * ReactiveX -> program reacts as and when data appears
     *  event-based programming concepts
     *  events can propagate to registers observers
     */

    /**
     * Extends observer pattern
     * Support sequences of data/events
     * Provides operators to compose sequences together declarative
     * Handle threading, synchronization, thread-safety and concurrent data structure internally
     */

    /**
     * Observable - represent an object similar to stream - can emit data, send message
     * Observer  - subscribe to Observable's data of sequence - reacts per item of the observable
     */

    public static void main(String[] args) {
        Flowable.just("Hello World!").subscribe(System.out::println);
    }

    /*
    - Flowable
    0..N flows, Emits 0 or n items - supports reactive-streams and back-pressure

    - Observable
    0..N flows, but no back-pressure

    - Single
    1 item or error - can be treated as a reactive version of method call

    - Completable
    No item emitted - used as a signal for completion or error - can be treated as a reactive version of Runnable

    - MayBe
    Either No item or 1 item emitted - can be treated as a reactive version of Optional

    - just(T item)
    Returns an Observable that signals the given item and then completes

    - fromIterable(Iterable source)
    Convert an Iterable sequence into an ObservableSource that emits the items in the sequence

    - fromArray(T... items)
    Converts an Array into an ObservableSource that emits the items in the Array

    - fromCallable(Callable supplier)
    Return an Observable that - when an observer subscribes to it, invoke a function and then emits the value returned from that function

    - fromFuture(Future future)
    Convert a Future into an ObservableSource

    - interval(long initialDelay, long period, TimeUnit unit)
    Returns an Observable that emits a 0L after the initialDelay and ever increasing numbers after each period of time thereafter

     */
}
