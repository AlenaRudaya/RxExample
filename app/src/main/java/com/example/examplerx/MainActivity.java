package com.example.examplerx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {


    private class Something {

        void execute() {
            String threadName = Thread.currentThread().getName();
             Log.v("Hello darkness my old friend i come to talk to you again", threadName);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Runnable task = new Something()::execute;

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello darkness my old friend" + threadName);
        };

        task.run();
        Thread thread = new Thread(task);
        thread.start();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Something()::execute);



//        Converter<String, String> converter = new Something()::startsWith;
//        String converted = converter.convert("123");
//
//
//
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//
//        Collections.sort(names, (a, b) -> b.compareTo(a));


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        Observable<String> a = Observable.create(s -> {
//            new Thread(() -> {
//                s.onNext("one");
//                s.onNext("two");
//                s.onCompleted();
//            }).start();
//        });
//        Observable<String> b = Observable.<String>create(s -> {
//                    Log.v("Subscriber Call", "Call");
//                    s.onNext("three");
//                    s.onNext("four");
//                    s.onCompleted();
//            s.add();
//                }
//        ).cache();


//        Log.v("Subscriber Start", "Start");
//        b.subscribe(i -> Log.v("Element A: ", i));
//        b.subscribe(i -> Log.v("Element B: ", i));
//        Log.v("Subscriber End", "End");


//        Observable<String> c = Observable.merge(a, b);
//        c.subscribe(new Observer<String>() {
//
//            @Override
//            public void onCompleted() {
//                Log.v("Subscriber complete", "complete");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.v("Subscriber error ", "error");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.v("Subscriber onNext", "! " + s);
//            }
//
//        });


//        final List<String> urls = new ArrayList<>();
//        urls.add("udrl1");
//        urls.add(null);
//        urls.add("urddddddl3");
//        urls.add(null);
//        Observable<String> myObservableStart = Observable.from(urls);

        //   final Observable<String> myObservableTitle = Observable.just(null);

        //  Observable<String> myObservable = Observable.from(urls);

//        final Action1<String> onNextAction = new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.v("Subscriber", s);
//            }
//        };

        // Observable.from(urls).subscribe(onNextAction)
//        myObservableStart.subscribe(new Action1<List<String>>() {
//            @Override
//            public void call(List<String> strings) {
//                Observable.from(urls).subscribe(onNextAction);
//            }
//        });

//
//        myObservableStart
////                .flatMap(new Func1<List<String>, Observable<String>>() {
////                    @Override
////                    public Observable<String> call(List<String> strings) {
////                        return Observable.from(urls);
////                    }
////                })
//                .map(new Func1<String, Integer>() {
//                    @Override
//                    public Integer call(String s) {
//                        return s.length();
//                    }
//                })
////                .flatMap(new Func1<String, Observable<String>>() {
////                    @Override
////                    public Observable<String> call(String s) {
////                        return myObservableTitle;
////                    }
////                })
////                .filter(new Func1<String, Boolean>() {
////                    @Override
////                    public Boolean call(String s) {
////                        return !TextUtils.isEmpty(s);
////                    }
////                })
//                //   .doOnNext()
//                //  .subscribe(onNextAction);
//
//                .subscribe(new Observer<Integer>() {
//
//                    @Override
//                    public void onCompleted() {
//                        Log.v("Subscriber complete", "complete");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.v("Subscriber error ", "error");
//                    }
//
//                    @Override
//                    public void onNext(Integer s) {
//                        Log.v("Subscriber onNext", "! " + s);
//                    }
//
//                });


    }


//    Subscriber<String> mySubscriber = new Subscriber<String>() {
//        @Override
//        public void onNext(String s) {
//            Log.v("Subscriber", "Hello World");
//        }
//
//        @Override
//        public void onCompleted() {
//        }
//
//        @Override
//        public void onError(Throwable e) {
//        }
//    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
