package com.company.concurrency;

import java.util.concurrent.Semaphore;

class FooBar {
  private int n;
  Semaphore semaphore = new Semaphore(1);
  Semaphore semaphoreBar = new Semaphore(1);




  public FooBar(int n) {
    try {
      this.n = n;
      semaphoreBar.acquire();
    } catch (InterruptedException e){}
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      semaphore.acquire();
      printFoo.run();
      semaphoreBar.release();

    }

  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      semaphoreBar.acquire();
      printBar.run();
      semaphore.release();

    }

  }
}
