package com.kylee.rxjava;

import io.reactivex.Observable;
import rx.Observer;
import io.reactivex.Single;
import io.reactivex.observables.ConnectableObservable;
import rx.subjects.PublishSubject;


import java.util.concurrent.TimeUnit;

public class RxJava2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
//        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
//        StringBuilder e = new StringBuilder();
//        StringBuilder o = new StringBuilder();
//        Observable.from(numbers)
//                .groupBy(i -> 0 == (i % 2) ? "EVEN" : "ODD")
//                .subscribe(group ->
//                        group.subscribe((number) -> {
//                            if (group.getKey().toString().equals("EVEN")) {
//                                e.append(number);
//                                //System.out.println(number);
//                            } else {
//                                o.append(number);
//                                //System.out.println(number);
//                            }
//                        })
//                );
//
//
//
//
//        System.out.println("even::" + e);
//        System.out.println("odd::" + o);
////        assertTrue(EVEN[0].equals("0246810"));
////        assertTrue(ODD[0].equals("13579"));
//
//        StringBuffer result = new StringBuffer();
//        Observable.from(numbers)
//                .filter(i -> (i % 2 == 1))
//                .subscribe(i -> result.append(i));
//        System.out.println(result);
//
//        Observable.empty()
//                .defaultIfEmpty("Observable is empty")
//                .subscribe(s -> result.append(s));
//        System.out.println(result);
//
//        Observable.from(numbers)
//                .takeWhile(i -> i < 5)
//                .subscribe(s -> result.append(s));
//        System.out.println(result);

//        String[] rx = {""};
//        ConnectableObservable<Long> connectable
//                = io.reactivex.Observable.interval(200, TimeUnit.MILLISECONDS).publish();
//        connectable.subscribe(i -> rx[0] += i);
//        System.out.println(rx[0]);
//
//        connectable.connect();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//        }
//
//        System.out.println(rx[0]);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//        }
//
//        System.out.println(rx[0]);


//        String[] result = {""};
//        Single<String> single;
//        single = Observable.just("Hello")
//                .singleOrError()
//                //.single("Hello")
//                .doOnSuccess(i -> result[0] += i)
//                .doOnError(error -> {
//                    throw new RuntimeException(error.getMessage());
//                });
//        single.subscribe();
//        System.out.println(result[0]);
//        System.out.println((result[0].equals("Hello")));



//        PublishSubject<Integer> subject = PublishSubject.create();
//        subject.subscribe(getFirstObserver());
//        subject.onNext(1);
//        subject.onNext(2);
//        subject.onNext(3);
//        subject.subscribe(getSecondObserver());
//        subject.onNext(4);
//        subject.onCompleted();
//
//        System.out.println(subscriber1);
//        System.out.println(subscriber2);
        //assertTrue(subscriber1 + subscriber2 == 14);


        String[] result = {""};
        rx.Observable<Character> values = rx.Observable.using(
                () -> "MyResource",
                r -> {
                    return rx.Observable.create(o -> {
                        for (Character c : r.toCharArray()) {
                            o.onNext(c);
                        }
                        o.onCompleted();
                    });
                },
                r -> System.out.println("Disposed: " + r)
        );
        values.subscribe(
                v -> result[0] += v,
                e -> result[0] += e
        );

        System.out.println(result[0]);
    }
    static Integer subscriber1 = 0;
    static Integer subscriber2 = 0;

    static Observer<Integer> getFirstObserver() {
        return new Observer<Integer>() {
            @Override
            public void onNext(Integer value) {
                subscriber1 += value;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onCompleted() {
                System.out.println("Subscriber1 completed");
            }
        };
    }

    static Observer<Integer> getSecondObserver() {
        return new Observer<Integer>() {
            @Override
            public void onNext(Integer value) {
                subscriber2 += value;
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onCompleted() {
                System.out.println("Subscriber2 completed");
            }
        };
    }

}
