package scala.concurrent.stm.stubs

import scala.concurrent.stm._
import scala.concurrent.stm.Ref._
import java.util.concurrent.TimeUnit

object StubRef {
	trait StubView[A] extends Ref.View[A] {
		//from Sink.View[A]
		def set(v: A): Unit = atomic(implicit t => ref.set(v))
		def trySet(v: A): Boolean = atomic(implicit t => ref.trySet(v))

		//from Source.View[A]
		def get: A = atomic(implicit t => ref.get)
		def getWith[Z](f: A => Z): Z = atomic(implicit t => ref.getWith(f))
		def relaxedGet(equiv: (A, A) => Boolean): A = atomic(implicit t => ref.relaxedGet(equiv))
		def await(f: A => Boolean) = atomic(implicit t => if (!f(get)) retry)
		def tryAwait(timeout: Long, unit: TimeUnit = TimeUnit.MILLISECONDS)(f: A => Boolean): Boolean =
			atomic(implicit t => f(get) || { retryFor(timeout, unit); false })

		//from Ref.View[A]
		//def ref: Ref[A] // Make sure that any implementation has at least this
		def swap(v: A): A = atomic(implicit t => ref.swap(v))
		def compareAndSet(before: A, after: A): Boolean = atomic(implicit t => (if (before == get) { set(after); true } else false))
		def compareAndSetIdentity[B <: A with AnyRef](before: B, after: A): Boolean = atomic(implicit t => (if (before eq get) { set(after); true } else false))
		def transform(f: A => A) = atomic(implicit t => ref.transform(f))
		def getAndTransform(f: A => A): A = atomic(implicit t => ref.getAndTransform(f))
		def transformAndGet(f: A => A): A = atomic(implicit t => ref.transformAndGet(f))
		def transformIfDefined(pf: PartialFunction[A, A]): Boolean = atomic(implicit t => ref.transformIfDefined(pf))

		// Ref.View that refer to the same memory location should be equal.
		// override def hashCode: Int = ref.hashCode
		// override def equals(any: Any): Boolean = ref.equals(any)
	}
}

trait StubRef[A] extends Ref[A] {
	//from SourceLike[A]:
	def get(implicit txn: InTxn): A = throw new AbstractMethodError
	def getWith[Z](f: (A) => Z)(implicit txn: InTxn): Z = throw new AbstractMethodError
	def relaxedGet(equiv: (A, A) => Boolean)(implicit txn: InTxn): A = throw new AbstractMethodError

	//from SinkLike[A]
	def set(v: A)(implicit txn: InTxn): Unit = throw new AbstractMethodError
	def trySet(v: A)(implicit txn: InTxn): Boolean = throw new AbstractMethodError

	//from RefLike[A]
	def swap(v: A)(implicit txn: InTxn): A = throw new AbstractMethodError
	def transform(f: A => A)(implicit txn: InTxn) = throw new AbstractMethodError
	def transformIfDefined(pf: PartialFunction[A, A])(implicit txn: InTxn): Boolean = throw new AbstractMethodError

	//from Ref[A]
	def single: View[A] = { val currentRef = this; new StubRef.StubView[A]() { override def ref = currentRef } }
}