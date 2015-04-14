package com.linkedin.parseq;

import java.util.concurrent.TimeUnit;

import com.linkedin.parseq.function.Function1;
import com.linkedin.parseq.function.Consumer1;
import com.linkedin.parseq.function.Consumer9;
import com.linkedin.parseq.function.Function9;
import com.linkedin.parseq.function.Tuple9;

public interface Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Task<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {

  default <R> Task<R> map(final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
    return map(tuple -> f.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9()));
  }

  default <R> Task<R> map(final String desc, final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
    return map(desc, tuple -> f.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9()));
  }

  default <R> Task<R> flatMap(final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Task<R>> f) {
    return flatMap(tuple -> f.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9()));
  }

  default <R> Task<R> flatMap(final String desc, final Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Task<R>> f) {
    return flatMap(desc, tuple -> f.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9()));
  }

  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> andThen(final Consumer9<T1, T2, T3, T4, T5, T6, T7, T8, T9> consumer) {
    return cast(andThen(tuple -> consumer.accept(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9())));
  }

  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> andThen(final String desc, final Consumer9<T1, T2, T3, T4, T5, T6, T7, T8, T9> consumer) {
    return cast(andThen(desc, tuple -> consumer.accept(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9())));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> recover(final Function1<Throwable, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> f) {
    return cast(Task.super.recover(f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> recover(final String desc, final Function1<Throwable, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> f) {
    return cast(Task.super.recover(desc, f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> recoverWith(final Function1<Throwable, Task<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>> f) {
    return cast(Task.super.recoverWith(f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> recoverWith(final String desc, final Function1<Throwable, Task<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>> f) {
    return cast(Task.super.recoverWith(desc, f));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> onFailure(final Consumer1<Throwable> consumer) {
    return cast(Task.super.onFailure(consumer));
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> onFailure(final String desc, final Consumer1<Throwable> consumer) {
    return cast(Task.super.onFailure(desc, consumer));
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> shareable() {
    return cast(Task.super.shareable());
  };

  /**
   * {@inheritDoc}
   */
  @Override
  public default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> withTimeout(final long time, final TimeUnit unit) {
    return cast(Task.super.withTimeout(time, unit));
  };

  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> withSideEffect(Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Task<?>> func) {
    return cast(Task.super.withSideEffect(tuple -> func.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9())));
  }

  default Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> withSideEffect(final String desc, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Task<?>> func) {
    return cast(Task.super.withSideEffect(desc, tuple -> func.apply(tuple._1(), tuple._2(), tuple._3(), tuple._4(), tuple._5(), tuple._6(), tuple._7(), tuple._8(), tuple._9())));
  }

  public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9Task<T1, T2, T3, T4, T5, T6, T7, T8, T9> cast(final Task<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> task) {
    return new Tuple9TaskDelegate<>(task);
  }

}
