package com.linkedin.parseq;

import java.util.concurrent.TimeUnit;

import com.linkedin.parseq.function.Function1;
import com.linkedin.parseq.function.Consumer1;
import com.linkedin.parseq.function.Consumer3;
import com.linkedin.parseq.function.Function3;
import com.linkedin.parseq.function.Tuple3;

public interface Tuple3Task<T1, T2, T3> extends Task<Tuple3<T1, T2, T3>> {

  default <R> Task<R> map(final Function3<T1, T2, T3, R> f) {
    return map(tuple -> f.apply(tuple._1(), tuple._2(), tuple._3()));
  }

  default <R> Task<R> map(final String desc, final Function3<T1, T2, T3, R> f) {
    return map(desc, tuple -> f.apply(tuple._1(), tuple._2(), tuple._3()));
  }

  default <R> Task<R> flatMap(final Function3<T1, T2, T3, Task<R>> f) {
    return flatMap(tuple -> f.apply(tuple._1(), tuple._2(), tuple._3()));
  }

  default <R> Task<R> flatMap(final String desc, final Function3<T1, T2, T3, Task<R>> f) {
    return flatMap(desc, tuple -> f.apply(tuple._1(), tuple._2(), tuple._3()));
  }

  default Tuple3Task<T1, T2, T3> andThen(final Consumer3<T1, T2, T3> consumer) {
    return cast(andThen(tuple -> consumer.accept(tuple._1(), tuple._2(), tuple._3())));
  }

  default Tuple3Task<T1, T2, T3> andThen(final String desc, final Consumer3<T1, T2, T3> consumer) {
    return cast(andThen(desc, tuple -> consumer.accept(tuple._1(), tuple._2(), tuple._3())));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple3Task<T1, T2, T3> recover(final Function1<Throwable, Tuple3<T1, T2, T3>> f) {
    return cast(Task.super.recover(f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple3Task<T1, T2, T3> recover(final String desc, final Function1<Throwable, Tuple3<T1, T2, T3>> f) {
    return cast(Task.super.recover(desc, f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple3Task<T1, T2, T3> recoverWith(final Function1<Throwable, Task<Tuple3<T1, T2, T3>>> f) {
    return cast(Task.super.recoverWith(f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple3Task<T1, T2, T3> recoverWith(final String desc, final Function1<Throwable, Task<Tuple3<T1, T2, T3>>> f) {
    return cast(Task.super.recoverWith(desc, f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple3Task<T1, T2, T3> onFailure(final Consumer1<Throwable> consumer) {
    return cast(Task.super.onFailure(consumer));
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple3Task<T1, T2, T3> onFailure(final String desc, final Consumer1<Throwable> consumer) {
    return cast(Task.super.onFailure(desc, consumer));
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple3Task<T1, T2, T3> shareable() {
    return cast(Task.super.shareable());
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple3Task<T1, T2, T3> withTimeout(final long time, final TimeUnit unit) {
    return cast(Task.super.withTimeout(time, unit));
  };

  default Tuple3Task<T1, T2, T3> withSideEffect(Function3<T1, T2, T3, Task<?>> func) {
    return cast(Task.super.withSideEffect(tuple -> func.apply(tuple._1(), tuple._2(), tuple._3())));
  }

  default Tuple3Task<T1, T2, T3> withSideEffect(final String desc, Function3<T1, T2, T3, Task<?>> func) {
    return cast(Task.super.withSideEffect(desc, tuple -> func.apply(tuple._1(), tuple._2(), tuple._3())));
  }

  public static <T1, T2, T3> Tuple3Task<T1, T2, T3> cast(final Task<Tuple3<T1, T2, T3>> task) {
    return new Tuple3TaskDelegate<>(task);
  }

}
